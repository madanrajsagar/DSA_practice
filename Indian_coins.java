import java.util.*;
public class Indian_coins{
    public static void main(String[] args) {
        Integer coins[]={1,2,5,10,20,50,100,500,2000};
        int amount=590;
        int mincoins=0;
        Arrays.sort(coins,Comparator.reverseOrder());       

        for(int i=0;i<coins.length;i++){
            if(coins[i]<=amount){
                while(coins[i]<=amount){
                    mincoins++;
                    amount-=coins[i];
                }
            }
        }

        System.out.println(mincoins);
    

    
    }
}