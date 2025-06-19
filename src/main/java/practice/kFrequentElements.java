package practice;

import java.util.*;

public class kFrequentElements {
    public static void main(String[] args) {

//        Top K Frequent elements

//        Store the key as a number and value as number of repetations
//        create List of int array
//        using Map.Entry interface add the value and key into the List of int array
//        Sort the List<int[]> to store the result
//        Create another int[] var and
//        Get the 2nd value of List<int[]> and store in var which is created to store the result
//        Extract the top k elements and log it

        int[] nums = {1,2,2,3,3,3};
        int k=3;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        List<int[]> arr = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            arr.add(new int[] {entry.getValue(), entry.getKey()});
        }
        arr.sort((a,b) -> b[0] - a[0]);
        int[] res = new int[k];
        for(int i=0; i < k;i++){
            res[i] = arr.get(i)[1];
        }
        System.out.println(Arrays.toString(res));
    }
}
