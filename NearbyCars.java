import java.util.PriorityQueue;
public class NearbyCars{
    public static class Points implements Comparable<Points>{
        int x;
        int y;
        int dist;
        int idx;

        Points(int x, int y, int dist,int idx){
            this.x=x;
            this.y=y;
            this.dist=dist;
            this.idx=idx;
        }

        @Override
        public int compareTo(Points p2){
            return this.dist-p2.dist;
        }
    }
    public static void main(String[] args) {
    int points[][]={{3,3},{5,-1},{-2,4}};
    int k=2;
    PriorityQueue<Points> pq=new PriorityQueue<>();
    for(int i=0;i<points.length;i++){
        int dist=points[i][0]*points[i][0]+points[i][1]*points[i][1];
        pq.add(new Points(points[i][0],points[i][1],dist,i));
    }
        
    for(int i=0;i<k;i++){
        System.out.println("C"+pq.poll().idx);
    }
    }
}