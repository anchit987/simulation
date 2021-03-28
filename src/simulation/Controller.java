package simulation;

import java.util.*;

public class Controller {
	static int totalProcessesAdded = 0;
	static boolean noMoreInputs = false;
	static long processRate = 3000; // In milliseconds

	public static boolean isEmptyQueues(IOManager IO, CPUManager CPU) {
		// It will return true whenever there will be some process in
		// either of IOManager and CPUManager
		return !IO.IOManagerList.isEmpty() || !CPU.CPUManagerQueue.isEmpty();
	}

	public static void main(String[] args) {

		IOManager IO = new IOManager();
		CPUManager CPU = new CPUManager();

		ProcessCreator creator = new ProcessCreator();

		Scanner input = new Scanner(System.in);
		Random rand = new Random();

		boolean autoInputs = false;
		String s;
		System.out.print("DO YOU WANT AUTO INPUTS (y/n): ");
		s = input.nextLine();
		if (s.equals("y"))
			autoInputs = true;

		// This for loop is like clock which showing output and input process of
		// CPU in every second and generating outputs regarding It

		// After one minute there will be no input
		try {
			for (double currentTime = 0; currentTime < 30000 || isEmptyQueues(IO, CPU)
					|| !noMoreInputs; currentTime += 1000) {
				System.out.println("-----*-----");
				System.out.println("CLOCK: " + Clock.timer / 1000 + "sec");
				// In every three Second I have to take Input
				if (currentTime % processRate == 0 && !noMoreInputs) {
					long iopercentage, burstTime;

					// Input Process And get Process from processCreator
					// Inputs for creating process
					if (autoInputs) {
						iopercentage = rand.nextInt(101);
						// Range of burst time is 3 - 8 seconds
						burstTime = rand.nextInt(8001) + 3000;
						iopercentage = iopercentage - iopercentage % 10;
						burstTime = burstTime - burstTime % 100;
						System.out.println("Enter IOPercentage: " + iopercentage);
						System.out.println("Enter Burst Time: " + burstTime);
					} else {
						System.out.print("Enter IOPercentage: ");
						iopercentage = input.nextLong();
						System.out.print("Enter Burst Time: ");
						burstTime = input.nextLong();
					}

					Process p = creator.createProcess(iopercentage, burstTime);

					// Adding Process to both the queue
					CPU.addProcessToCPUManager(p);
					IO.addProcessToIOManager(p);
					totalProcessesAdded++;
				}

				CPU.runCPUManagerFor1Second();
				IO.runIOManagerFor1Second();

				// noMoreInputs will become true after adding processes
				// for one minutes and after that only CPUManager and IOManager
				// processing will be done
				if (totalProcessesAdded == 10)
					noMoreInputs = true;

				// Increasing time of clock
				Clock.timer += 1000;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("SIMULATION ENDED");
		// ON COMPLETED CLOSING SCANNER STREAM
		input.close();
	}
}