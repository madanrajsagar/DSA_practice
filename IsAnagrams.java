public class IsAnagrams
{
    public static void main(String args[])
    {
        String s1= new String("aaaa");
        String s2= new String("babb");
        
        int count=0;
        if(s1.length()==s2.length())
        {
            for(int i=0;i<s1.length();i++)
            {   int flag=0;
                for(int j=0;j<s2.length();j++)
                {
                        if(s1.charAt(i)== s2.charAt(j))
                        {   flag++;
                        count++;
                        break;
                            
                        }
                        
                }
                if(flag==0)
                {
                    System.out.println("not Anagrams");
                    break;
                }
                
            }
            if(count==s1.length())
            {
                System.out.println("Anagram!");
            }
        }
    }
}