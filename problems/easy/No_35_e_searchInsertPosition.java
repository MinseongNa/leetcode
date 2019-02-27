package problems.easy;

import java.util.Arrays;

/**
 * 35. Search Insert Position
 *
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 *
 * Example 1:
 *
 * Input: [1,3,5,6], 5
 * Output: 2
 *
 *
 * Example 2:
 *
 * Input: [1,3,5,6], 2
 * Output: 1
 *
 *
 * Example 3:
 *
 * Input: [1,3,5,6], 7
 * Output: 4
 *
 *
 * Example 4:
 *
 * Input: [1,3,5,6], 0
 * Output: 0
 */
public class No_35_e_searchInsertPosition {
    public static int searchInsert(int[] nums, int target) {

        if( target == nums[0] || target < nums[0] ){
            return 0;
        }else if( target == nums[ nums.length - 1 ] ){
            return nums.length - 1;
        }else if( nums[ nums.length - 1 ] < target ){
            return nums.length;
        }

        int startIdx = 0;
        int endIdx = nums.length - 1;
        int targetIdx = 0;
        while( true ) {
            targetIdx = startIdx + ( (endIdx - startIdx) / 2 );

            if( nums[targetIdx] == target ){
                break;
            }
            if( startIdx == targetIdx ){
                targetIdx++;
                break;
            }

            if( nums[targetIdx] < target ){
                startIdx = targetIdx;
            }else if( nums[targetIdx] > target ){
                endIdx = targetIdx;
            }
        }
        return targetIdx;
    }

    public static void main(String[] args) {
        int[] testArr = { 1, 3, 5, 6 };
        int[] targetArr = { 5, 2, 7, 0 };
        for( int target : targetArr ){
            System.out.println( "Input: " + Arrays.toString( testArr ) + ", " + target );
            System.out.println( "Output: " + searchInsert( testArr, target ) + System.lineSeparator() );
        }
    }
}
