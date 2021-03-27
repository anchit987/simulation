package simulation;

public class ProcessCreator {
	static int pid=1;
	
	
	public ProcessCreator(){}
	
	public Process createProcess(long IOPercentage,long burstTime) {
		Process p = new Process(pid, IOPercentage, burstTime);
		pid++;
		return p;
	}
}
