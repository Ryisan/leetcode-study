package com.ryisan.algorithm.easy;

/**
 * @author ruansm
 * @date 2022/6/2
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class MergeTwoLists021 {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        listNode2.next = new ListNode(4);
        System.out.println(mergeTwoLists(listNode1, listNode2));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergeList = new ListNode(0);
        ListNode e = mergeList;
        while (list1 != null && list2 != null) {
            int val1 = list1.val;
            int val2 = list2.val;
            if (val1 <= val2) {
                mergeList.next = new ListNode(val1);
                list1 = list1.next;
            } else {
                mergeList.next = new ListNode(val2);
                list2 = list2.next;
            }
            mergeList = mergeList.next;
        }
        if (list1 == null) {
            mergeList.next = list2;
        } else {
            mergeList.next = list1;
        }
        return e.next;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
