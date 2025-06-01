package practice;

public class indexOfTwoSum {



   /* Given an array of integers nums and an integer target, return the indices i and j such that nums[i] + nums[j] == target and i != j.
    You may assume that every input has exactly one pair of indices i and j that satisfy the condition.
    Return the answer with the smaller index first.*/

    public int[] findIndexOfTwoSum(int[] nums, int target){

        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++) {
                if(nums[i]+nums[j]==target){
                    return new int[] {i,j};
                }
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] tem = {1,3,4,5,7};
        int target = 7;
        indexOfTwoSum its = new indexOfTwoSum();
        int[] res = its.findIndexOfTwoSum(tem, target);
        for(int i=0; i<res.length;i++){
            System.out.println(res[i]);
        }
    }
}
