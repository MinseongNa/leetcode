package problems.easy;

/**
 * 53. Maximum Subarray
 *
 *  Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 *
 * Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class No_53_e_maximumSubarray {

    public static int maxSubArray(int[] nums) {
        if( nums.length == 1 ){
            return nums[0];
        }
        int maxSum = Integer.MIN_VALUE;
        for( int i = 0; i < nums.length; i++ ){
            int sum = 0;
            for( int j = i; j < nums.length; j++ ){
                sum += nums[j];
                maxSum = maxSum < sum ? sum : maxSum;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] testData = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        testData = new int[]{-2,1};
        System.out.println( maxSubArray( testData ) );
    }
}
