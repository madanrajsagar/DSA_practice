public class FindOccurence {

    public static void findOccurence(int i,int arr[],StringBuilder str,int key){
        if(i==arr.length){
            System.out.println(str.reverse());
            return;
        }

        if(key==arr[i]){
            str.append(i);
        }

        findOccurence(i+1, arr, str, key);


    }

    public static void main(String args[]){
        
        int arr[] = {3,2,4,5,6,2,7,2,2};
        int key=2;
        findOccurence(0,arr,new StringBuilder(""),key);
  
} 
}