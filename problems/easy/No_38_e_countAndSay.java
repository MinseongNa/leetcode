package problems.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 38. Count and Say
 *
 * he count-and-say sequence is the sequence of integers with the first five terms as following:
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 *
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 *
 * Note: Each term of the sequence of integers will be represented as a string.
 *
 *
 * Example 1:
 *
 * Input: 1
 * Output: "1"
 *
 *
 * Example 2:
 *
 * Input: 4
 * Output: "1211"
 */
public class No_38_e_countAndSay {
    public static String countAndSay(int n) {
        String result = "1";

        for( int nIdx = 2; nIdx <= n; nIdx++ ){
            int chLength = result.length();
            StringBuilder newResult = new StringBuilder();
            char prevCh = result.charAt(0);
            int prevChCnt = 0;
            for( int chIdx = 0; chIdx <= chLength - 1; chIdx++ ){
                char ch = result.charAt( chIdx );
                if( prevCh == ch ){
                    prevChCnt++;
                }else{
                    newResult.append(prevChCnt);
                    newResult.append(prevCh);
                    prevCh = ch;
                    prevChCnt = 1;
                }
                if( chIdx == ( chLength - 1 ) ){
                    newResult.append( prevChCnt );
                    newResult.append( prevCh );
                }
            }
            result = newResult.toString();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] testArr = { 1, 4 };
        for( int test : testArr ){
            System.out.println( "Input: " + test );
            System.out.println( "Output: \"" + countAndSay( test )  +"\"" + System.lineSeparator());
        }
    }
}
