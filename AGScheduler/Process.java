
public class Process {
    public String name;
    public int arrivalTime;
    public boolean finished = false;
    public int burstTime;
    public int remainigBrustTime;
    public int priority;
    public int quantum;
    public int remainingQuantum;
    public int id;
    public int quantumScale = 0;
    private int startTime = -1;
    private int endTime;
    public int waitingTime; // start(new start) - arrival(the time it stopped in)
    //private int turnaroundTime; // end - arrival
    private int totalAroundTime;

 

    public Process(String name, int arrivalTime, int burstTime, int priority, int quantum, int id) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = priority;
        this.quantum = quantum;
        this.id = id;
        this.remainingQuantum = quantum;
        this.remainigBrustTime=this.burstTime;
    }

    public Process(String name, int burstTime, int arrivalTime) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }

    public Process(String name, int burstTime, int arrivalTime, int priority) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.remainigBrustTime = burstTime;
        this.priority = priority;
    }

    public Process(String name, int burstTime, int arrivalTime, int priority, int quantum) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = priority;
        this.quantum = quantum;
    }

    public Process() {
        name = null;
    }
    public Process(Process p) {
        this.name = p.getName();
        this.burstTime = p.getBurstTime();
        this.remainigBrustTime = p.getRemainigBrustTime();
        this.arrivalTime = p.getArrivalTime();
        this.priority = p.getPriority();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    public int getRemainigBrustTime() {
        return remainigBrustTime;
    }

    public void setRemainigBrustTime(int remainigBrustTime) {
        this.remainigBrustTime = remainigBrustTime;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setQuantum(int quantum) {
        this.quantum = quantum;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public String getName() {
        return name;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public int getPriority() {
        return priority;
    }

    public int getQuantum() {
        return quantum;
    }

    public float getWaitingTime() {
        return waitingTime;
    }

    public void calctotalaroundtime(int totalAroundTime) {
        this.totalAroundTime=totalAroundTime;
    }

    public int getTotalAroundTime() {
        return totalAroundTime;
    }

    public int getQuantumScale() {
        return quantumScale;
    }

    public void setQuantumScale(int quantumScale) {
        this.quantumScale = quantumScale;
    }

    public void setTotalAroundTime(int totalAroundTime) {
        this.totalAroundTime = totalAroundTime;
    }

}

   