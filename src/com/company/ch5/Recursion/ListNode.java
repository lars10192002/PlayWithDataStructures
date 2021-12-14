package com.company.ch5.Recursion;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }
    // 鏈表節點的構造函數
    // 使用array作為參數，創建一個鏈表，當前創建的ListNode為頭節點
    public ListNode(int[] arr){
        if(arr == null || arr.length == 0)
            throw new IllegalArgumentException("arr can not be empty");
        this.val = arr[0] ;
        ListNode cur = this;
        for (int i = 0; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    //以當前節點為頭節點的鏈表信息字符串
    @Override
    public String toString(){

        StringBuilder s = new StringBuilder();
        ListNode cur = this;
        while(cur != null){
            s.append(cur.val + "->");
            cur = cur.next;
        }
        s.append("NULL");
        return s.toString();
    }


}
