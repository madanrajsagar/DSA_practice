import java.util.*;
import java.util.LinkedList;
public class Graph {

    static class Edge{
        int src;
        int dest;
        int wt;

        Edge(int s,int d, int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }

    public static void bfsUtils(ArrayList<Edge> []graph,boolean vis[],int start){
        Queue<Integer> q= new LinkedList<>();
        
        q.add(start);
        while(!q.isEmpty()){
            int curr= q.remove();
            if(!vis[curr]){
                System.out.print(curr+" ");
                vis[curr]=true;
                for(int i=0;i<graph[curr].size();i++){
                    q.add(graph[curr].get(i).dest);
                }
                
            }
        }

    }

    public static void bfs(ArrayList<Edge> graph[]){
        boolean vis[]=new boolean[graph.length];

        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                bfsUtils(graph,vis,i);
            }
        }
    }
    public static void dfsUtils(ArrayList<Edge>[]graph, int curr, boolean vis[]){
        System.out.print(curr+" ");
        vis[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!vis[e.dest]){              
                dfsUtils(graph,e.dest,vis);
            }
        }

    }

    public static void dfs(ArrayList<Edge>[]graph){
        boolean vis[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i])
            dfsUtils(graph, i, vis);
        }
    }

    public static boolean hasPath(
        <Edge>[] graph,int src,int dest,boolean vis[]){
        if(src==dest)
            return true;
        vis[src]=true;

        for(int i=0;i<graph[src].size();i++){
            Edge e= graph[src].get(i);
            if(!vis[e.dest] && hasPath(graph, e.dest, dest, vis)){
                return true;
            }
        }
        return false;
    }
    
    public static void main(String args[]){

        int V=5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph= new ArrayList[V];

        for(int i=0;i<V;i++){
            graph[i]=new ArrayList<>();
        }


        //vertex 0
        graph[0].add(new Edge(0,1, 5));

        // vertex 1
        graph[1].add(new Edge(1,0,5));
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,3));

        // vertex 2
        graph[2].add(new Edge(2,1,1));
        graph[2].add(new Edge(2,4,2));
        graph[2].add(new Edge(2,3,1));

        // vertex 3
        graph[3].add(new Edge(3,1,3));
        graph[3].add(new Edge(3,2,1));

        // vertex 4
        graph[4].add(new Edge(4, 2, 2));
        
        
        // 2's neighbour
        // for(int i=0;i<graph[2].size();i++){
        //     Edge e= graph[2].get(i);
        //     System.out.println(e.dest);
        // }
        
        bfs(graph);
        System.out.println();
        dfs(graph);

        
        // System.out.println(hasPath(graph, 0, 3, new boolean[V]));
    
        
    }
}
