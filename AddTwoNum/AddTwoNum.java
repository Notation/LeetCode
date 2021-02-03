package AddTwoNum;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class AddTwoNum {
    public static void main(String[] args) {
        Solution sln = new Solution();
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        ListNode l2 = new ListNode(9);
        ListNode l3 = sln.addTwoNumbers(l1, l2);
        while(l3 != null) {
            System.out.print(l3.val);
            l3 = l3.next;
        }
        System.out.println();
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode currNode = null;
        int n = 0;
        while (l1 != null || l2 != null) {
            int n1 = 0;
            int n2 = 0;
            int sum = 0;
            if (l1 != null) {
                n1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                n2 = l2.val;
                l2 = l2.next;
            }
            sum = n1 + n2 + n;
            if (currNode == null ) {
                currNode = new ListNode(sum % 10);
            } else {
                currNode.next = new ListNode(sum % 10);
                currNode = currNode.next;
            }
            //System.out.printf("n1 %d n2 %d n %d sum %d %d\n", n1, n2, n, sum, currNode.next);
            n = sum  / 10;
            if (result == null) {
                result = currNode;
            }
        }
        if (n > 0) {
            currNode.next = new ListNode(n);
            currNode = currNode.next;
        }
        return result;
    }
}