package problems.easy;

import xyz.msna.mdmaker.annotation.ExecuteResult;

import java.util.TreeMap;

/**
 * 69. Sqrt(x)
 *
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 *
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 *
 *
 * Example 1:
 *
 * Input: 4
 * Output: 2
 *
 *
 * Example 2:
 *
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 *              the decimal part is truncated, 2 is returned.
 */
public class No_69_e_sqrtx {

    public static TreeMap<Long, Long> squareMap = new TreeMap<>();
    static {
        for( long i = 1; i < Integer.MAX_VALUE; i++ ){
            squareMap.put( i * i, i );
        }
    }

    public static int mySqrt( int x ){

    }

    @ExecuteResult( runtimeMs = 35, memoryMb = 38.1f )
    public static int mySqrt3( int x ){
        if( x <= 1 ){
            return x;
        }
        for( long i = 1 ; i < Integer.MAX_VALUE; i++){
            if( ( ( i + 1 ) * ( i + 1 ) ) > x ){
                return (int)i;
            }
        }
        return -1;
    }

    @ExecuteResult( runtimeMs = 13, memoryMb = 38 )
    public static int mySqrt2(int x) {
        int l = 1;
        int r = x;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if(m == x / m) return m;
            if(m > x / m) r = m - 1;
            else l = m + 1;
        }
        return r;
    }

    public static void main(String[] args) {

        int[] testArr = { 4, 8, 2147395600 };
        for( int test : testArr ){
            System.out.println( "Input: " + test );
            System.out.println( "Output: " + mySqrt( test ) );
        }
    }
}
