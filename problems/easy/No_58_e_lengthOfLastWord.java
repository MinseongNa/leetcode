package problems.easy;

import xyz.msna.mdmaker.annotation.ExecuteResult;

/**
 * 58. Length of Last Word
 *
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 *
 * Example:
 *
 * Input: "Hello World"
 * Output: 5
 */
@ExecuteResult( runtimeMs = 2, memoryMb = 37.5f)
public class No_58_e_lengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        if( s == null ){
            return 0;
        }
        s = s.trim();
        return s.length() - ( s.lastIndexOf( ' ' ) + 1 );
    }

    public static void main(String[] args) {
        String test = "Hello World";
        System.out.println( "Input: " + test );
        System.out.println( "Output: " + lengthOfLastWord( test ) );
    }
}
