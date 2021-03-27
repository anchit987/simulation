package simulation;

public class Process {
	public int pid;
	public long IOPercentage;

	public long entryTime;
	public long burstTime;
	public long exitTime;

	public long CPUTime;
	public long CPUStartTime;
	public long CPUFinishTime;
	public long CPURemaining;
	public boolean CPUStart = false;

	public long IOTime;
	public long IOStartTime;
	public long IOFinshTime;
	public long IORemaining;
	public boolean IOStart = false;

	public long totalCPUWastageTime = 0;
	public long totalIOWastageTime = 0;
	public long totalWastageTime = 0;

	public Process() {
	}

	public Process(int pid, long IOPercentage, long burstTime) {
		this.pid = pid;

		this.entryTime = Clock.timer;
		this.burstTime = burstTime;

		this.IOTime = burstTime * IOPercentage / 100;
		this.IORemaining = IOTime;

		this.CPUTime = burstTime - IOTime;
		this.CPURemaining = CPUTime;

		this.CPUFinishTime = 0;
		this.IOFinshTime = 0;
		this.exitTime = 0;
	}

}
