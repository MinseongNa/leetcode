package problems;

import java.math.BigDecimal;

/**
 * 7. Reverse Integer
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123
 * Output: 321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−231,  231 − 1].
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
public class No_7_e_reverseInteger {
    public static int reverseByChar(int x) {
        if( x == 0 ){
            return 0;
        }

        StringBuilder sb = new StringBuilder();
        if( x < 0 ){
            sb.append( "-" );
        }

        char[] xCharArray = String.valueOf( x ).toCharArray();
        for( int ridx = xCharArray.length - 1 ; ridx >= 0; ridx-- ){
            char ch = xCharArray[ridx];
            if( ch == '-' ){
                break;
            }
            sb.append( ch );
        }

        long reverseX = new BigDecimal( sb.toString() ).longValue();
        if( reverseX > Integer.MAX_VALUE || reverseX < Integer.MIN_VALUE ){
            return 0;
        }

        return (int) reverseX;
        // 28ms, 38MB
    }

    public static int reverseByCalc( int x ){
        if( x == 0 ){
            return 0;
        }
        long reverseX = 0;
        while( x != 0 ){
            int mod = x % 10;
            x = x / 10;
            reverseX = ( reverseX * 10 ) + mod;
        }
        double MIN_32BIT_INT = Math.pow( -2, 31 );
        double MAX_32BIT_INT = Math.pow(  2, 31 ) - 1;
        if( reverseX < MIN_32BIT_INT || MAX_32BIT_INT < reverseX ){
            return 0;
        }

        return (int) reverseX;
        // 15ms, 38MB
    }

    public static void main(String[] args) {
        int[] testDataArr = { 123, -123, 120 };
        for( int testData : testDataArr ){
            System.out.println( "Input : " + testData );
            System.out.println( "Output : " + reverseByCalc( testData ) );
        }
    }
}
