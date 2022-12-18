import java.util.Scanner;

public class FirstFit {
	
		// Method to allocate memory to
		// blocks as per First fit algorithm
		static void firstFit(int blockSize[], int m,
							int processSize[], int n)
		{
			// Stores block id of the
			// block allocated to a process
			int allocation[] = new int[n];
		
			// Initially no block is assigned to any process
			for (int i = 0; i < allocation.length; i++)
				allocation[i] = -1;
		
			// pick each process and find suitable blocks
			// according to its size ad assign to it
			for (int i = 0; i < n; i++)
			{
				for (int j = 0; j < m; j++)
				{
					if (blockSize[j] >= processSize[i])
					{
						// allocate block j to p[i] process
						allocation[i] = j;
		
						// Reduce available memory in this block.
						//System.out.print("\nPartition "+allocation[i]+" "+blockSize[j]);
						blockSize[j] -= processSize[i];
						
						
						break;
					}
					else {
						System.out.print("\nPartition "+allocation[i]+" "+blockSize[j]);
						//break;
					}
					
				}
			}
		
		
			for (int i = 0; i < n; i++)
			{
				
				if (allocation[i] != -1)
					System.out.print("\nPartition "+(allocation[i])+"("+ (processSize[i]) +"KB)" + "=>" + "Process"+(i+1));
				else
					
					System.out.print("Process"+(i+1)+" cannot be Allocated");
				System.out.println();
			}
		}
		
		// Driver Code
		public static void main(String[] args)
		{

			Scanner s=new Scanner(System.in);  
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
			firstFit(PartitionSize, PartitionSize.length, processSize,processSize.length );
		}
	}


