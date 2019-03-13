package problems.easy;

import xyz.msna.mdmaker.annotation.ExecuteResult;

import java.util.*;

/**
 * 67. Add Binary
 *
 * Given two binary strings, return their sum (also a binary string).
 *
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 *
 *
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
public class No_67_e_addBinary {

    // 큰 String의 길이만큼 int배열을 만들어두고 뒷쪽부터 채워넣었다.
    @ExecuteResult(runtimeMs =  2, memoryMb =  34.6f)
    public static String addBinaryUseReverseIndex(String a, String b) {
        int maxLength = a.length() > b.length() ? a.length() : b.length();
        int[] resultArr = new int[ maxLength ];
        int carryOver = 0;
        for( int i = 1; i <= maxLength; i++ ){
            int intA = getIntByReverseIndex( a, i );
            int intB = getIntByReverseIndex( b, i );
            int result = carryOver + intA + intB;
            resultArr[ maxLength - i ] = result % 2;
            carryOver = result / 2;
        }
        StringBuilder sb = new StringBuilder();
        // 최종 캐리오버가 발생했으면 그 값을 가장 앞에 둔다.
        if( carryOver > 0 ){
            sb.append( carryOver );
        }
        for( int result : resultArr ){
            sb.append( result );
        }
        return sb.toString();
    }

    private static int getIntByReverseIndex( String numberString, int reverseIndex ) {
        if( numberString.length() < reverseIndex ){
            return 0;
        }
        int index = numberString.length() - reverseIndex;
        return Integer.parseInt( numberString.substring( index, index + 1 ) );
    }

    // 자릿수가 충분히 작다면(Long의 binary처리 범위)라면 이 코드도 동작한다.
    public static String addBinaryUseToBinaryString( String a, String b ){
        return Long.toBinaryString(Long.parseLong( a, 2 ) + Long.parseLong( b, 2 ) );
    }

    // 이 코드는 다른 사람이 푼 내용이다.
    @ExecuteResult( runtimeMs = 1, memoryMb = 34.7f)
    public static String addBinary(String a, String b) {
        int lenA = a.length()-1;
        int lenB = b.length()-1;

        StringBuilder res = new StringBuilder();
        int carryOver=0;
        // a와 b의 가장 낮은 자릿수부터 더하여 res에 append한다.
        // a와 b중 하나라도 남은 자릿수가 있으면 loop를 돈다.
        while( lenA >= 0 || lenB >= 0 ){
            int count = carryOver;
            // ch타입에서 '0'을 빼서 int값으로 처리한다.
            count += ( lenA >= 0 ) ? a.charAt( lenA ) - '0' : 0;
            count += ( lenB >= 0 ) ? b.charAt( lenB ) - '0' : 0;

            carryOver = count / 2;
            count = count % 2;
            res.append( count );

            lenA--;
            lenB--;
        }

        if( carryOver == 1 ){
            res.append( carryOver );
        }

        // res는 가장 낮은 자리부터의 값이므로 reverse해서 return한다.
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println( Long.toBinaryString( Long.MAX_VALUE ).length() );

        List<Map<String,String>> testList = new ArrayList<>();
        Map<String,String> test = new HashMap<>();
        test.put( "a", "11" );
        test.put( "b", "1" );
        testList.add( test );

        test = new HashMap<>();
        test.put( "a", "1010" );
        test.put( "b", "1011" );
        testList.add( test );

        test = new HashMap<>();
        test.put( "a",     "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101" );
        test.put( "b", "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011" );

        testList.add( test );

        for( Map<String,String> map : testList ){
            String a = map.get( "a" );
            String b = map.get( "b" );
            System.out.println( "Input: a = \"" + a + "\", b = \"" + b + "\"" );
            System.out.println( "Output: \"" + addBinaryUseToBinaryString( a, b ) + "\"" );
        }
    }
}
