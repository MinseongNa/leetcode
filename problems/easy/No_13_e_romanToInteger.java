package problems.easy;

import xyz.msna.mdmaker.annotation.ExecuteResult;

/**
 * 13. Roman to Integer
 *
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, two is written as II in Roman numeral, just two one's added together.
 * Twelve is written as, XII, which is simply X + II.
 * The number twenty seven is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII.
 * Instead, the number four is written as IV.
 * Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX.
 * There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 *
 * Example 1:
 *
 * Input: "III"
 * Output: 3
 *
 *
 * Example 2:
 *
 * Input: "IV"
 * Output: 4
 *
 *
 * Example 3:
 *
 * Input: "IX"
 * Output: 9
 *
 *
 * Example 4:
 *
 * Input: "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 *
 *
 * Example 5:
 *
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */

@ExecuteResult( runtimeMs = 38, memoryMb = 39)
public class No_13_e_romanToInteger {
    public static int romanToInt(String s) {
        int len = s.length();
        s += " ";
        int result = 0;
        for (int i = 0; i < len; i++) {
            char ch   = s.charAt(i);
            char next_char = s.charAt(i+1);

            if (ch == 'M') {
                result += 1000;
            } else if (ch == 'C') {
                if (next_char == 'M') {
                    result += 900;
                    i++;
                } else if (next_char == 'D') {
                    result += 400;
                    i++;
                } else {
                    result += 100;
                }
            } else if (ch == 'D') {
                result += 500;
            } else if (ch == 'X') {
                if (next_char == 'C') {
                    result += 90;
                    i++;
                } else if (next_char == 'L') {
                    result += 40;
                    i++;
                } else {
                    result += 10;
                }
            } else if (ch == 'L') {
                result += 50;
            } else if (ch == 'I') {
                if (next_char == 'X') {
                    result += 9;
                    i++;
                } else if (next_char == 'V') {
                    result += 4;
                    i++;
                } else {
                    result++;
                }
            } else { // if (ch == 'V')
                result += 5;
            }
        }
        return result;
    }

    public static void main(String[] args){
        String[] testDataArr = { "III", "IV", "IX", "LVIII" };
        for( String testData : testDataArr ){
            System.out.println( "Input: " + testData );
            System.out.println( "Output: " + romanToInt( testData ) );
        }

    }
}
