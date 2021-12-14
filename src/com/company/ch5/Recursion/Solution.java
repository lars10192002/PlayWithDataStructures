package com.company.ch5.Recursion;

class Solution {

    public ListNode removeElements(ListNode head, int val) {

        while(head != null && head.val == val){
            //刪除頭節點
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        if(head == null)
            return head;

        ListNode prev = head;
        //刪除中間的節點，條件是 prev.next != null
        while(prev.next != null){
            if(prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            }
            else//刪除prevNode
                prev = prev.next;
        }

        return head;
    }

}
