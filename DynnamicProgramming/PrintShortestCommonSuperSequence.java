public class Main {
    static String printScS(char[]x,char[]y,int m,int n)
    {
        int [][]dp = new int[m+1][n+1];
        for(int i =0;i<=m;i++)
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
        String s="";
        int i =m;
        int j =n;
        while(i>0&&j>0)
        {
            if(x[i-1]==y[j-1])
            {
                s+=x[i-1];
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1])
            {
                s+=x[i-1];
                i--;
            }
            else
            {
                s+=y[j-1];
                j--;
            }
        }
        while(i>0)
        {
            s+=x[i-1];
            i--;
        }
        while(j>0)
        {
            s+=y[j-1];
            j--;
        }
        StringBuilder s1 = new StringBuilder(s);
        s1.reverse();
        return s1.toString();
    }
    public static void main(String args[]) {
        String X = "AGGTAB"; 
        String Y = "GXTXAYB"; 
        System.out.println(printScS(X.toCharArray(), Y.toCharArray(),X.length(),Y.length())); 
    }
}
