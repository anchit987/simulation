package simulation;

import java.util.*;

public class Controller {
	static int totalProcessesAdded = 0;
	static boolean noMoreInputs = false;

	public static boolean isEmptyQueues(IOManager IO, CPUManager CPU) {
		// It will return true whenever there will be some process in
		// either of IOManager and CPUManager
		return !IO.IOManagerQueue.isEmpty() || !CPU.CPUManagerQueue.isEmpty();
	}

	public static void main(String[] args) {

		IOManager IO = new IOManager();
		CPUManager CPU = new CPUManager();

		ProcessCreator creator = new ProcessCreator();

		Scanner input = new Scanner(System.in);
		Random rand = new Random();

		boolean autoInputs = false;
		long numberOfProcess;
		String s;
		System.out.println("Processes will be input for 5 minutes and after there is no");
		System.out.println("process in CPUManager and IOManager the simulation will be stop.");
		System.out.println("******************************************");
		System.out.println();
		System.out.println("SIMULATION STARTED");
		System.out.println("Process Rate is(generated randomly): " + ProcessCreator.processRate);

		System.out.print("DO YOU WANT AUTO INPUTS (y/n): ");
		s = input.nextLine();
		if (s.equals("y"))
		autoInputs = true;
		
		System.out.print("Enter number of processes: ");
		numberOfProcess = input.nextInt();
		// This for loop is like clock which showing output and input process of
		// CPU in every second and generating outputs regarding It

		// After one minute there will be no input
		try {
			for (double currentTime = 0; isEmptyQueues(IO, CPU) || !noMoreInputs; currentTime += 1000) {
				System.out.println("-----*-----");
				System.out.println("CLOCK: " + Clock.timer / 1000 + "sec");
				// In every three second it will take Input
				if (currentTime % ProcessCreator.processRate == 0 && !noMoreInputs) {
					// Input Process And get Process from processCreator
					long iopercentage, burstTime;

					if (autoInputs) {
						iopercentage = rand.nextInt(101);
						burstTime = rand.nextInt(6000) + 4000;
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

				// input = 100 process in 5 minutes at the rate of 1 process / second
				if (totalProcessesAdded == numberOfProcess)
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