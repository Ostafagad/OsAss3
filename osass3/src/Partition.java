public class Partition {
    private String name;
    private int size, id;
    private boolean free;
    private int processID;
    public int getProcessID() {
        return processID;
    }
    public void setProcessID(int processID) {
        this.processID = processID;
    }
    public Partition(String name, int size, int id) {
        this.name = name;
        this.size = size;
        this.id = id;
        this.free = true;
        processID = -1;
    }
    public boolean isFree() {
        return free;
    }
    public void setFree(boolean free) {
        this.free = free;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
}
