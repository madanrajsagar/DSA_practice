import java.util.Stack;
public class DuplicateParentheses
{
        public static boolean isDuplicate(String str){
            Stack<Character> st= new Stack<>();
                for(char ch:str.toCharArray()){

                    // closing check
                    if(ch==')'){
                        int count=0;

                        while(st.peek()!='('){
                            st.pop();
                            count++;
                        }
                        if(count<1)
                        return true;
                        else
                        st.pop();
                    }else{
                        // opening condition
                      st.push(ch);

                    }
                     
                }
                return false;
        }

    public static void main(String args[]){
        String str="((a+b))";//true
        String str2="(a-b)"; //false

        System.out.println(isDuplicate(str));
        System.out.println(isDuplicate(str2));

    }
}