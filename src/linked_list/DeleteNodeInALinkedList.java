package linked_list;

import common.ListNode;

/* 面试题18（一）：在O(1)时间删除链表结点
题目：给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该结点。
 */

public class DeleteNodeInALinkedList {
    public ListNode deleteNode(ListNode head, ListNode node) {
        if (head == null || node == null) {
            return null;
        }
        if (node.next != null) {
            // 要删除的结点不是尾结点
            node.val = node.next.val;
            node.next = node.next.next;
        } else if (head == node) {
            // 链表只有一个结点，删除头结点（也是尾结点）
            return null;
        } else {
            // 链表中有多个结点，删除尾结点
            ListNode cur = head;
            while(cur.next != node) {
                cur = cur.next;
            }
            cur.next = null;
        }
        return head;
    }
}
