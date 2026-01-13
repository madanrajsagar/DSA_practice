public class print_subarray
{
    public static void print(int [] arra)
    {
        int smallest=Integer.MAX_VALUE;
        int largest =Integer.MIN_VALUE;
 
        for(int i=0;i<arra.length;i++)
        {
            int start = i;
            for(int j=i;j<arra.length;j++)
            {
                int end=j;
                 int sum=0;
                for(int k=start; k<=end;k++)
                {
                    System.out.print(arra[k]+" ");
                    sum=sum+arra[k];
                }
                System.out.print(" ");
                if(sum>largest)
                {
                    largest =sum;
                }
                if(sum<smallest)
                {
                    smallest=sum;
                }
            }
            System.out.println("");
        } 

        System.out.println("Sum of largest array is :"+largest);
         System.out.println("Sum of smallest array is :"+smallest);
    }

    public static void main(String arg[])
    {
        int arr []={10,20,30,40,50,60};
        print(arr);
    }
}