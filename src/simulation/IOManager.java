package simulation;

import java.util.*;

public class IOManager {
	public int totalProcessInIOManager = 0;
	// All process are running simultaneously
	public List<Process> IOManagerList = new ArrayList<>();

	// Implementing extra IOTime logic
	public void addExtraIOTimeToAllProcess() {
		// TODO: complete this method
	}

	public void addProcessToIOManager(Process p) {
		IOManagerList.add(p);
		p.IOStartTime = Clock.timer;
		totalProcessInIOManager += 1;
		addExtraIOTimeToAllProcess();
	}

	public void runIOManagerFor1Second() {
		// First check if there is process in IOManager Or not
		System.out.println("----IOManager----");
		if (IOManagerList.isEmpty()) {
			System.out.println("No process in IOManager");
			return;
		}

		try {
			// IOManager CONCEPT AS PER QUESTION

			// Running all processes in IOManager for 1 seconds
			// If completes then remove from the process

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
