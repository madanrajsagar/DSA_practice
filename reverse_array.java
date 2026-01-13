public class reverse_array
{
    public static void reverse(int arr[])
    {
int first=0,last=arr.length-1;
while(arr[first]<arr[last])
{
    int temp =arr[first];
    arr[first]=arr[last];
    arr[last]=temp;
}  
        }
    public static void main(String args[])
    {
        int arr[]= {1,33,43,22,31,41};
        reverse(arr);

        for(int i=0; i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }


    }

}