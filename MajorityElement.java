import java.util.*;
public class MajorityElement{
// Brute Force  O(n^2)
    public static int findMajority(int nums[]){
     int maj= nums.length/2;
        int count=0;
    for(int i=0;i<nums.length;i++){
        for(int j=i+1;j<nums.length;j++){
            if(nums[i]==nums[j]){
                count++;
            }
        }
        if(count>maj){
            return nums[i];
        }
    }
    return -1;

    }
// bit optimized approach  O(nlog n)
    public static int findMajority1(int nums[]){
        Arrays.sort(nums);
        int freq =1,ans= nums[0];
        int n =nums.length;
        for(int i =1;i<n;i++){
            if(nums[i]==nums[i-1]){
                freq++;
            }else{
                freq=1;
                ans=nums[i];
            }

            if(freq>n/2){
                return ans;
            }
        }
    return ans;
    }

    // moor's algorithm most optimum  O(n)

    public static int findMajority2(int nums[]){
        int freq=0;
        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(freq==0){
                ans=nums[i];
            }
            if(ans==nums[i]){
                freq++;
            }else{
                freq--;
            }
        }
    return ans;
    }


    public static void main(String[] args){
    int nums[] = {2,2,1,1,1,2,2};
    System.out.println(findMajority2(nums));
    }
}