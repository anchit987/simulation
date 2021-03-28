package simulation;

import java.util.*;

public class IOManager {
	public int totalProcessInIOManager = 0;
	public Queue<Process> IOManagerQueue = new LinkedList<Process>();

	public void addProcessToIOManager(Process p) {
		totalProcessInIOManager += 1;
		p.IOStartTime = Clock.timer;
		IOManagerQueue.add(p);
	}

	public void runIOManagerFor1Second() {
		// First check if there is process in IOManager Or not
		System.out.println("----IOManager----");
		if (IOManagerQueue.isEmpty()) {
			System.out.println("No process in IOManager");
			return;
		}

		try {
			Process p = IOManagerQueue.peek();

			// It will run for the first time when the process start executing in IO
			if (!p.IOStart) {

				System.out.println("Process " + p.pid + ": starts executing in IOManager");

				p.IOStartTime = Clock.timer;
				// IOTime will increased by 5% with increase in totalProcessINIOManager as per
				// Question Demand
				p.IOTime = p.IOTime + p.IOTime * 5 / 100 * (totalProcessInIOManager - 1);
				p.IORemaining = p.IOTime;
				p.IOStart = true;
			}

			if (p.IORemaining <= 1000) {
				long timeLeftAfterCurrentIO = 1000 - p.IORemaining;
				p.IOFinshTime = Clock.timer + p.IORemaining;
				p.IORemaining = 0;
				Thread.sleep(p.IORemaining);
				System.out.println("Process with id: " + p.pid + " is completed its IO");

				IOManagerQueue.remove();
				totalProcessInIOManager--;

				// If some time remains after completing previous process
				// It will start executing next process if we have
				if (timeLeftAfterCurrentIO > 0) {
					Thread.sleep(timeLeftAfterCurrentIO);
					if (IOManagerQueue.isEmpty()) {
						System.out.println("No process in IOManager");
						return;
					}
					Process nextProcess = IOManagerQueue.peek();
					nextProcess.IOStart = true;

					// IOTime will increased by 5% with increase in totalProcessINIOManager
					nextProcess.IOTime = nextProcess.IOTime
							+ nextProcess.IOTime * 5 / 100 * (totalProcessInIOManager - 1);
					nextProcess.IORemaining = nextProcess.IOTime;

					System.out.println("Process " + nextProcess.pid + ": starts executing in IOManager");

				}
			} else {
				p.IORemaining -= 1000;
				System.out.println("Process " + p.pid + " is currently executing in IOManager. IO time remains: "
						+ p.IORemaining + "ms");
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Number of process in IOManager: " + totalProcessInIOManager);
	}

}
