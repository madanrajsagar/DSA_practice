import java.util.PriorityQueue;
public class SlidingWindowMaximum{
     static class Pair implements Comparable<Pair>{
        int val;
        int idx;
        Pair(int val,int idx){
            this.val=val;
            this.idx=idx;
        }

        public int compareTo(Pair p2){
            return p2.val-this.val;
        }
    }
    public static void main(String args[]){
        int window[]= {1,2,3,4,5,6,7,8,9,10};
        int k=3;
        int ans[]= new int[window.length-k+1];

        PriorityQueue<Pair> pq= new PriorityQueue<>();
        // 1st window
        for(int i=0;i<k;i++){
            pq.add(new Pair(window[i],i));
        }
        ans[0]=pq.peek().val;

        for(int i=k;i<window.length;i++){
            while(!pq.isEmpty() &&pq.peek().idx<=(i-k) ){
                pq.poll();
            }
            pq.add(new Pair(window[i],i));
            ans[i-k+1]=pq.peek().val;
        }

        // print result
        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i]);
        }


    }
}