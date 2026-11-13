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

    public static int tabu(int n){
        int temp[]= new int[n+1];
        temp[0]=0;
        temp[1]=1;
        for(int i=2;i<=n;i++){
            temp[i]=temp[i-1]+temp[i-2];
        }
        return temp[n];
    }
    public static void main(String args[]){
        int n=5;
      
        System.out.println(fib(n));
        System.out.println(tabu(n));
        
    }
    
}
