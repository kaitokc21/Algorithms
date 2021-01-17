public class Main {
    static int mincoins(int []coins,int n,int sum)
    {
     int [][]dp=new int[n+1][sum+1];
     for(int i =0;i<=n;i++)
     {
         for(int j =0;j<=sum;j++)
         {
             if(i==0&&j!=0)
             dp[i][j]=Integer.MAX_VALUE-1;
             else if(j==0)
             dp[i][j]=0;
             else if(coins[i-1]>j)
             dp[i][j]=dp[i-1][j];
             else
             dp[i][j]=Math.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
         }
     }
     return dp[n][sum];
    }
    public static void main(String args[]) {
         int coins[] = {9, 6, 5, 1};
        int m = coins.length;
        int V = 11;
         System.out.println ( "Minimum coins : "
                            + mincoins(coins, m, V));

    }
}
