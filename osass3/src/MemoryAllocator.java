import java.util.Vector;

public class MemoryAllocator {
    Vector<Partition> myPartitions;
    approch myApproch;
    private int count;
    public MemoryAllocator(Vector<Partition> myPartitions,approch fit) {
        this.myPartitions = myPartitions;
        myApproch = fit;
        count = myPartitions.size();
    }

    public void allocate(Process process) {
        Partition temp = myApproch.getSuitablePartition(myPartitions, process);
        myPartitions.get(temp.getId()).setFree(false);
        myPartitions.get(temp.getId()).setProcessID(process.getId());
        int fragm = temp.getSize() - process.getSize();
        if (fragm > 0) {
            Partition newPartition = new Partition(("part" + count), fragm, count);
            myPartitions.add(newPartition);
            count++;
        }

    }

    public void printHistory() {
        for (Partition partition : myPartitions) {
            if(partition.getProcessID()==-1)
                System.out.println(partition.getName() + "---> no process");
            else {
                System.out.println(partition.getName() + "---> pocess id "+partition.getProcessID());
            }
        }
    }
    
    
}
