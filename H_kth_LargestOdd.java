public class H_kth_LargestOdd{

    public static void main(String[] args) {
        int L=-3,R=3,K=1;
        if(K<=0){
                System.out.println(0);
                return;
        }
        if((R&1)==1){
            int count=(int) Math.ceil((R-L+1)/2);
            if(K>count){
                System.out.println(0);
                return;
            }
            else{
                System.out.println(R-2*K+2);
                return;
            }
        }else{
            int count =(R-L+1)/2;
            if(K>count)
            {
                System.out.println(0);
                return;
            }else{
                
                System.out.println(R-2*K+1);
                return;
            }
            }
        }
    
    }
