import java.util.ArrayList;


public class MaxwaterStore{

    // Brute-force approach
    public static void storeWater(ArrayList<Integer> height) {
        int maxWater = Integer.MIN_VALUE;

        for (int i = 0; i < height.size(); i++) {
            for (int j = i + 1; j < height.size(); j++) {
                int width = j - i;
                int ht = Math.min(height.get(i), height.get(j));
                int currWater = width * ht;
                maxWater = Math.max(maxWater, currWater);

            }
        }

        System.out.println("Maximum water it contains : " + maxWater);

    }

      //2 Pointer Approach O(n)
    public static void storeWaterO(ArrayList<Integer> height) {
        int maxWater = Integer.MIN_VALUE;
        int fp=0;
        int lp=height.size()-1;

        while(fp<lp){
            int wd= lp-fp;
            int ht=Math.min(height.get(lp),height.get(fp));
            int currWt=wd*ht;
            maxWater= Math.max(maxWater,currWt);

            if(height.get(fp)<height.get(lp)){
                fp++;
            }else{
                lp--;
            }
        }

        System.out.println("Maximum water it contains : " + maxWater);

    }
  
    public static void main(String args[]){
        ArrayList<Integer> height= new ArrayList<>();
        // 1,8,6,2,5,4,8,3,7
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        
        storeWater(height);
        storeWaterO(height);
    }
}