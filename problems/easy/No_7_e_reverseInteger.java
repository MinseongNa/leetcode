package problems.easy;

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

        // 숫자가 0이면 반전해도 0이기 때문에 0을 리턴한다.
        if( x == 0 ){
            return 0;
        }

        StringBuilder sb = new StringBuilder();

        // 문자열로 처리할 땐 음수인지 판단하여 "-"를 먼저 더한다.
        if( x < 0 ){
            sb.append( "-" );
        }

        // 숫자를 문자열로 바꾸고, 문자열의 마지막부터 sb에 더한다.
        // 음수의 경우 마지막 순서에 "-"가 나오는데 break를 해서 sb.append를 피한다.
        char[] xCharArray = String.valueOf( x ).toCharArray();
        for( int ridx = xCharArray.length - 1 ; ridx >= 0; ridx-- ){
            char ch = xCharArray[ridx];
            if( ch == '-' ){
                break;
            }
            sb.append( ch );
        }

        // 파싱한 값이 정수범위를 넘어설 수 있으므로 long으로 계산하고 그 결과가 정수 범위인지 판한단다.
        long reverseX = new BigDecimal( sb.toString() ).longValue();
        if( reverseX > Integer.MAX_VALUE || reverseX < Integer.MIN_VALUE ){
            return 0;
        }

        return (int) reverseX;
        // 28ms, 38MB
    }

    public static int reverseByCalc( int x ){

        // 숫자가 0이면 반전해도 0이기 때문에 0을 리턴한다.
        if( x == 0 ){
            return 0;
        }

        // 나머지 연산자를 이용하여 x의 가장 낮은 자릿수 숫자를 구하고,
        // 그 숫자를 reverseX에 더해주는데, 기존 reverseX를 10곱한 값에 더해준다.
        // x는 1/10씩 작아지고 reverseX는 10배씩 커진다고 보면 된다.
        long reverseX = 0;
        while( x != 0 ){
            int mod = x % 10;
            x = x / 10;
            reverseX = ( reverseX * 10 ) + mod;
        }

        // 자바의 경우 integer는 32비트 고정이라 이런 식이 필요 없지만,
        // Integer.MAX_VALUE, Integer.MIN_VALUE가 64비트값이라면 이런식으로 처리해주면 된다.
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
