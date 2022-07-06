package com.ryisan.algorithm.medium;

/**
 * @author ruansm
 * @date 2022/6/1
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 实例：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 思路：
 * 1）在对链表进行操作时，一种常用的技巧是添加一个哑节点（dummy node），它的next 指针指向链表的头节点。
 * 这样一来，我们就不需要对头节点进行特殊的判断了。
 *2）使用双指针，使用两个指针 first和second，first遍历n个节点，second与first相差 n-1 个节点
 */
public class RemoveNthFromEnd019 {

    public static ListNode removeNthFromEnd(ListNode head, int n){
        ListNode dummy = new ListNode(0,head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first!=null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
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
    }
}