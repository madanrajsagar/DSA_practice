public class SortedAndRotatedArray {

   public static int search(int []arr,int si,int ei,int tar){

        if(si>ei){
            return -1;
        }

        // kaam
        int mid = si+(ei-si)/2;

        if(arr[mid]==tar){
            return mid;
        }

        // mid on l1
        if(arr[si]<=arr[mid]){
            // case A: left
            if(arr[si]<=tar && tar<=arr[mid]){
                return search(arr,si,mid-1,tar);
            }else{
                // case B: right
                return search(arr,mid+1,ei,tar);
            }
        }

        // mid on l2
        else{
            // case c: right
            if(arr[mid]<=tar && tar<=arr[ei]){
                return search(arr,mid+1,ei,tar);
            }else{
                // case d: left
                return search(arr,si,mid-1,tar);
            }

        }

    }

    public static void main(String args[])
    {
      int arr[] = {4,5,6,7,0,1,2};
      System.out.println(search(arr,0,arr.length,6));

    }
}