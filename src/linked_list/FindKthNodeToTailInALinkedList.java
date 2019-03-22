package linked_list;

import common.ListNode;

/* 面试题22：链表中倒数第k个结点
题目：输入一个链表，输出该链表中倒数第k个结点。为了符合大多数人的习惯，
本题从1开始计数，即链表的尾结点是倒数第1个结点。例如一个链表有6个结点，
从头结点开始它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个结点是
值为4的结点。
 */

public class FindKthNodeToTailInALinkedList {
    ListNode FindKthToTail(ListNode head, int k) {
        // 如果输入的链表头结点为空或者k <= 0，返回null
        if (head == null || k <= 0) {
            return null;
        }
        ListNode fast = head, slow = head;
        // 快指针先走k - 1步
        for (int i = 0; i < k - 1; ++ i){
            if (fast.next != null) {
                fast = fast.next;
            } else {
                // 如果输入的链表结点数小于k，返回null
                return null;
            }
        }
        // 快指针到达尾结点时，慢指针到达倒数第k个结点
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
