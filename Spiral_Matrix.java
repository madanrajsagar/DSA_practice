public class Spiral_Matrix
{
    public static void print_spiral(int arr[][])
    {
        int st_row=0;
        int st_col=0;
        int end_row=arr.length-1;
        int end_col=arr[0].length-1;

        while(st_row<=end_row && st_col<=end_col)
        {
            //top
            for(int j=st_col;j<=end_col;j++)
            {
                System.out.print(arr[st_row][j]+" ");
            }

            //right

            for(int i=st_row+1;i<=end_row;i++)
            {
                System.out.print(arr[i][end_col]+" ");
            }

            //bottom
            for(int j=end_col-1;j>=st_col;j--)
            {
                if(st_col==end_col)
                {
                    break;
                }
                System.out.print(arr[end_row][j]+" ");
            }

            //Left

            for(int i=end_row-1;i>=st_row+1;i--)
            {
                    if(st_row==end_row)
                    {
                        break;
                    }
                 System.out.print(arr[i][st_col]+" ");
            }

            st_row++;
            st_col++;
            end_col--;
            end_row--;
        System.out.println("");
        }
    }

    public static void main(String args[])
    {
        int matrix[][]={{1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12},
                        {13,14,15,16},
                        {33,44,55,66}};
        print_spiral(matrix);

    }
}