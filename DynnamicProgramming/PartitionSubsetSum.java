import java.util.*;
public class Main{
    static boolean partition(int []set,int n)
    {
        int sum=0;
        for(int i = 0;i<n;i++)
        sum+=set[i];
        if(sum%2!=0)
        return false;
        sum=sum/2;
        boolean dp[][]=new boolean[n+1][sum+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=sum;j++)
            {
                if(i==0&&j!=0)
               dp[i][j]=false;
               else if(j==0)
               dp[i][j]=true;
               else if(set[i-1]>j)
               {
                   dp[i][j]=dp[i-1][j];
               }
              else
               {
                   dp[i][j]=dp[i-1][j]||dp[i-1][j-set[i-1]];
               }
            }
        }
        return dp[n][sum];
        
    }
    public static void main(String args[]) {
    int []set={ 3, 1, 1, 2, 2, 1,};
    if(partition(set,set.length))
    System.out.println("YES");
    else
    System.out.println("NO");
    }
}
