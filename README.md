# simulation

download the project and open as java project in your ide
run the Controller file
and give IOPercentage between 10 - 100
and give Burst Time between 4000 - 10000 (it is in milli second)

SAMPLE OUTPUTS
-----*-----
CLOCK: 0sec
Enter IOPercentage: 10
Enter Burst Time: 5000
----CPUManager----
Process 1: is running in CPUManager
Process 1: is running in CPUManager
Process 1: is running in CPUManager
Process 1: is running in CPUManager
Process 1: is running in CPUManager
Process 1: is running in CPUManager
Process 1: is running in CPUManager
Process 1: is running in CPUManager
Process 1: is running in CPUManager
Process 1: is running in CPUManager
Process 1: starts executing in IOManager
Number of process in IOManager: 1     
Process with id: 1 is completed its IO
No process in IOManager
-----*-----
CLOCK: 1sec
----CPUManager----
Process 1: is running in CPUManager
Process 1: is running in CPUManager
Process 1: is running in CPUManager
Process 1: is running in CPUManager
Process 1: is running in CPUManager
Process 1: is running in CPUManager
Process 1: is running in CPUManager
Process 1: is running in CPUManager
Process 1: is running in CPUManager
Process 1: is running in CPUManager
No process in IOManager
-----*-----
CLOCK: 2sec
----CPUManager----
Process 1: is running in CPUManager
Process 1: is running in CPUManager
Process 1: is running in CPUManager
Process 1: is running in CPUManager
Process 1: is running in CPUManager
Process 1: is running in CPUManager
Process 1: is running in CPUManager
Process 1: is running in CPUManager
Process 1: is running in CPUManager
Process 1: is running in CPUManager
No process in IOManager
-----*-----
CLOCK: 3sec
Enter IOPercentage: 50
Enter Burst Time: 10000
----CPUManager----
Process 1: is running in CPUManager
Process 2: is running in CPUManager
Process 1: is running in CPUManager
Process 2: is running in CPUManager
Process 1: is running in CPUManager
Process 2: is running in CPUManager
Process 1: is running in CPUManager
Process 2: is running in CPUManager
Process 1: is running in CPUManager
Process 2: is running in CPUManager
Process 2: starts executing in IOManager
Number of process in IOManager: 1
Process 2 is currently executing in IOManager. IO time remains: 4000ms
-----*-----
CLOCK: 4sec
----CPUManager----
Process 1: is running in CPUManager
Process 2: is running in CPUManager
Process 1: is running in CPUManager
Process 2: is running in CPUManager
Process 1: is running in CPUManager
Process 2: is running in CPUManager
Process 1: is running in CPUManager
Process 2: is running in CPUManager
Process 1: is running in CPUManager
Process 2: is running in CPUManager
Process 2 is currently executing in IOManager. IO time remains: 3000ms
-----*-----
CLOCK: 5sec
----CPUManager----
Process 1: is running in CPUManager
Process 2: is running in CPUManager
Process 1: is running in CPUManager
Process 2: is running in CPUManager
Process 1: is running in CPUManager
Process 2: is running in CPUManager
Process 1: is running in CPUManager
Process 2: is running in CPUManager
Process 1: is running in CPUManager
Process 2: is running in CPUManager
Process 2 is currently executing in IOManager. IO time remains: 2000ms
-----*-----
CLOCK: 6sec
Enter IOPercentage: 10
Enter Burst Time: 5000
----CPUManager----
Process 2: is running in CPUManager
Process 3: is running in CPUManager
Process 2: is running in CPUManager
Process 3: is running in CPUManager
Process 2: is running in CPUManager
Process 3: is running in CPUManager
Process 2: is running in CPUManager
Process 3: is running in CPUManager
Process 2: is running in CPUManager
Process 3: is running in CPUManager
Process 2 is currently executing in IOManager. IO time remains: 1000ms
-----*-----
CLOCK: 7sec
----CPUManager----
Process 2: is running in CPUManager
Process 3: is running in CPUManager
Process 2: is running in CPUManager
Process 3: is running in CPUManager
Process 2: is running in CPUManager
Process 3: is running in CPUManager
Process 2: is running in CPUManager
Process 3: is running in CPUManager
Process 2: is running in CPUManager
Process 3: is running in CPUManager
Process with id: 2 is completed its IO
-----*-----
CLOCK: 8sec
----CPUManager----
Process 2: is running in CPUManager
Process 3: is running in CPUManager
Process 2: is running in CPUManager
Process 3: is running in CPUManager
Process 2: is running in CPUManager
Process 3: is running in CPUManager
Process 2: is running in CPUManager
Process 3: is running in CPUManager
Process 2: is running in CPUManager
Process 3: is running in CPUManager
Process 3: starts executing in IOManager
Number of process in IOManager: 1
Process with id: 3 is completed its IO
No process in IOManager
-----*-----
CLOCK: 9sec
Enter IOPercentage: 50
Enter Burst Time: 5000
----CPUManager----
Process 2: is running in CPUManager
Process 3: is running in CPUManager
Process 4: is running in CPUManager
Process 2: is running in CPUManager
Process 3: is running in CPUManager
Process 4: is running in CPUManager
Process 2: is running in CPUManager
Process 3: is running in CPUManager
Process 4: is running in CPUManager
Process 2: is running in CPUManager
Process 4: starts executing in IOManager
Number of process in IOManager: 1
Process 4 is currently executing in IOManager. IO time remains: 1500ms
-----*-----
CLOCK: 10sec
----CPUManager----
Process 3: is running in CPUManager
Process 4: is running in CPUManager
Process 2: is running in CPUManager
Process 3: is running in CPUManager
Process 4: is running in CPUManager
Process 2: is running in CPUManager
Process 3: is running in CPUManager
Process 4: is running in CPUManager
Process 2: is running in CPUManager
Process 3: is running in CPUManager
Process 4 is currently executing in IOManager. IO time remains: 500ms
-----*-----
CLOCK: 11sec
----CPUManager----
Process 4: is running in CPUManager
Process 2: is running in CPUManager
Process 3: is running in CPUManager
Process 4: is running in CPUManager
Process 2: is running in CPUManager
Process 3: is running in CPUManager
Process 4: is running in CPUManager
Process 2: is running in CPUManager
Process 3: is running in CPUManager
Process 4: is running in CPUManager
Process with id: 4 is completed its IO
No process in IOManager
-----*-----
CLOCK: 12sec
Enter IOPercentage: 50
Enter Burst Time: 4000
----CPUManager----
Process 2: is running in CPUManager
Process 3: is running in CPUManager
Process 4: is running in CPUManager
Process 5: is running in CPUManager
Process 2: is running in CPUManager
Process 3: is running in CPUManager
Process 4: is running in CPUManager
Process 5: is running in CPUManager
Process 2: is running in CPUManager
Process 3: is running in CPUManager
Process 5: starts executing in IOManager
Number of process in IOManager: 1
Process 5 is currently executing in IOManager. IO time remains: 1000ms
-----*-----
CLOCK: 13sec
----CPUManager----
Process 4: is running in CPUManager
Process 5: is running in CPUManager
Process 2: is running in CPUManager
Process 3: is running in CPUManager
Process 4: is running in CPUManager
Process 5: is running in CPUManager
Process 2: is running in CPUManager
Process 3: is running in CPUManager
Process 4: is running in CPUManager
Process 5: is running in CPUManager
Process with id: 5 is completed its IO
-----*-----
CLOCK: 14sec
----CPUManager----
Process 2: is running in CPUManager
Process 3: is running in CPUManager
Process 4: is running in CPUManager
Process 5: is running in CPUManager
Process 2: is running in CPUManager
Process 3: is running in CPUManager
Process 4: is running in CPUManager
Process 5: is running in CPUManager
Process 2: is running in CPUManager
Process 3: is running in CPUManager
No process in IOManager
-----*-----
CLOCK: 15sec
Enter IOPercentage:
