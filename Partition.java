
public class Partition {
private String PartitionName;
private int PartitionSize;
public Partition(String PartitionName,int PartitionSize) {
	this.PartitionName=PartitionName;
	this.PartitionSize=PartitionSize;
}
public void setPartitionName(String PartitionName ) {
	this.PartitionName=PartitionName;
}
public String getPartitionName() {
	return this.PartitionName;
}
public void setPartitionSize(int PartitionSize ) {
	this.PartitionSize=PartitionSize;
}
public int getPartitionSize() {
	return this.PartitionSize;
}

}
