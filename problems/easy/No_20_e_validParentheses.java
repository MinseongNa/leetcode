package problems.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. Valid Parentheses
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 *
 *
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 *
 *
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 *
 *
 * Example 4:
 *
 * Input: "([)]"
 * Output: false
 *
 *
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
 */

public class No_20_e_validParentheses {
    public static final Map<Character, Character> bracketMap = new HashMap();
    static{
        bracketMap.put( ')', '(' );
        bracketMap.put( '}', '{' );
        bracketMap.put( ']', '[' );
    }


    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for( char ch : s.toCharArray() ){
            if( isOpenBracket( ch ) ){
                stack.push( ch );
            }
            else if( isCloseBracket( ch ) ){
                if( stack.empty() ){
                    return false;
                }
                char openBracket = stack.pop();
                if( !bracketMap.get( ch ).equals( openBracket ) ){
                    return false;
                }
            }
            else {
                return false;
            }
        }
        return stack.empty();
    }

    private static boolean isOpenBracket(char ch) {
        return ch == '(' || ch == '{' || ch == '[';
    }
    private static boolean isCloseBracket(char ch) {
        return ch == ')' || ch == '}' || ch == ']';
    }


    public static void main(String[] args) {
        String[] testArr = new String[]{ "()", "()[]{}", "(]", "([)]", "{[]}" };
        for( String test : testArr ){
            System.out.println( test  );
            System.out.println( isValid( test ) + System.lineSeparator() );
        }
    }
}
