package problems.easy;

import xyz.msna.mdmaker.annotation.ExecuteResult;

import java.util.Arrays;

/**
 * 66. Plus One
 *
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list,
 * and each element in the array contain a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 *
 *
 * Example 2:
 *
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 */

@ExecuteResult( runtimeMs = 0, memoryMb = 34.9f )
public class No_66_e_plusOne {
    public static int[] plusOne(int[] digits) {

        // digits가 비어있으면 +1이 할 수 없으므로 그대로 리턴한다.
        if( digits == null ){
            return digits;
        }

        // +1을 해야하는데, 다른 로직을 넣는 것은 불필요하므로 소숫점 이하에서 캐리오버된 것으로 한다.
        int carryOver = 1;

        // 가장 아랫자리부터 캐리오버가 되었는지 체크하면서 높은 자리로 올라온다.
        for( int i = digits.length - 1; i >= 0; i-- ){
            digits[i] += carryOver;
            if( digits[i] >= 10 ){
                carryOver = 1;
                digits[i] -= 10;
            }else{
                carryOver = 0;
            }
        }

        // 가장 높은 자릿수가 캐리오버 되었다면 지금 배열 사이즈로는 처리가 불가하므로 새로운 배열을 만들어서 그 값으로 리턴한다.
        if( carryOver > 0 ){
            int[] temp = new int[ digits.length + 1 ];
            temp[0] = carryOver;
            System.arraycopy( digits, 0, temp, 1, digits.length );
            digits = temp;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[][] inputArr2 = { {1,2,3}, {4,3,2,1}, {6,1,4,5,3,9,0,1,9,5,1,8,6,7,0,5,5,4,3}, {9,9,9,9} };
        for( int[] inputArr1 : inputArr2 ){
            System.out.println( "Input : " + Arrays.toString( inputArr1 ) );
            System.out.println( "Output : " + Arrays.toString( plusOne( inputArr1 ) ) + System.lineSeparator() );
        }
    }
}
