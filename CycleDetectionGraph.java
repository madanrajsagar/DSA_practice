import java.util.ArrayList;

public class CycleDetectionGraph {
    static class Edge{
        int src;
        int dest;

        Edge(int s,int d){
            this.src=s;
            this.dest=d;
        }
    }
    public static boolean detectCycleUtils(ArrayList<Edge>graph[],boolean vis[],int curr,int par){
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!vis[e.dest]){
                if(detectCycleUtils(graph, vis, e.dest, curr)){
                    return true;
                }
            }else if(vis[e.dest]&& e.dest!=par){
                return true;
            }
        }
        return false;

    }

    public static boolean  detectCycle(ArrayList<Edge>[]graph){
        boolean vis[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(detectCycleUtils(graph,vis,i,-1)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
          int V=5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph= new ArrayList[V];

        for(int i=0;i<V;i++){
            graph[i]=new ArrayList<>();
        }


                // / Vertex 0
        graph[0].add(new Edge(0, 1));

        // Vertex 1
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));

        // Vertex 2
        graph[2].add(new Edge(2, 1));

        // Vertex 3
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        // Vertex 4
        graph[4].add(new Edge(4, 3));

            // // Vertex 0
            // graph[0].add(new Edge(0, 1));

            // // Vertex 1
            // graph[1].add(new Edge(1, 0));
            // graph[1].add(new Edge(1, 2));
            // graph[1].add(new Edge(1, 3));

            // // Vertex 2
            // graph[2].add(new Edge(2, 1));
            // graph[2].add(new Edge(2, 3));   // <-- Cycle edge

            // // Vertex 3
            // graph[3].add(new Edge(3, 1));
            // graph[3].add(new Edge(3, 2));   // <-- Cycle edge
            // graph[3].add(new Edge(3, 4));

            // // Vertex 4
            // graph[4].add(new Edge(4, 3));
        System.out.println(detectCycle(graph));
      
    }

}
