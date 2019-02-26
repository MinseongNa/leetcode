package problems.easy;

/**
 * 28. Implement strStr()
 *
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 *
 *
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 *
 *
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 */
public class No_28_e_implementStrStr {

    public static int strStr(String haystack, String needle) {
        if( haystack == null || needle == null ){
            return -1;
        }
        if( haystack.length() < needle.length() ){
            return -1;
        }
        return haystack.indexOf( needle );
    }

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        System.out.println( "Input: haystack = \"" + haystack + "\", needle =\"" + needle + "\"");
        System.out.println( "Output: " + strStr( haystack, needle ) );

        haystack = "aaaaa";
        needle = "bba";
        System.out.println( "Input: haystack = \"" + haystack + "\", needle =\"" + needle + "\"");
        System.out.println( "Output: " + strStr( haystack, needle ) );
    }
}
