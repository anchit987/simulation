package simulation;

import java.util.*;

public class CPUManager implements Runnable {
	static long timeQuantum = 100;
	static int totalProcessInCPUManager = 0;

	public Queue<Process> CPUManagerQueue = new LinkedList<Process>();

	public void addProcessToCPUManager(Process p) {
		totalProcessInCPUManager += 1;
		CPUManagerQueue.add(p);
	}

	public void runCPUManagerFor1Second() {
		System.out.println("----CPUManager----");
		try {
			for (long i = 0; i < 1000; i += 100) {
				if (CPUManagerQueue.isEmpty()) {
					System.out.println("No process in CPUManager");
					return;
				}
				Process p = CPUManagerQueue.peek();
				System.out.println("Process " + p.pid + ": is running in CPUManager");
				CPUManagerQueue.remove();
				if (p.CPURemaining <= 100) {
					// CPURemaining will always be in multiple of 100
					p.CPURemaining = 0;
					p.CPUFinishTime = Clock.timer + i * 100;
					totalProcessInCPUManager -= 1;
				} else {
					p.CPURemaining -= 100;
					CPUManagerQueue.add(p);
				}
				Thread.sleep(50);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Number of process in CPUManager: " + totalProcessInCPUManager);
	}

	public void run() {
		runCPUManagerFor1Second();
	}
}
