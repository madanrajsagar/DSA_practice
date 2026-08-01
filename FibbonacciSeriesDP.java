public class FibbonacciSeriesDP {
    public static int fibbo(int fib[],int n){
       if(n==0||n==1){
        return n;
       } 
        if(fib[n]!=0){
            return fib[n];
        }

        fib[n]=fibbo(fib,n-1)+fibbo(fib,n-2);
        return fib[n];
    }
    public static int fib(int n) {
        int fib[]=new int[n+1];
        return fibbo(fib,n);
    }
    public static void main(String args[]){
        int n=5;
      
        System.out.println(fib(n));
    }
    
}
