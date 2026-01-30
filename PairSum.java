import java.util.ArrayList;
public class PairSum{

    // BruteForce
    public static boolean pairSum1(ArrayList<Integer>nums, int target){
        for(int i=0;i<nums.size();i++){
            for(int j=i+1;j<nums.size();j++){
                if(nums.get(i)+nums.get(j)==target){
                    return true;
                }
            }
        }
        return false;
    }

    // Using 2-pointer Approach  O(n)
    public static boolean pairSum2(ArrayList<Integer>nums, int target){
       int lp =0;
       int rp=nums.size()-1;
        while(lp<rp){
            if(nums.get(lp)+nums.get(rp)==target){
                return true;
            }else if(nums.get(lp)+nums.get(rp)<target){
                lp++;
            }else{
                rp--;
            }
        }


        return false;
    }


    public static void main(String args[]){
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        int target=5;
        System.out.println(pairSum1(nums,target));
        System.out.println(pairSum2(nums,target));
        
    }
}