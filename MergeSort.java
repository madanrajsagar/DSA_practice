
public class MergeSort {

    public static void printArr(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void mergeSort(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }
        int mid = si + (ei - si) / 2; //(si+ei)/2 also ok but not sutaible for long integer value

        mergeSort(arr, si, mid);   //left part assumed to be sorted
        mergeSort(arr, mid + 1, ei); //right part assumed to be sorted

        merge(si, mid, ei, arr);
    }

    public static void merge(int si, int mid, int ei, int arr[]) {

        int i = si;
        int j = mid + 1;
        int k = 0;
        int temp[] = new int[(ei - si) + 1];

        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

            while(i<=mid){
                temp[k++]=arr[i++];
    
            }

            while(j<=ei){
                temp[k++]=arr[j++];

        }

            for( k=0,i=si;k<temp.length;i++,k++){
                arr[i]=temp[k];
            }
    }

    public static void main(String args[]) {
        int arr[]={3,2,4,1,5};

        System.out.println("Unsorted Array :");
        printArr(arr);

        mergeSort(arr,0,arr.length-1);    

        System.out.println("Sorted Array :");
        printArr(arr);
        


    }
}
