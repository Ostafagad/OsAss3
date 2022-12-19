public class Process{
    private String name;
    private int size, id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Process(String name, int size,int id) {
        this.name = name;
        this.size = size;
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