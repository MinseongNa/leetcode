package problems;

import xyz.msna.mdmaker.annotation.ExecuteResult;

/**
 * 2. Add Two Numbers
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */

@ExecuteResult(runtimeMs = 0, memoryMb = 0f )
public class No_2_e_addTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode( 2);
        l1.next = new ListNode( 4 );
        l1.next.next = new ListNode( 3 );

        ListNode l2 = new ListNode( 5 );
        l2.next = new ListNode( 6 );
        l2.next.next = new ListNode( 4 );

        ListNode result = addTwoNumbers( l1, l2 );
        do{
            System.out.print( result.val );
            if( result.next != null ){
                System.out.print( " -> " );
            }
            result = result.next;
        }while( result != null );
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultHead = new ListNode(0 );
        ListNode currNode = resultHead;
        int carryOver = 0;
        while( l1 != null || l2 != null ){
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sum = carryOver + l1Val + l2Val;
            currNode.next = new ListNode( sum % 10 );
            carryOver = sum / 10;

            currNode = currNode.next;
            if( l1 != null ){
                l1 = l1.next;
            }
            if( l2 != null ){
                l2 = l2.next;
            }
        }
        if( carryOver > 0 ){
            currNode.next = new ListNode( carryOver );
        }
        return resultHead.next;
    }

    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode( int x ){ val = x; }
    }

}
