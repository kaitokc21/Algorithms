import java.util.*;
public class Main{
    static int cntsubset(int []set,int n)
    {
        int sum=0;
        for(int i =0;i<n;i++)
        sum+=set[i];
        boolean dp[][]=new boolean[n+1][sum+1];
        for(int i =0;i<=n;i++)
        {
            for(int j =0;j<=sum;j++)
            {
                if(i==0&&j!=0)
                dp[i][j]=false;
                else if(j==0)
                dp[i][j]=true;
                else if(set[i-1]>j)
                dp[i][j]=dp[i-1][j];
                else
                dp[i][j]=dp[i-1][j]||dp[i-1][j-set[i-1]];
            }
        }
        int diff=0;
        for(int j =sum/2;j>=0;j--)
        {
            if(dp[n][j]==true)
            {
                diff=sum-2*j;
                break;
            }
        }
        return diff;
    }
    public static void main(String args[]) {
    int []set={3, 1, 4, 2, 2, 1};
    int n = cntsubset(set,set.length);
    System.out.println(n);
        
    }
}
