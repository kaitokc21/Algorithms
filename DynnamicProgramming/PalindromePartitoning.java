public class Main {
    static int minPalPartion(String s)
    {
      int n = s.length();    
      int dp[][]=new int[n][n];
      for(int  i =0;i<n;i++)
      for(int j=0;j<n;j++)
      dp[i][j]=-1;
      return palpartion(s,dp,0,n-1);
    }
    static int palpartion(String s, int [][]dp,int i,int j)
    {
        if(i>=j)
        return 0;
        if(dp[i][j]!=-1)
        return dp[i][j];
        if(ispalindrome(s,i,j))
        return 0;
        dp[i][j]=Integer.MAX_VALUE;

        for(int k =i;k<j;k++)
        {
        int left;
        int right;    
        if(dp[i][k]!=-1)
        left=dp[i][k];
        else
        {
            left=palpartion(s,dp,i,k);
            dp[i][k]=left;
        }
        if(dp[k+1][j]!=-1)
        right=dp[k+1][j];
        else
        {
            right=palpartion(s,dp,k+1,j);
            dp[k+1][j]=right;
        }
        
         dp[i][j]=Math.min(dp[i][j],left+right+1);
        }
        return dp[i][j];
    }
    static boolean ispalindrome(String s,int i,int j)
    {
        while(j>=i)
        {
            if(s.charAt(i)!=s.charAt(j))
            {
                return false;
            }
            j--;
            i++;
        }
        return true;
    }
    
    public static void main(String args[]) {
     String str = "ababbbabbababa"; 
      System.out.println(minPalPartion(str));
    }
}
