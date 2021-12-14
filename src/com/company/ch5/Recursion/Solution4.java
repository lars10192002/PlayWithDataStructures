package com.company.ch5.Recursion;

class Solution4 {

    public ListNode removeElements(ListNode head, int val) {

        if(head == null)//鏈表為空，就回傳空
            return null;

        ListNode res = removeElements(head.next, val);//removeElements = 對頭節點後面接的鏈表，將此鏈表內值為val給刪除
        // 刪除後的結果給一個新的變量"res" = 對頭節點後面接的鏈表，將此鏈表內值為val給刪除後剩下的鏈表。
        if (head.val == val) // 當head節點 == 要被刪除的條件(val)
            return res; // 直接回傳"res"
        else{
            head.next = res; // head 不要刪除，直接指向刪除後剩下的鏈表"res"
            return head; //回傳 head
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution4()).removeElements(head, 6);
        System.out.println(res);
    }
}