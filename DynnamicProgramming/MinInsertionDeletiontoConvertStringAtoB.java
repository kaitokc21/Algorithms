public class MyClass {
    static int lcs(char[] x ,char[] y,int m,int n)
    {
        int dp[][]=new int[m+1][n+1];
        for(int i =0;i<=m;i++)
        {
            for(int j =0;j<=n;j++)
            {
                if(i==0||j==0)
                dp[i][j]=0;
                else if(x[i-1]==y[j-1])
                dp[i][j]=dp[i-1][j-1]+1;
                else
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[m][n];
        
    }
    public static void main(String args[]) {
        String X = "heap"; 
        String Y = "pea"; 
        int m = X.length(); 
        int n = Y.length(); 
        int k = lcs(X.toCharArray(), Y.toCharArray(), m, n);
        System.out.print("Deletions = ");
        System.out.println(m - k);
        System.out.print("Insertions = ");
        System.out.println(n - k);
        
    }
}
