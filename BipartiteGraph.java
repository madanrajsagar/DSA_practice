import java.util.*;
import java.util.LinkedList;

public class BipartiteGraph {
    static class Edge{
        int src;
        int dest;

        Edge(int s,int d){
            this.src=s;
            this.dest=d;
        }
    }
    public static boolean isBipartite(ArrayList<Edge> graph[]){
            int col[]=new int[graph.length];
            for(int i=0;i<col.length;i++){
                col[i]=-1;      //no color initially
            }

            Queue<Integer> q = new LinkedList<>();
            for(int i=0;i<graph.length;i++){
                if(col[i]==-1){ //BFS
                     q.add(i);
                     col[i]=0;//yellow
                     while(!q.isEmpty()){
                        int curr=q.remove();
                        for(int j=0;j<graph[curr].size();j++){
                            Edge e= graph[curr].get(j);
                            if(col[e.dest]==-1){
                                int nextcol=(col[curr]==0)?1:0;
                                col[e.dest]=nextcol;
                                q.add(e.dest);
                            }else if(col[e.dest]==col[curr]){
                            return false;
                            }
                        }

                     }
                }
                     
            }
            return true;


    }

    public static void main(String args[]){
        int v=5;
         @SuppressWarnings("unchecked")
       ArrayList<Edge>[] graph=new ArrayList[v]; 
        for(int i=0;i<5;i++){
            graph[i]=new ArrayList<>();
        }
         graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 0));

        // 0 -- 2
        graph[0].add(new Edge(0, 2));
        graph[2].add(new Edge(2, 0));

        // 1 -- 3
        graph[1].add(new Edge(1, 3));
        graph[3].add(new Edge(3, 1));

        // 2 -- 3
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 2));
        

        System.out.println(isBipartite(graph));

    }
}
