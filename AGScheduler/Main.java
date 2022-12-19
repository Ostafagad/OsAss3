

public class Main {
    public static void main(String[] args) {

        // View v = new View();
    	
        Process[] p = new Process[4];
        p[0] = new Process("p1", 0, 17, 4, 7, 0);
        p[1] = new Process("p2", 2, 6, 7, 9, 1);
        p[2] = new Process("p3", 5 ,11, 3, 4, 2);
        p[3] = new Process("p4", 15, 4, 6, 6, 3);
        AGScheduler ag = new AGScheduler(p);
        ag.run();

        //public Process(String name, int arrivalTime, int burstTime, int priority, int quantum, int id)


    }
}
