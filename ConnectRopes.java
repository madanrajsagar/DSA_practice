import java.util.PriorityQueue;
public class ConnectRopes{
    public static void main(String args[]){
        int ropes[]= {4,3,2,6};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<ropes.length;i++){
            pq.add(ropes[i]);
        }

         int cost=0;

        while(pq.size()>1){
            int min=pq.poll();
            int min2=pq.poll();
            cost+=min+min2;
            pq.add(min+min2);

        } 

        System.out.println("Minimum Cost for above ropes ="+cost);
    }
}