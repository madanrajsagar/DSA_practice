public class H_balancedStringSplit{
    public static void main(String[] args) {
     String s="RLRRLLRLRL";
    int r=0;
    int l=0;
    int count=0;
    for(int i=0;i<s.length();i++){
        if(s.charAt(i)=='R'){
            r++;
        }else{
            l++;
        }

        if(r==l){
            count++;
            l=0;
            r=0;
        }
    } 

    System.out.println(count);  
    }
    
}