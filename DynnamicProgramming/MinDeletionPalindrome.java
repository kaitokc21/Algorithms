public class Main {
    static int lps(char[]x,char[]y,int n)
    {
        int [][]dp = new int[n+1][n+1];
        for(int i =0;i<=n;i++)
        {
            for(int j =0;j<=n;j++)
            {
                if(i==0||j==0)
                {
                    dp[i][j]=0;
                }
                else if(x[i-1]==y[j-1])
                dp[i][j]=dp[i-1][j-1]+1;
                else
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return n-dp[n][n];
    }
    public static void main(String args[]) {
         String seq = "GEEKSFORGEEKS"; 
        int n = seq.length(); 
        StringBuilder s = new StringBuilder(seq);
        s.reverse();
        String s2 = s.toString();
        System.out.println("Min no of deletion "+ lps(seq.toCharArray(),s2.toCharArray(),n)); 
    }
}
