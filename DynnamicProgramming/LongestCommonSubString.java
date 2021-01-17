public class Main {
    static int substring(char []x,char []y,int m,int n)
    {
     int [][]dp=new int[m+1][n+1];
     int max=Integer.MIN_VALUE;
     for(int i =0;i<=m;i++)
     {
         for(int j =0;j<=n;j++)
         {
           if(i==0||j==0)
              dp[i][j]=0;
           else if(x[i-1]==y[j-1])
           dp[i][j]=1+dp[i-1][j-1];
           else
           dp[i][j]=0;
           max=Math.max(max,dp[i][j]);
         }
     }
     return max;
    }
    public static void main(String args[]) {
     String s1 = "abcdxyz"; 
    String s2 = "xyzabcd";  
  
    char[] x=s1.toCharArray(); 
    char[] y=s2.toCharArray();
         System.out.println ( "Minimum coins : "
                            + substring(x,y,x.length,y.length));

    }
}
