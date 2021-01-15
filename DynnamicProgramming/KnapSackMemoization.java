import java.util.*;
public class Main {
    static int knap(int[]val,int[]wt,int w ,int n)
    {
        int [][]dp=new int[n+1][w+1];
        for(int i =0;i<=n;i++)
        for(int j=0;j<=w;j++)
        dp[i][j]=-1;
       int k =knapsack(val,wt,w,n,dp);
       for(int i =0;i<=n;i++)
       {
        for(int j=0;j<=w;j++)
        {
        System.out.print(dp[i][j]+" ");
        }
           System.out.println();
       }
       return k;
    }
    static int knapsack(int[]val,int[]wt,int w,int n ,int[][]dp)
    {
        if(n==0||w==0)
        return 0;
        if(dp[n][w]!=-1)
        return dp[n][w];
        if(wt[n-1]>w)
        {
         dp[n][w]=knapsack(val,wt,w,n-1,dp);
         return dp[n][w];
        }
        else
        {
             dp[n][w]=Math.max(val[n-1]+knapsack(val,wt,w-wt[n-1],n-1,dp),knapsack(val,wt,w,n-1,dp)) ; 
             return dp[n][w];
        }
    }
    public static void main(String args[]) {
           int val[]={30,20,10, 30 }; 
           int wt[]={1,1, 1, 1 };
           int w = 2;
           int n =knap(val,wt,w,val.length);
           System.out.println(n);
           
    }
}
