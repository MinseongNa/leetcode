package problems.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 21. Merge Two Sorted Lists
 *
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class No_21_e_mergeTwoSortedLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if( l1 == null && l2 == null ){
            return null;
        }
        ListNode resultNode = new ListNode( -1 );
        ListNode lastNode = resultNode;
        while( l1 != null || l2 != null ){
            if( l1 == null ){
                lastNode.next = l2;
                break;
            }
            if( l2 == null ){
                lastNode.next = l1;
                break;
            }
            if( l1.val <= l2.val ){
                lastNode.next = new ListNode( l1.val );
                lastNode = lastNode.next;
                l1 = l1.next;
            }else if( l2.val < l1.val ){
                lastNode.next = new ListNode( l2.val );
                lastNode = lastNode.next;
                l2 = l2.next;
            }
        }
        return resultNode.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        public List<Integer> getValueListUntilLast(){
            List<Integer> result = new ArrayList<>();
            ListNode curr = this;
            do{
                result.add( curr.val );
                curr = curr.next;
            } while( curr != null );
            return result;
        }
        public String getJoiningStringUntilLast(){
            return getValueListUntilLast().stream()
                    .map( x -> String.valueOf( x ) )
                    .collect(Collectors.joining( "->" ) );
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode( 1 );
        node1.next = new ListNode( 2 );
        node1.next.next = new ListNode( 4 );

        ListNode node2 = new ListNode( 1 );
        node2.next = new ListNode( 3 );
        node2.next.next = new ListNode( 4 );

        System.out.println( "Input: "
                + String.join( ", ", node1.getJoiningStringUntilLast(), node2.getJoiningStringUntilLast() ) );

        ListNode sortedNode = mergeTwoLists( node1, node2 );
        System.out.println( "Output: " + sortedNode.getJoiningStringUntilLast() );
    }
}
