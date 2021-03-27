package simulation;

import java.util.*;

public class Controller {

	static int totalProcessesAdded = 0;
	static boolean noMoreInputs = false;
	static long processRate = 3000; // In milliseconds

	// Array of 20 processes (index: 1-20) which store
	// information coming from IOManager and CPUManager
	static List<Process> processes = new ArrayList<>();

	public static boolean isEmptyQueues(IOManager IO, CPUManager CPU) {
		// It will return true whenever there will be some process in
		// either of IOManager and CPUManager
		return !IO.IOManagerQueue.isEmpty() || !CPU.CPUManagerQueue.isEmpty();
	}

	// It will store all process information of IOManager
	// after it comes out of IOManagerQueue to use in future
	public static void storeAllIOManagerRelatedInfo(Process p) {
		for (Process process : processes) {
			if (process.pid == p.pid) {
				process.IOPercentage = p.IOPercentage;
				process.IOStartTime = p.IOStartTime;
				process.IOFinshTime = p.IOFinshTime;
				process.IORemaining = p.IORemaining;
				process.exitTime = p.exitTime;

				process.pid = p.pid;
				process.entryTime = p.entryTime;
				process.burstTime = p.burstTime;
				process.exitTime = p.IOFinshTime;

				process.totalIOWastageTime = p.IOStartTime - p.entryTime;
				process.totalWastageTime = p.totalIOWastageTime + p.totalCPUWastageTime;
				break;
			}
		}
	}

	// It will store all process information of IOManager
	// after it comes out of CPUManagerQueue to use in future
	public static void storeAllCPUManagerRelatedInfo(Process p) {
		for (Process process : processes) {
			if (process.pid == p.pid) {
				process.CPUStartTime = p.CPUStartTime;
				process.CPUFinishTime = p.CPUFinishTime;
				process.CPURemaining = p.CPURemaining;
				process.exitTime = p.exitTime;

				process.pid = p.pid;
				process.entryTime = p.entryTime;
				process.burstTime = p.burstTime;
				process.exitTime = p.IOFinshTime;

				process.totalCPUWastageTime = p.CPUStartTime - p.entryTime;
				process.totalWastageTime = p.totalIOWastageTime + p.totalCPUWastageTime;
				break;
			}
		}
	}

	public static void main(String[] args) {

		IOManager IO = new IOManager();
		CPUManager CPU = new CPUManager();

		ProcessCreator creator = new ProcessCreator();

		Scanner input = new Scanner(System.in);

		// This for loop is like clock which showing output and input process of
		// CPU in every second and generating outputs regarding It

		// After one minute there will be no input
		try {
			for (double currentTime = 0; isEmptyQueues(IO, CPU) || !noMoreInputs; currentTime += 1000) {
				System.out.println("-----*-----");
				System.out.println("CLOCK: " + Clock.timer / 1000 + "sec");
				// In every three Second I have to take Input
				if (currentTime % processRate == 0 && !noMoreInputs) {
					// Input Process And get Process from processCreator
					long iopercentage, burstTime;
					System.out.print("Enter IOPercentage: ");
					iopercentage = input.nextLong();
					System.out.print("Enter Burst Time: ");
					burstTime = input.nextLong();
					Process p = creator.createProcess(iopercentage, burstTime);

					// Adding Process to both the queue
					processes.add(p);
					CPU.addProcessToCPUManager(p);
					IO.addProcessToIOManager(p);
					totalProcessesAdded++;
				}

				CPU.runCPUManagerFor1Second();
				IO.runIOManagerFor1Second();

				// noMoreInputs will become true after adding processes
				// for one minutes and after that only CPUManager and IOManager
				// processing will be done
				if (totalProcessesAdded == 60 / (processRate / 1000))
					noMoreInputs = true;

				// Increasing time of clock
				Clock.timer += 1000;
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		// ON COMPLETED CLOSING SCANNER STREAM
		input.close();
	}

}
