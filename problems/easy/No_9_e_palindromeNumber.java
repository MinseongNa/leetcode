package problems.easy;

/**
 * 9. Palindrome Number
 * Determine whether an integer is a palindrome.
 * An integer is a palindrome when it reads the same backward as forward.
 *
 * Example 1:
 *
 * Input: 121
 * Output: true
 *
 * Example 2:
 *
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-.
 * Therefore it is not a palindrome.
 *
 * Example 3:
 *
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 *
 * Follow up:
 *
 * Coud you solve it without converting the integer to a string?
 */
public class No_9_e_palindromeNumber {

    public static boolean isPalindromeWithStringConvert(int x) {

        // 음수는 부호 때문에 무조건 회문이 될 수 없다.
        if( x < 0 ){
            return false;
        }

        String xString = String.valueOf( x );

        // 숫자인 x를 문자로 변환해서 첫문자와 뒤에서 첫문자, 두번째 문자와 뒤에서 두번째 문자 순으로 비교한다.
        // 비교하다가 일치하지 않는 문자가 발생하면 회문이 아니므로 false를 리턴한다.
        // 앞에서부터 가는 문자가 중간까지 도달하면 이미 모든 문자를 비교한 것이다.
        // 앞에서부터 가는 문자가 마지막까지 가면 쓸데 없는 연산이 필요하니 주의.
        for(int i = 0; i < xString.length() / 2; i++ ){
            if( xString.charAt( i ) != xString.charAt( xString.length() - i - 1 ) ){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] testDataArr = { 121, -121, 10 };
        for( int testData : testDataArr ){
            System.out.println( "Input : " + testData );
            System.out.println( "Output : " + isPalindromeWithStringConvert( testData ) );
        }
    }
}
