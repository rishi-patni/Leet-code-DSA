class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode head = new ListNode(0);
        ListNode current = head;
        int carry = 0;
        
        while (l1 != null || l2 != null) {
            int x = 0;
            int y = 0;
            
            if (l1 != null) {
                x = l1.val;
                l1 = l1.next;
            }
            
            if (l2 != null) {
                y = l2.val;
                l2 = l2.next;
            }
            
            int sum = x + y + carry;
            carry = sum / 10;
            
            current.next = new ListNode(sum % 10);
            current = current.next;
        }
        
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        
        return head.next;
    }
}