public class SimpleBacktracking{

    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    public static void backtrack(int arr[],int i,int val){
        if(arr.length==i){
            printArr(arr);
            return ;
        }
        // arr[i]=i+1;
        // arr[i]=backtrack(arr,++i);
        // return i-3;
        // OR
        // recursion
        arr[i]=val;
        backtrack(arr,i+1,val+1);
        arr[i]=arr[i]-2;
        
    }

    public static void main(String stre[]){
        int []arr= new int[5];

        backtrack(arr,0,1);
        System.out.println("--------After Backtracking--------");
        printArr(arr);
    


    }
}