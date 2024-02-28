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
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0 || lists==null) return null;

        return dnqLists(lists, 0, lists.length-1);
    }

    public ListNode dnqLists(ListNode[] lists, int s, int e){
        if (s==e) return lists[s];
        if (e-s==1) return mergeTwoLists(lists[s], lists[e]);

        int mid = s + (e-s)/2;
        ListNode left = dnqLists(lists, s, mid);
        ListNode right = dnqLists(lists, mid+1, e);

        return mergeTwoLists(left, right);
    }

    public ListNode mergeTwoLists (ListNode l, ListNode r){
        if (l==null) return r;
        if (r==null) return l;

        ListNode head = new ListNode(0);
        ListNode cur = head;

        while (l!=null && r!=null){
            ListNode temp = new ListNode(Math.min(l.val, r.val));
            if (r.val < l.val) r = r.next;
            else l = l.next;
            cur.next = temp;
            cur = temp;
        }

        if (l!=null) cur.next = l;
        else if (r!=null) cur.next = r;

        return head.next;
    }
}