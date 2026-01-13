public class MergeSortOnStr{

        public static void printArr(String a[]) {
        for(int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }


    public static void mergeSort(String arr[],int si, int ei){
        if(si>=ei){
            return;
        }

    int mid = si+(ei-si)/2;

    mergeSort(arr,si,mid);
    mergeSort(arr,mid+1,ei);

    merge(arr, si,ei,mid);

    }


    public static void merge(String []arr,int si,int ei,int mid){

        int i= si;
        int j= mid+1;
        int k=0;
        String temp[]= new String[ei-si+1];

        while(i<=mid && j<=ei){
            if(arr[i].compareTo(arr[j])<=0){
                temp[k]=arr[i];
                i++;
            }else{
                temp[k]=arr[j];
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

        for(k=0,i=si;k<temp.length;i++,k++){
            arr[i]=temp[k];
        }
    }
    public static void main(String args[]){
        
        String str[] = { "sun", "earth", "mars", "mercury"};
        printArr(str);
        mergeSort(str,0,str.length-1);
        System.out.println("--------After Sorting the Strings :: --------");
        printArr(str);
      
    }

}