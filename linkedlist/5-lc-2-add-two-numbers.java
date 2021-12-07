class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry =0;
        while(p1!=null && p2!=null){
            int val = carry + p1.val + p2.val ;
            ListNode node = new ListNode(val%10);
            curr.next = node;
            carry = val/10;
            curr = curr.next;
            p1=p1.next;
            p2=p2.next;
        }
        while(p1!=null){
            int val = carry + p1.val;
            curr.next = new ListNode(val%10);
            carry = val/10;
            curr = curr.next;
            p1=p1.next;
        }
        while(p2!=null){
            int val = carry + p2.val;
            curr.next = new ListNode(val%10);
            carry = val/10;
            curr = curr.next;
            p2=p2.next;
        }
        if(carry!=0){
            curr.next = new ListNode(carry);
        }
        
        return dummy.next;
    }
}
