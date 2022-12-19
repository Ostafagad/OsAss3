import java.util.Vector;

public class WorstFit implements approch{

    @Override
    public Partition getSuitablePartition(Vector<Partition>myPartitions, Process process) {
        int minPartID = -1;
        for (Partition partition : myPartitions) {
            if (partition.isFree() && partition.getSize() >= process.getSize()) {
                if (minPartID != -1 &&  myPartitions.get(minPartID).getSize() < partition.getSize())
                    minPartID = partition.getId();
            }
        }
        if(minPartID==-1)
            return null;
        else 
            return myPartitions.get(minPartID);
    }
    
}
