import java.util.*;
public class Main{
    static int cntsubset(int []set,int sum,int n)
    {
        int dp[][]=new int[n+1][sum+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=sum;j++)
            {
                if(i==0&&j!=0)
               dp[i][j]=0;
               else if(j==0)
               dp[i][j]=1;
               else if(set[i-1]>j)
               {
                   dp[i][j]=dp[i-1][j];
               }
              else
               {
                   dp[i][j]=dp[i-1][j]+dp[i-1][j-set[i-1]];
               }
            }
        }
        return dp[n][sum];
        
    }
    public static void main(String args[]) {
    int []set={ 3, 3, 3, 3 }; 
    int sum = 6;
    int n = cntsubset(set,sum,set.length);
    System.out.println(n);

    }
}
