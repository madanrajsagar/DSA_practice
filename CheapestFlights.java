import java.util.*;
import java.util.LinkedList;
public class CheapestFlights{
     static class Edge{
        int src;
        int dest;
        int wt;

         Edge(int src,int dst,int wt){
            this.src=src;
            this.dest=dst;
            this.wt=wt;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[],int flights[][]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        for(int i=0;i<flights.length;i++){
            int src=flights[i][0];
            int dts=flights[i][1];
            int wt=flights[i][2];
            Edge e= new Edge(src,dts,wt);
            graph[src].add(e);
        
        }
    }
    public static class Info{
        int v;
        int cost;
        int stops;
        public Info(int v,int cost,int stops){
            this.v=v;
            this.cost=cost;
            this.stops=stops;
        }
    }

     static int cheapestFlight(int n,int src,int dest,int k, int[][]flights,ArrayList<Edge>[]graph){
        createGraph(graph,flights);
        int dist[]= new int[n];
        for(int i=0;i<n;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }

        Queue<Info> q=new LinkedList<>();
        q.add(new Info(src,0,0));

        while(!q.isEmpty()){
            Info curr=q.remove();
            if(curr.stops>k){
                break;
            }

            for(int i=0;i<graph[curr.v].size();i++){
                Edge e= graph[curr.v].get(i);
                int v=e.src;
                int u=e.dest;
                int wt=e.wt;

                if(curr.cost+wt<dist[u] && curr.stops<=k){
                    dist[u]=curr.cost+wt;
                    q.add(new Info(u,dist[u],curr.stops+1));
                }

            }

           
        }
         if(dist[dest]==Integer.MAX_VALUE){
                return -1;
            }else{
                return dist[dest];
            }
        
    }


    public static void main(String args[]){
        int flights[][]={{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[4];
        int src=0;
        int dst=3;
        int k=1;
        System.err.println(cheapestFlight(flights.length,src,dst,k,flights,graph));

    
    }
}