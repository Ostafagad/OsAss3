
public class Process {
private int ProcessSize;
private String ProcessName;
private int partitionnum;
public Process(int ProcessSize,String ProcessName) {
	this.ProcessSize=ProcessSize;
	this.ProcessName=ProcessName;
}
public void setProcessName(String ProcessName ) {
	this.ProcessName=ProcessName;
}
public void setProcessSize(int ProcessSize) {
	this.ProcessSize=ProcessSize;
}

public String getProcessName() {
	return this.ProcessName;
}
public int getProcessSize() {
	return this.ProcessSize;
}
public int getPartitionnum() {
	return partitionnum;
}
public void setPartitionnum(int partitionnum) {
	this.partitionnum = partitionnum;
}
}
