public class Main {
    static int rodcut(int[]coins,int n,int sum)
    {
        int[][]dp=new int[n+1][sum+1];
        for(int i =0;i<=n;i++)
        {
            for(int j =0;j<=sum;j++)
            {
                if(i==0&&j!=0)
                dp[i][j]=0;
                else if(j==0)
                dp[i][j]=1;
                else if(coins[i-1]>j)
                dp[i][j]=dp[i-1][j];
                else
                dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
                
        }
       
    }
     return dp[n][sum];
    }
    public static void main(String args[]) {
      int coins[] = { 1, 2,3}; 
      int sum=4;
      System.out.println(rodcut(coins,coins.length,sum));
    }
}
