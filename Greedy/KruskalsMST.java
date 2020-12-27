import java.util.*;
public class Graph {
    private int V ;
    private int E ;
    Edge [] edge;
    class Edge implements Comparable<Edge>
    {
        int src, dest, weight; 
        public int compareTo(Edge ed)
        {
            return this.weight-ed.weight;
        }
    };
    Graph(int nV, int nE)
    {
        E=nE;
        V=nV;
        edge=new Edge[E];
        for(int i =0;i<E;i++)
        {
            edge[i]=new Edge();
        }
    }
    class subsets
    {
        int parent;
        int rank;
    };
    int find(subsets[]subset,int i)
    {
        if(subset[i].parent!=i)
        subset[i].parent=find(subset,subset[i].parent);
        return subset[i].parent;
    }
    void union(subsets[]subset,int x ,int y)
    {
        if(subset[x].rank<subset[y].rank)
        subset[x].parent=y;
         if(subset[x].rank>subset[y].rank)
        subset[y].parent=x;
        else
        {
            subset[x].parent=y;
            subset[y].rank++;
        }
    }
    void KruskalMST()
    {
        Edge result[]=new Edge[V];
        int e =0;
        int i =0;
        for(i=0;i<V;i++)
        result[i]=new Edge();
        subsets[]subset=new subsets[V];
        for(i=0;i<V;i++)
        {
            subset[i]=new subsets();
            subset[i].parent=i;
            subset[i].rank=0;
        }
        Arrays.sort(edge);
        i=0;
        while(e<V-1)
        {
           Edge nextedge = new Edge();
           nextedge=edge[i++];
           int x = find(subset,nextedge.src);
           int y =find(subset,nextedge.dest);
           if(x!=y)
           {
               result[e++]=nextedge;
               union(subset,x,y);
           }
        }
       System.out.println("Following are the edges in "
                           + "the constructed MST");
        int minimumCost = 0;
        for (i = 0; i < e; ++i)
        {
            System.out.println(result[i].src + " -- "
                               + result[i].dest
                               + " == " + result[i].weight);
            minimumCost += result[i].weight;
        }
        System.out.println("Minimum Cost Spanning Tree "
                           + minimumCost);
    }
    
    public static void main(String args[]) {
        int V = 4; 
        int E = 5; 
        Graph graph = new Graph(V, E);
        
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 10;
 
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 6;
 
        graph.edge[2].src = 0;
        graph.edge[2].dest = 3;
        graph.edge[2].weight = 5;
 
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 15;
 
        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 4;
 
        graph.KruskalMST();
    }
}
