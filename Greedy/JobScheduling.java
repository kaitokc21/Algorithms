package intro;
import java.util.ArrayList;
import java.util.Collections;
public class Jobscheduling {
static class job implements Comparable<job>
{
char id; 
int deadline;
int profit;
public int compareTo(job j)
{
	return j.profit-this.profit;
}
job(char s,int a ,int b)
{
id=s;
deadline=a;
profit=b;
}
}
public static void schedule(ArrayList<job> jobs,int size)
{
int []result=new int[size];
Boolean[] slots=new Boolean[size];
for(int i=0;i<size;i++)
{
slots[i]=false;	
}	
for(int i =0 ;i<size;i++)
{
 for(int j=jobs.get(i).deadline-1;j>=0;j--)
 {
	 if(!slots[j])
	 {
		result[j]=i;
		slots[j]=true;
		break;
	 }
	 
	 
 }
 }
for(int i=0;i<size;i++)
{
	if(slots[i])
	{
		System.out.println(jobs.get(result[i]).id);
	}
}	
}
	
public static void main(String[]args)
{
ArrayList<job> jobs=new ArrayList<job>(5);
jobs.add(new job('a', 2, 100));
jobs.add(new job('b', 1, 19));
jobs.add(new job('c', 2, 27));
jobs.add(new job('d', 1, 25));
jobs.add(new job('e', 3, 15));
Collections.sort(jobs);
schedule(jobs,5);
for (job job : jobs) {
 System.out.println(job.id + " - " + job.profit);
}
}
}
