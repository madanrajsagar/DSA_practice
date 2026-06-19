import java.util.ArrayList;
public class Heaps{

    static ArrayList<Integer> heap = new ArrayList<>();
    public static void add(int data){
        // add at last
        heap.add(data);
        int idx =heap.size()-1;
        int par=(idx-1)/2;

        while(heap.get(par)>heap.get(idx)){
            int temp=heap.get(idx);
            heap.set(idx,heap.get(par));
            heap.set(par,temp);
            idx=par;
            par=(idx-1)/2;
        }
    }
    public static int peek(){
            return heap.get(0);
    }

    public static void heapify(int i){
        int left=2*i+1;
        int right=2*i+2;
        int min=i;

        if(left<heap.size() && heap.get(min)>heap.get(left)){
            min=left;
        }
        if(right<heap.size() && heap.get(min)>heap.get(right)){
            min=right;
        }

        if(i!=min){
            int temp=heap.get(i);
            heap.set(i,heap.get(min));
            heap.set(min,temp);
            heapify(min);
        }

        
    }
    public static int remove(){
        int data=heap.get(0);

        // swap 1st n last
        int temp=heap.get(heap.size()-1);
        heap.set(heap.size()-1,data);
        heap.set(0,temp);

        heap.remove(heap.size()-1);
        heapify(0);

        return data;

    }

    public static boolean isEmpty(){
        return (heap.size()==0);
    }
    public static void main(String[] args) {
        add(1);
        add(7);
        add(5);
        add(4);

        while(!isEmpty()){
        System.out.println(peek());
        remove();
        }
    }
}