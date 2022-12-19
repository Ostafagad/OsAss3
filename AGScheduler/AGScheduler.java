import java.util.LinkedList;
import java.util.Queue;
public class AGScheduler {
    Process[] myProcesses;
    Queue<Process> ready = new LinkedList<Process>();
    private int arr[];
    private final int aSize=70;
    AGScheduler(Process[] processes) {
        this.myProcesses = processes;
        arr = new int[aSize];//[p1,p1,p1,p1,p2,p2,2,3,3,1,1,1]
        for(int i=0;i<aSize;i++) {
        	arr[i]=-1;
        }
    }


    public void run() {
    	System.out.println("run AGScheduler");
        int finished = 0;
        int curr = 0;//ar[0]; c.fa++;
        ready.add(myProcesses[curr]);
        
        for (int i = 0; finished < myProcesses.length; i++) {
            Process pr = ready.remove();
            curr = pr.id;
            double q = Math.floor((myProcesses[curr].quantum) / 4);//2
            q++;
            // FCFS section
            while (q-- > 0) {
                // in case finished 
                if (myProcesses[curr].burstTime == 0) {
                    myProcesses[curr].quantum = 0;
                    finished++;
                    break;
                }
                // fill life time arr
                arr[i] = myProcesses[curr].id;
                // reduce burstTime time
                myProcesses[curr].burstTime--;
                myProcesses[curr].remainingQuantum--;//3 1 
                i++;
                //enter the arrive at this mement in ready Q
                updateReady(i);
                if (myProcesses[curr].remainingQuantum == 0 && myProcesses[curr].burstTime != 0) {
                    myProcesses[curr].quantum += 2;
                    myProcesses[curr].remainingQuantum = myProcesses[curr].quantum;
                    break;
                }
            }
            if (myProcesses[curr].burstTime != 0) {
                ready.add(myProcesses[curr]);
            }
            // update curr and q
            curr = getHighPriority();
            // get out the current process
            outOfQueue(curr);
            q = (int) Math.floor(myProcesses[curr].quantum / 4);
            q++;
            // Priority section //// non-premtive
            while (q-- > 0) {
                // in case finished 
                if (myProcesses[curr].burstTime == 0) {
                    myProcesses[curr].quantum = 0;
                    finished++;
                    break;
                }
                // fill life time arr
                arr[i] = myProcesses[curr].id;
                // reduce burstTime time
                myProcesses[curr].burstTime--;
                myProcesses[curr].remainingQuantum--;//3 1 
                i++;
                //enter the arrive at this mement in ready Q
                updateReady(i);
                if (myProcesses[curr].remainingQuantum == 0 && myProcesses[curr].burstTime != 0) {
                    myProcesses[curr].quantum += 2;
                    myProcesses[curr].remainingQuantum = myProcesses[curr].quantum;
                    break;
                }
            }
            // return the current process to the queue
            if (myProcesses[curr].burstTime != 0) {
                ready.add(myProcesses[curr]);
                // get shortest job
                int temp = shortestJob();
                //in case different process
                if (curr != temp) {
                    outOfQueue(myProcesses[curr].id);
                    // cond ii
                    int r = (int) Math.floor((myProcesses[curr].remainingQuantum) / 2);
                    r++;
                    myProcesses[curr].quantum += r;
                    //update
                    ready.add(myProcesses[curr]);
                    // out of queue
                    outOfQueue(myProcesses[temp].id);
                    // update the current to the shortest
                    curr = temp;
                } else {
                    outOfQueue(myProcesses[curr].id);
                }
            }
            // check Shortest jop
            q = (int) Math.floor(myProcesses[curr].quantum / 2);
            q++;
            // SJS section
            while (q-- > 0) {
                if (myProcesses[curr].burstTime == 0) {
                    myProcesses[curr].quantum = 0;
                    finished++;
                    break;
                }
                // fill life time arr
                arr[i] = myProcesses[curr].id;
                // reduce burstTime time
                myProcesses[curr].burstTime--;
                myProcesses[curr].remainingQuantum--;//3 1 
                i++;
                //enter the arrive at this mement in ready Q
                int size = ready.size();
                updateReady(i);
                if (size > ready.size()) {
                    if (myProcesses[curr].burstTime != 0) {
                        ready.add(myProcesses[curr]);
                        // get shortest job
                        int temp = shortestJob();
                        //in case different process
                        if (curr != temp) {
                            outOfQueue(myProcesses[curr].id);
                            // cond iii
                            int r = ((myProcesses[curr].remainingQuantum));
                            myProcesses[curr].quantum += r;///////////////////////
                            //update
                            ready.add(myProcesses[curr]);
                            // out of queue
                            outOfQueue(myProcesses[temp].id);
                            // update the current to the shortest
                            curr = temp;
                            q = (int) Math.floor(myProcesses[curr].quantum / 2);
                            q++;
                        } else {
                            outOfQueue(myProcesses[curr].id);
                        }
                    }
                }
                if (myProcesses[curr].remainingQuantum == 0 && myProcesses[curr].burstTime != 0) {
                    myProcesses[curr].quantum += 2;
                    myProcesses[curr].remainingQuantum = myProcesses[curr].quantum;
                    break;
                }

            }
            if (myProcesses[curr].burstTime != 0) {
                ready.add(myProcesses[curr]);
            }

        }
        this.culc();
        this.showData();
       
    }

    public int getHighPriority() {
        int m = 9999999;
        int sp = 0;
        for (Process process : ready) {
            if (process.priority < m) {
                m = process.priority;
                sp = process.id;
            }
        }
        return sp;

    }
     public int shortestJob() {
        int m = 9999999;
        int sp = 0;
        for (Process process : ready) {
            if (process.burstTime < m && process.burstTime!=0)
            {
                m = process.burstTime;
                sp = process.id;
            }
        }
        return sp;
            
    }
    
    
    public void updateReady(int i) {
        for (Process process : myProcesses) {
            if (process.arrivalTime == i)
                ready.add(process);
        }
    }

    public void outOfQueue(int id) {
        Queue<Process> temp = new LinkedList<Process>();
        for (Process process : ready) {
            if (process.id != id)
                temp.add(process);
        }
        ready = temp;
    }
    
    public void showData(){
    	int c=0;
    	 for (int i : arr) {
    		 if(i!=-1)
    			 System.out.println("s "+c+" P"+(i+1)+" ");
    		 else 
    			 System.out.println("s "+c+" notUsed");
    		 c++;
         }
         System.out.println("");

    }

    public void culc() {
    	for(Process process:this.myProcesses) {
    		int turnAround=culcHelp(process);
    		System.out.println(process.name+" turnAound time= "+turnAround+" wating time = " + (turnAround-(process.remainigBrustTime)));
    	}
    }
    //
    private int culcHelp(Process p) {
    	int s=0;
    	for(int i=0;i<this.arr.length;i++) {
    		if(arr[i]==p.id) {
    			s=i;
    			break;
    		}
    	}
    	int e=0;
    	for(int i=this.arr.length-1;i>=0;i-=1) {
    		if(arr[i]==p.id) {
    			e=i;
    			break;
    		}
    	}
    	return (e-s +1);
    }
}
