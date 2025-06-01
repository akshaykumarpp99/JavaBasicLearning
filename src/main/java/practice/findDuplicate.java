package practice;

import java.util.HashSet;
import java.util.Set;

public class findDuplicate {
    public static void main(String[] args){
        int[] nums = {1,1,3,4,5,6,7};
        findDuplicate demo = new findDuplicate();
        boolean res = demo.duplicatesHunt(nums);
        boolean res1 = demo.duplicateHunt2(nums);
        System.out.println(res);
        System.out.println(res1);
    }

    public boolean duplicatesHunt(int[] nums){
        Set<Integer> temp = new HashSet<Integer>();
        for(int num : nums){
            if(temp.contains(num)){
                return true;
            }
            temp.add(num);
        }
        return false;
    }

    public boolean duplicateHunt2(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++){
                if( nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
}
