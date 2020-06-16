public class HuffmanCode {
	static class Node
	{
	int freq;
	char c;
	Node next;
	Node left;
	Node right;
	}
	static class PriorityQueue
	{
		
	Node newnode(int freq,char c) 
	{
	Node head=new Node();
	head.freq=freq;
	head.c=c;
	return head;
	}	
	Node push(Node head,int freq,char c) 
	{
	Node next=newnode(freq,c);	
	if(head==null)
	{
		head=next;
		return head;
	}
	Node temp=head;
	if(head.freq>freq)
	{
		next.next=head;
		head=next;
	}
	else
	{
	while(temp.next!=null&&temp.next.freq<freq)
	{
	temp=temp.next;	
	}
	next.next=temp.next;
	temp.next=next;
	}
	return head;
	}
	Node add(Node head,Node next)
	{
		if(head==null)
		{
			head=next;
			return head;
		}
		Node temp=head;
		if(head.freq>next.freq)
		{
			next.next=head;
			head=next;
		}
		else
		{
		while(temp.next!=null&&temp.next.freq<next.freq)
		{
		temp=temp.next;	
		}
		next.next=temp.next;
		temp.next=next;
		}
		return head;
	}
	Node pop(Node head)
	{
	head=head.next;
	return head;
	}
	Node peek(Node head)
	{
		return head;
	}
	int size(Node head)
	{
	int count=1;
	if(head==null)
	{
	return 0;	
	}	
	Node temp=head;
	while(temp.next!=null)
	{
		temp=temp.next;
		count++;
	}	
	return count;
	}
	}
	static void printcode(Node root,String s)
	{
	if(root.left==null&&root.right==null)
	{
		System.out.println(root.c+" : "+s);
	    return;
	}	
	printcode(root.left,s+"0");
	printcode(root.right,s+"1");
		
	}
	
	
	
	public static void main(String[]args)
	{
		int n = 6; 
        char[] character = { 'e', 'd', 'c', 'f', 'a', 'b' }; 
        int[] freq = { 16, 13, 12, 45, 5, 9 }; 
        PriorityQueue priority=new PriorityQueue(); 
        Node head=null;
        for(int i=0;i<n;i++)
        {
        head=priority.push(head, freq[i],character[i]);
        }	
		   Node root=null;
		while(priority.size(head)>1)
		{
			Node first=priority.peek(head);
			head=priority.pop(head);
			Node second=priority.peek(head);
			head=priority.pop(head);
            Node sum=new Node();
            sum.freq=first.freq+second.freq;
            sum.c='-';
            sum.left=first;
            sum.right=second;
            root=sum;
	        head=priority.add(head,sum); 		
		}	
		printcode(root,"");
		
	}

}
