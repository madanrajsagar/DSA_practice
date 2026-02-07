import java.util.Stack;
public class ReverseStringusingStack{
    public static String reverseStr(String str){
        Stack<Character> ch = new Stack<>();
        for(int i=0;i<str.length();i++){
            ch.push(str.charAt(i));
        }
        StringBuilder sb= new StringBuilder("");

        while(!ch.isEmpty()){
            sb.append(ch.pop());
        }
        return  sb.toString();
    }

    public static void main(String[] args){
        String str="abc";
        System.out.println(reverseStr(str));
    }
}