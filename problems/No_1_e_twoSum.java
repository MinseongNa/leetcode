package problems;

import xyz.msna.mdmaker.annotation.ExecuteResult;

import java.util.HashMap;

/**
 * 1. Two Sum
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */

@ExecuteResult(runtimeMs = 7, memoryMb = 26.1f )
public class No_1_e_twoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> diffMap = new HashMap<>();
        for( int index = 0; index < nums.length; index++ ){
            if( diffMap.containsKey( nums[index] ) ){
                return new int[]{ diffMap.get( nums[index] ), index };
            }
            diffMap.put( target-nums[index], index );
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;

        int[] result = new No_1_e_twoSum().twoSum( nums, target );
        System.out.println( result[0] + ", " + result[1] );
    }

}
