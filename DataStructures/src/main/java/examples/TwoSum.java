package examples;

import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {

    }
    public int[] twoSum( int[] nums, int target){

     HashMap<Integer,Integer> hm = new HashMap<Integer, Integer>();

     for(int i =0; i<nums.length; i++){
         int temp = target - nums[i];

         if(hm.keySet().contains(temp)){
             return new int[]{hm.get(temp), i};
         }
         hm.put(nums[i],i );

     }
        return new int[0];
    }
}
