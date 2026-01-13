public class solid_rombus
{
    public static void pattern(int n)
    {
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=(n-i);j++)
            {
                System.out.print(" ");
            }
            for(int j=1;j<=n;j++)
            {
                // for HOLLOW RHOMBUS
                // if(i==1 || i==n ||j==1||j==n)
                // {
                // System.out.print("*");
                // }
                // else{
                //      System.out.print(" ");
                // }

                // for SOLID RHOMBUS
                System.out.print("*");

            }
            System.out.println("");
            
         }
    }
    public static void main(String s[])
    {
        pattern(7);

    }
}