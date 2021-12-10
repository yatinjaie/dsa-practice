class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next ==null){
            return head;
        }
        ListNode second = head.next;
        ListNode temp = swapPairs(second.next);
        head.next = temp;
        second.next = head;
        return second;
    }
}
