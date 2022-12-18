import java.util.Scanner;

public class ProcessAllocation {
private Process processes[];
private Partition partitions[];
private Process tempprocesses[];

public ProcessAllocation(int Processnum,int Partitionnum) {
	processes=new Process[Processnum];
	partitions=new Partition[Partitionnum];
	tempprocesses=new Process[Processnum];
}
public void setProcesses(Process processes[]) {
	for(int i=0;i<processes.length;i++) {
		this.processes[i]=processes[i];
		this.tempprocesses[i]=processes[i];
	} 
}
public void setPartitions(Partition partitions[]) {
	for(int i=0;i< partitions.length;i++) {
		this.partitions[i]=partitions[i];
	} 
}
void firstFit(int Partitionnum,int Processnum)
{
// Stores block id of the
// block allocated to a process
  
   tempprocesses=new Process[Processnum];
// Initially no block is assigned to any process
   for (int i = 0; i < tempprocesses.length; i++)
	   tempprocesses[i].setProcessSize(-1); 

// pick each process and find suitable blocks
// according to its size ad assign to it
   for (int i = 0; i <Processnum; i++)
   {
	   for (int j = 0; j <Partitionnum; j++)
	   {
		   if (partitions[j].getPartitionSize() >= processes[i].getProcessSize())
		   {
	// allocate block j to p[i] process
			   tempprocesses[i].setProcessSize(j); 

	// Reduce available memory in this block.
	//System.out.print("\nPartition "+allocation[i]+" "+blockSize[j]);
			   partitions[j].setPartitionSize(partitions[j].getPartitionSize()-processes[i].getProcessSize()); 
			   tempprocesses[i].setPartitionnum(i+1);
	             
			   break;
		   }
		 

	   }
   }


   for (int i = 0; i < Processnum; i++)
   {

	   if (tempprocesses[i].getProcessSize() != -1)
		   System.out.print("\nPartition "+(tempprocesses[i].getPartitionnum())+"("+ (processes[i].getProcessSize()) +"KB)" + "=>" + "Process"+(i+1));
	   else

		   System.out.print("Process"+(i+1)+" cannot be Allocated");
	   System.out.println();
   }
	}
public static void main(String[] args)
{

	/*Scanner s=new Scanner(System.in);  
	int Partitionsize,Processsize;
	System.out.println("Enter number of partition: ");
	Partitionsize=s.nextInt();
	
	int PartitionSize[]=new int[Partitionsize];
	for(int i=0;i<Partitionsize;i++) {
		System.out.println("Enter number of partition: ");
		System.out.print("Partition"+i+" ");   
		PartitionSize[i] = s.nextInt();  
	}
	System.out.print("Enter number of processes: ");  
	Processsize= s.nextInt();  
	int processSize[]=new int[Processsize];
	for(int i=0;i<Processsize;i++) {
		System.out.println("Process name and its size: ");
		System.out.print("Process"+(i+1)+" ");   
		 processSize[i] = s.nextInt();  
	}
	firstFit(PartitionSize, PartitionSize.length, processSize,processSize.length );*/
	Process pro1=new Process(100,"P1");
	Process pro2=new Process(500,"P2");
	Process pro3=new Process(200,"P3");
	Process pro4=new Process(300,"P4");
	Process pro5=new Process(600,"P5");
	Process processes[]= { pro1, pro2, pro3, pro4, pro5};
	Partition pa1=new Partition("Par1",212);
	Partition pa2=new Partition("Par2",417);
	Partition pa3=new Partition("Par3",112);
	Partition pa4=new Partition("Par4",426);
	Partition Partitions[]= {pa1,pa2,pa3,pa4};
	ProcessAllocation pallo=new ProcessAllocation(5,4);
	pallo.setProcesses(processes);
	pallo.setPartitions(Partitions);
	pallo.firstFit(4, 5);
	
}
	}
