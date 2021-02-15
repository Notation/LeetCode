package RemoveNthFromEnd;

public class RemoveNthFromEnd {
    public static void main(String[] args) {
        Solution sln = new Solution();
        ListNode l = new ListNode(1);
        ListNode l0 = l;
        l0.next = new ListNode(2);
        l0 = l0.next;
        l0.next = new ListNode(3);
        l0 = l0.next;
        l0.next = new ListNode(4);
        l0 = l0.next;
        l0.next = new ListNode(5);
        for (ListNode n = l; n != null; n=n.next) {
            System.out.print(n.val);
        }
        System.out.println();
        l = sln.removeNthFromEnd(l, 1);
        if (l == null) {
            return;
        }
        for (ListNode n = l; n != null; n=n.next) {
            System.out.print(n.val);
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode fn = head;
        ListNode pre = null;
        int m = 0;
        int len = 0;
        while (fn != null) {
            len++;
            if (m >= n) {
                if (pre == null) {
                    pre = head;
                } else {
                    pre = pre.next;
                }
            } else {
                m++;
            }
            fn = fn.next;
        }
        if (len == n) {
            return head.next;
        }
        if (pre != null && pre.next != null) {
            pre.next = pre.next.next;
        }
        return head;
    }
}