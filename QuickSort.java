public class QuickSort{

    
    public static void printArr(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }


    public static void quickSort(int arr[],int si,int ei){
        if(si>=ei){
            return;
        }

        int pinx =partition(arr,si,ei);
        quickSort(arr, si, pinx-1);//left
        quickSort(arr, pinx+1, ei);//right
    
    }

        public static int partition(int arr[],int si,int ei ){
            int i=si-1;
            int pivot= arr[ei];

            for(int j=si;j<ei;j++){

                if(arr[j]<=pivot){
                    i++;
                    int temp = arr[j];
                    arr[j]  =arr[i];
                    arr[i]=temp;
                }
            }

            i++;
            int temp = pivot;
            arr[ei]=arr[i];
            arr[i]=temp;

            return i;

        }


    public static void main(String args[]){

         int arr[]={3,2,4,1,5};

        System.out.println("Unsorted Array :");
        printArr(arr);
  
        quickSort(arr, 0, arr.length-1);

        System.out.println("Sorted Array :");
        printArr(arr);
        

    }
}