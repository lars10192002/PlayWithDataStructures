package com.company.ch5.Recursion;

class Solution4 {

    public ListNode removeElements(ListNode head, int val, int depth) {


        String depthString = generateDepthString(depth);

        System.out.println(depthString);
        System.out.println("Call: remove "+ val + " in "+ head);
        if(head == null){
            System.out.println(depthString);
            System.out.println("Return: "+ head);
            return null;
        }
        ListNode res = removeElements(head.next, val, depth+1);//removeElements = 對頭節點後面接的鏈表，將此鏈表內值為val給刪除
        System.out.print(depthString);
        System.out.println("After remove " + val + ": " + res);

        ListNode ret;
        // 刪除後的結果給一個新的變量"res" = 對頭節點後面接的鏈表，將此鏈表內值為val給刪除後剩下的鏈表。
        if (head.val == val) { // 當head節點 == 要被刪除的條件(val)
            ret = res;// 直接回傳"res"
        }else{
            head.next = res; // head 不要刪除，直接指向刪除後剩下的鏈表"res"
            ret = head;//回傳 head
        }
        System.out.print(depthString);
        System.out.println("Return: " + ret);
        return ret;
    }

    private String generateDepthString(int depth){

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }

        return res.toString();
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution4()).removeElements(head, 6,0);
        System.out.println(res);
    }
}