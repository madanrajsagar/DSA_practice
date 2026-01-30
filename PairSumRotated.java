
import java.util.ArrayList;

public class PairSumRotated {

    public static boolean pairSum2(ArrayList<Integer> nums, int target) {
        int br = 0;
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                br = i;
                break;
            }
        }
        int lp = br + 1;
        int rp = br;
        while (lp != rp) {
            if (nums.get(lp) + nums.get(rp) == target) {
                return true;
            } else if (nums.get(lp) + nums.get(rp) > target) {
                rp--;
                if (rp < 0) {
                    rp = nums.size() - 1;
                }

            } else {
                lp++;
                if(lp==nums.size()){
                    lp=0;
                }
            }
        }
        return false;

    }

    public static void main(String args[]) {

        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(11);
        nums.add(15);
        nums.add(6);
        nums.add(8);
        nums.add(9);
        nums.add(9);

        int target = 21;
        System.out.println(pairSum2(nums, target));

    }
}
