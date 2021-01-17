public class Main {
    static int lcs(char []x,char []y,int m,int n)
    {
     int [][]dp=new int[m+1][n+1];
     for(int i =0;i<=m;i++)
     {
         for(int j =0;j<=n;j++)
         {
           if(i==0||j==0)
              dp[i][j]=0;
           else if(x[i-1]==y[j-1])
           dp[i][j]=1+dp[i-1][j-1];
           else
           dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
         }
     }
     return dp[m][n];
    }
    public static void main(String args[]) {
     String s1 = "AGGTAB"; 
    String s2 = "GXTXAYB"; 
  
    char[] x=s1.toCharArray(); 
    char[] y=s2.toCharArray();
         System.out.println ( "Minimum coins : "
                            + lcs(x,y,x.length,y.length));

    }
}
