public class FractionalKnapsack 
{
	static class itemval
	{
		double wt,val,pt;
		itemval(int wt,int val)
		{
			this.wt=wt;
			this.val=val;
			this.pt=new Double(val/wt);
		}
		
		
	} 
	public static void sort(itemval []item)
	{
	int n =item.length;
	for(int i = 1;i<n;i++)
	{
		double key= item[i].pt;
		double wt= item[i].wt;
		double val= item[i].val;
				
		int j = i-1;
	    
	    while(j>=0&&item[j].pt>key)
	    {
	    	item[j+1].pt=item[j].pt;
	    	item[j+1].wt=item[j].wt;
	    	item[j+1].val=item[j].val;
	    	j=j-1;
	    }
	    item[j+1].pt=key;
	    item[j+1].wt=wt;
	    item[j+1].val=val;
	 }	
	}
    public static double getmaxvalue(int[]wt,int[]val,int capacity)
	{
		itemval item[]=new itemval[wt.length];
		for(int i = 0 ;i<item.length;i++)
		{
		 item[i]=new itemval(wt[i],val[i]);	
		}
		sort(item);
		double cwt=0;
		double cval=0;
		int index=item.length-1;
		while(cwt<capacity&&index>=0)
		{
		  if(cwt+item[index].wt<capacity)
		  {
			cwt+=item[index].wt;
			cval+=item[index].val;
		  }
		  else
		  {
			 cval+=item[index].pt*(capacity-cwt);
			 cwt+=(capacity-cwt);
		  }
		  index--;
	  }	
	return cval;	
}
	
	
	
	
	
	
	public static void main(String[]args)
	{
     int []wt= {10,40,20,30};
     int []val= {60,40,100,120};
     int capacity=50;
     double maxval=getmaxvalue(wt,val,capacity);
	System.out.println(maxval);
		
	}

}
