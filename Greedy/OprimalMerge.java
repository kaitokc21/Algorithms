public class OptimalMerge {
	static class Node
	{
		int priority;
		Node next;
	}
	static class PriorityQueue
	{
		
		Node newnode(int p)
		{
		Node temp=new Node();
		temp.priority=p;
		temp.next=null;
		return temp;
		} 
	  	 Node push(Node head,int p)
	  	{ 
	  		if(head==null)
		       {
	  			 Node temp=newnode(p);
		    	  head=temp;
		    	  return head;
		       } 
	       Node temp=newnode(p);
	       Node start=head;
	       if(head.priority>p)
	       {
	    	   temp.next=head;
	    	   head=temp;
	       } 
	       else
	       {
	    	   while(start.next!=null&&start.next.priority<p)
	    	   {
	    		   
	    		   start=start.next;
	    		   
	    	   } 
	              temp.next=start.next;
	              start.next=temp;
	    	}
	       
	  		       return head;
	  		}
	  	
	       Node pop(Node head)
	      {
	        head=head.next;
	        return head;   
	     }
	       int size(Node head)
	      {
	    	  Node temp=head;
	    	  if (head==null)
	    	  return 0;
	    	  int count=1;
	    	  while(temp.next!=null)
	    	  {
	    		  temp=temp.next;
	    	      count++;
	    	   }	  
	    	  
	    	 return count;  
	  }
	      
	}
	 
	static int minmerge(int size,int []arr)
	{
	  PriorityQueue Priority=new PriorityQueue();
	  Node head=null;
	 for(int i=0;i<size;i++)
	  {
		  head=Priority.push(head,arr[i]);
      }
	  
	  int count=0;
	  while(Priority.size(head)>1)
	  {
	  int p=head.priority;
	  head=Priority.pop(head) ;
	  int q=head.priority;
	  head=Priority.pop(head);
	  int temp=p+q;
	   count+=temp;
	  
	    head=Priority.push(head,temp);
	  }
      return count;
     }
	 
	public static void main(String[]args)
	{
		OptimalMerge merge=new OptimalMerge();
		int []arr=new int[]{ 20, 30, 10, 5, 30 };
		int count=merge.minmerge(5, arr);
	   System.out.println(count);
		
	 }

}
