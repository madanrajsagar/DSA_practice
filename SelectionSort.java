public class SelectionSort{
    public static void main(String args[]){
        int arr[]={2,44,65,10,8};

        for(int i=0;i<arr.length;i++){
            int minpos=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[minpos]>arr[j]){
                    minpos=j;
                }
            }
            int temp= arr[minpos];
            arr[minpos]=arr[i];
            arr[i]=temp;
        }

        for(int i=0;i<arr.length;i++){
        System.out.println(arr[i]);
        }

    }
}