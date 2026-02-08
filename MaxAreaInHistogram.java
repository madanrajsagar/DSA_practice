import java.util.Stack;
public class MaxAreaInHistogram{

    public static int  findMaxArea(int []height){
       int nsr[]= new int[height.length];
       int nsl[]= new int[height.length];
        Stack<Integer> st = new Stack<>();
        // find next smaller right
        for(int i=height.length-1;i>=0;i--){
             while(!st.isEmpty()&&height[i]<=height[st.peek()]){
                st.pop();
             }
             if(st.isEmpty()){
                nsr[i]=height.length;
             }else{
                nsr[i]=st.peek();
             }
             st.push(i);
        }

       st = new Stack<>();
    //    for next smaller left
        for(int i=0;i<height.length;i++){
               while(!st.isEmpty()&&height[i]<=height[st.peek()]){
                st.pop();
               } 
               if(st.isEmpty()){
                nsl[i]=-1;
               }else{
                nsl[i]=st.peek();
               }
               st.push(i);
        }

        int maxArea=Integer.MIN_VALUE;
        for(int i=0;i<height.length;i++){
            int width=nsr[i]-nsl[i]-1;
            int currArea=width*height[i];
            maxArea=Math.max(maxArea,currArea);
        }
        return maxArea;
    }
    public static void main(String[] args){
        int height[]={2,1,5,6,2,3};
        System.out.println("Maximum Area in Histogram :"+findMaxArea(height));
    }
}