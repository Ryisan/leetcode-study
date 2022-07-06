package com.ryisan.algorithm.easy;

/**
 * @author ruansm
 * @date 2022/6/2
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * 示例：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 思路：
 * 1）创建哑结点 dummyHead，令 dummyHead.next = head。
 * 令 temp 表示当前到达的节点，初始时 temp = dummyHead。
 * 每次需要交换 temp 后面的两个节点。
 *
 */
public class SwapPairs024 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode listNode1 = swapPairs(listNode);
        System.out.println(listNode1);
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode temp = dummy;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }

        return dummy.next;
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
