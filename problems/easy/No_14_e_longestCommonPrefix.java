package problems.easy;

import java.util.Arrays;

/**
 * 14. Longest Common Prefix
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 *
 *
 * Example 2:
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 *
 * Note:
 *
 * All given inputs are in lowercase letters a-z.
 */
public class No_14_e_longestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if( strs == null || strs.length == 0 ){
            return "";
        }
        if( strs.length == 1 ){
            return strs[0];
        }
        StringBuilder sb = new StringBuilder();
        int commonPrefixIdx = 0;
        for( ; commonPrefixIdx < strs[0].length(); commonPrefixIdx++ ){
            if( !isCommonChar( strs, commonPrefixIdx ) ){
                break;
            }
        }
        return strs[0].substring( 0, commonPrefixIdx );
    }

    private static boolean isCommonChar( String[] strs, int charIdx ) {
        char firstElChar = strs[0].charAt( charIdx );
        for( int strIdx = 1; strIdx < strs.length; strIdx++ ){
            try {
                if (strs[strIdx].charAt(charIdx) != firstElChar) {
                    return false;
                }
            } catch( StringIndexOutOfBoundsException siobE ){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[][] testArrArr = new String[][]{
                { "flower","flow","flight" }
                , { "dog", "racecar", "car" }
        };

        for( String[] testArr : testArrArr ){
            System.out.println(Arrays.toString( testArr ) );
            System.out.println( '"' + longestCommonPrefix( testArr ) + '"' );
        }

    }
}
