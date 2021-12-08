class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        while(n>0){
            second = second.next;
            n--;
        }
        while(second!=null && second.next!=null){
            second = second.next;
            first = first.next;
        }
        if(first!=null && first.next!=null){
            first.next = first.next.next;
        }
        return dummy.next;
    }
}
