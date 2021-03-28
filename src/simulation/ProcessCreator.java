package simulation;

import java.util.Random;

public class ProcessCreator {
	static Random rand = new Random();
	static int pid = 1;

	static long processRate = 3000; // in millisecond

	public ProcessCreator() {
	}

	public Process createProcess(long IOPercentage, long burstTime) {
		Process p = new Process(pid, IOPercentage, burstTime);
		pid++;
		return p;
	}
}
