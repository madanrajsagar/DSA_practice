import java.util.*;

class MajorityElement2 {
    public static List<Integer> majorityElement(int[] nums) {
     HashMap<Integer,Integer> map= new HashMap<>();
    List<Integer> ans= new ArrayList<>();
     for(int i=0;i<nums.length;i++){
        if(map.containsKey(nums[i])){
            map.put(nums[i],map.get(nums[i])+1);
            continue;
        }
        map.put(nums[i],1);
     }   
        
    for(Integer i :map.keySet()){
        if(map.get(i)>(nums.length/3)){
            ans.add(i);
        }
    }

    return ans;

    }

    public static void main(String args[]){
        System.out.println(majorityElement(new int[]{1,3,2,5,1,3,1,5,1}));
    }
}