import java.util.*;
public class Chocola_problem{
    public static void main(String[] args) {
        int n=6;
        int m=4;
        Integer []costHor={2,1,3,1,4}; //n-1
        Integer []costver={4,1,2};  //m-1
        
        Arrays.sort(costHor,Collections.reverseOrder());        
        Arrays.sort(costver,Collections.reverseOrder());        
        
        int v=0,h=0;
        int vp=1,hp=1;
        int cost=0;
        
        
            while(h<costHor.length && v<costver.length){
               if(costHor[h]<costver[v]){
                    cost+=costver[v]*hp;
                    v++;
                    vp++;
               }else{
                cost+=costHor[h]*vp;
                h++;
                hp++;
               }
            }

            while(h<costHor.length){
                 cost+=costHor[h]*vp;
                h++;
                hp++;
            }

            while(v<costver.length){
                  cost+=costver[v]*hp;
                    v++;
                    vp++;
            }

        System.out.println(cost);

        
            }
}