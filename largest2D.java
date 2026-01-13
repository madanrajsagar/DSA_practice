
import java.util.Scanner;

public class largest2D
{
    public static void largest(int arr[][])
    {
        int r=arr.length;
        int c= arr[0].length;
        int largest= Integer.MIN_VALUE;

        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(largest<arr[i][j])
                {
                    largest= arr[i][j];
                }
            }
        }
        System.out.println("Largest element from given array is: "+ largest);
    }
    public static void main(String[] args) {
        int arr[][]=new int[3][3];
        
        Scanner sc = new Scanner(System.in);

         for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                arr[i][j]=sc.nextInt();
            }
        }
        largest(arr);
    }
}
