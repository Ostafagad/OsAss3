import java.util.Vector;

public class FirstFit implements approch{

    @Override
    public Partition getSuitablePartition(Vector<Partition> myPartitions, Process process) {
            for (Partition partition : myPartitions) {
            if (partition.isFree() && partition.getSize() >= process.getSize()) {
                return partition;
            }
        }
        return null;
    }
    
}
