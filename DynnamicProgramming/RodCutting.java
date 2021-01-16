public class Main {
    static int rodcut(int[]price,int []length,int n,int m)
    {
        int[][]dp=new int[n+1][m+1];
        for(int i =0;i<=n;i++)
        {
            for(int j =0;j<=m;j++)
            {
                if(i==0||j==0)
                dp[i][j]=0;
                else if(length[i-1]>j)
                dp[i][j]=dp[i-1][j];
                else
                dp[i][j]=Math.max(dp[i-1][j],price[i-1]+dp[i][j-length[i-1]]);
            }
        }
        return dp[n][m];
    }
    public static void main(String args[]) {
      int price[] = { 1, 5, 8, 9, 10, 17, 17, 20 }; 
      int length[]={1,2,3,4,5,6,7,8};
      System.out.println(rodcut(price,length,price.length,length.length));
    }
}
