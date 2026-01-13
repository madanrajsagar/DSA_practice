class invertedHalfPyramid
{
    public static void halfPyramic(int rows, int cols)
    {
        for(int i=1; i<=rows;i++)
        {
            for(int j=1;j<=cols;j++)
            {
                // if ((i==1 && j<cols) || (i==2 && j<cols-1) || (i==3 && j<cols-2)) {
                //     System.out.print(" ");
                // }
                if(rows-i>=j)
                {
                    System.out.print(" ");
                }
                else
                {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
    public static void halfpyramid(int n)
    {

        for(int i=0;i<n;i++)
        {
            for(int j=1;j<=n-i;j++)
            {
                    System.out.print(j);
            }
            System.out.println();
        }

    }
    public static void main(String args[])
    {

        // halfPyramic(5, 10);
        halfpyramid(10);
    }
}