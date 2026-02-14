public class QueueusingArray{
    public static class Queue{
        static int size;
        static int queue[];
        static int rear;
        static int front;
        public Queue(int size){
            this.size=size;
            queue= new int[size];
            rear=-1;
            front=-1;
        }

        public static boolean isEmpty(){
            return rear==-1 &&front ==-1;
        }
        public static boolean isFull(){
            return (rear+1)%size==front;
        }

        public static void enqueue(int data){
            if(isFull()){
                System.out.println("Queue is full");
                return;
            }
            // add first element
            if(front==-1){
                front =0;
            }

            rear=(rear+1)%size;
            queue[rear]=data;
        }

        public static int dequeue(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int result=queue[0];
            // last el delete
            if(rear==front){
                rear=front=-1;
            }else{
                front=(front+1)%size;

            }
            
            return result;
        }

        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return queue[front];
        }
        
    }
    
    public static void main(String args[])
    {
        Queue q=new Queue(3);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q.dequeue());
        q.enqueue(4);
        System.out.println(q.dequeue());
        q.enqueue(5);
        
    while(!q.isEmpty()){
        System.out.println(q.peek());
        q.dequeue();
    }
//     q.dequeue();
//     q.dequeue();
//     for(int i=0;i<=q.rear;i++){
// System.out.println(q.queue[i]);
        
//     }
        
    }
    
}