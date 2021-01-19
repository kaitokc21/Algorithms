public class Main {
    static int matrixchain(int []arr,int [][]dp,int i,int j)
    {
        if(i>=j)
        return 0;
        if(dp[i][j]!=-1)
        return dp[i][j];
        dp[i][j]=Integer.MAX_VALUE;
        for(int k=i;k<j;k++)
        {
            dp[i][j]=Math.min(dp[i][j],matrixchain(arr,dp,i,k)+matrixchain(arr,dp,k+1,j)+arr[i-1]*arr[k]*arr[j]);
        }
        return dp[i][j];
    }
    static int matrix(int []arr,int j)
    {
        int [][]dp = new int[j][j];
        for(int i =0;i<j;i++)
        for(int k=0;k<j;k++)
        dp[i][k]=-1;
        int n = matrixchain(arr,dp,1,j-1);
        return n;
    }
    public static void main(String args[]) {
        int arr[] = new int[] { 1, 2, 3, 4 }; 
        int size = arr.length;
        System.out.println(matrix(arr,size)); 
    }
}
