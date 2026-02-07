import java.util.Stack;
public class NextGreater{
    public static void main(String args[]){
        Stack<Integer> st=new Stack<>();
        int arr[]={6,8,0,1,3};
        int []nextGT=new int[arr.length];

        for(int i=arr.length-1;i>=0;i--){
            // 1.while
            while(!st.isEmpty()&&arr[i]>=arr[st.peek()]){
                st.pop();
            }
            // 2. if-else
            if(st.isEmpty()){
                nextGT[i]=-1;
            }else{
                nextGT[i]=arr[st.peek()];
            }
            // 3.if-else
            st.push(i);
        }
        for(int i=0;i<nextGT.length;i++){        
        System.out.println(nextGT[i]);
        }
    }
}


 