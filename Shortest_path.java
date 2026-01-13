public class Shortest_path
{
    public static float get_shortest_path(String path)
    {
        int x=0,y=0;
        for(int i=0;i<path.length();i++)
        {
            char ch =path.charAt(i);
            // north
            if(ch=='N')
            {
                y++;
            }
            // south
           else if(ch=='S')
            {
                y--;
            }
            // east
            else if(ch=='E')
            {
                x++;
            }
            // west
            else{
                x--;
            }
        }
       int x2=x*x;
       int y2=y*y;
        return (float)Math.sqrt(x2+y2);
    }
    public static void main(String []str)
    {   
        String path= "WNEENESENNN";
        float pa=get_shortest_path(path);
        System.out.println("Shortest Path :"+pa);
    }
}