import java.util.Scanner;

public class BestFit {
	// Java implementation of Best - Fit algorithm

	
		// Method to allocate memory to blocks as per Best fit
		// algorithm
		static void bestFit(int blockSize[], int m, int processSize[],
														int n)
		{
			Process pr;
			Partition pa;
			// Stores block id of the block allocated to a
			// process
			int allocation[] = new int[n];
		    int externalfrag[]=new int[n];
		    int l=0;
			// Initially no block is assigned to any process
			for (int i = 0; i < allocation.length; i++)
				allocation[i] = -1;
		
		// pick each process and find suitable blocks
			// according to its size ad assign to it
			for (int i=0; i<n; i++)
			{
				
				// Find the best fit block for current process
				int bestIdx = -1;
				for (int j=0; j<m; j++)
				{
					if (blockSize[j] >= processSize[i])
					{
						if (bestIdx == -1)
							bestIdx = j;
						else if (blockSize[bestIdx] > blockSize[j])
							bestIdx = j;
					}
				}
		
				// If we could find a block for current process
				if (bestIdx != -1)
				{
					// allocate block j to p[i] process
					allocation[i] = bestIdx;
		
					// Reduce available memory in this block.
					System.out.println("\nPartition "+(bestIdx)+"("+ blockSize[bestIdx] +"KB)");
					blockSize[bestIdx] -= processSize[i];
					System.out.println("\nPartition "+(bestIdx)+"("+ blockSize[bestIdx] +"KB)");
					//System.out.println("\nPartition "+(bestIdx)+"("+ blockSize[bestIdx] +"KB)");
					System.out.print("\nPartition "+(bestIdx+1)+"("+ blockSize[bestIdx+1] +"KB)" + "=>" + " ExetrnalFragment");
					//System.out.print("\nProcess "+allocation[i]+"("+ (processSize[i]) +"KB)" + "=>" + " ExetrnalFragment");
					System.out.println();
					l=blockSize[bestIdx]+blockSize[bestIdx+1];
									}
				//System.out.println("\nPartition "+(bestIdx+i)+"("+ blockSize[i+bestIdx] +"KB)");
				//System.out.print("\nPartition "+(bestIdx+1)+"("+ blockSize[bestIdx] +"KB)" + "=>" + " ExetrnalFragment");
				//System.out.print("\nProcess "+allocation[i]+"("+ (processSize[i]) +"KB)" + "=>" + " ExetrnalFragment");
				//System.out.println();
				System.out.println(l);
			}
		
			
			for (int i = 0; i < n; i++)
			{
				if (allocation[i] != -1) {
					System.out.print("\nPartition "+allocation[i]+"("+ (processSize[i]) +"KB)" + "=>" + "Process"+(i+1));
				}
				else {
					System.out.print("Not Allocated");
				}
				System.out.println();
			}
		}
		
		
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
			
			bestFit(PartitionSize, PartitionSize.length, processSize, processSize.length);
		}
	}


