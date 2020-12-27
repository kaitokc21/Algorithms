import java.util.*;
public class ShortestPath {
     static final int v= 9;
     int min(int []dist,boolean []spt)
     {
         int min =Integer.MAX_VALUE;
         int ind=-1;
         for(int i=0;i<v;i++)
         {
             if(spt[i]==false&&min>dist[i])
             {
                 min=dist[i];
                 ind=i;
             }
         }
         return ind;
         
     }    void print(int dist[]) 
    { 
        System.out.println("Vertex \t\t Distance from Source"); 
        for (int i = 0; i < v; i++) 
            System.out.println(i + " \t\t " + dist[i]); 
    } 
         void dijkstra(int[][]graph,int src)
         {
             int dist[]=new int[v];
             boolean sptSet[]=new boolean[v];
             for(int i=0;i<v;i++)
             dist[i]=Integer.MAX_VALUE;
             dist[src]=0;
             for(int i=0;i<v-1;i++)
             {
                 int u =min(dist,sptSet);
                 sptSet[u]=true;
                 for(int w =0;w<v;w++)
                 {
                     if(!sptSet[w]&&graph[u][w]!=0&&dist[u]+graph[u][w]<dist[w])
                     {
                         dist[w]=dist[u]+graph[u][w];
                     }
                 }
                 
             }
             print(dist);
         }
    
    public static void main(String args[]) {
       int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
                                      { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
                                      { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
                                      { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
                                      { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
                                      { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
                                      { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
                                      { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
                                      { 0, 0, 2, 0, 0, 0, 6, 7, 0 } }; 
        ShortestPath t = new ShortestPath(); 
        t.dijkstra(graph, 0); 
    }
}
