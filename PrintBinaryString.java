public class PrintBinaryString{
    public static void printBStr(int n, int lp, String s){
        if(n==0){
            System.out.println(s);
            return ;
        }

        printBStr(n-1,0,s+0);

        if(lp==0){
            printBStr(n-1,1,s+1);
        }
    }
    public static void main(String args[]){
        printBStr(3,0,"");
    }
}