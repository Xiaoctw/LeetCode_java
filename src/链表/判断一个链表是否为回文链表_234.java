package 链表;

import org.junit.Test;

import java.util.Stack;

@SuppressWarnings("ALL")
public class 判断一个链表是否为回文链表_234 {
    public boolean isPalindrome(ListNode head) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode p = newHead;
        int len = 0;
        while (p.next != null) {
            p = p.next;
            len++;
        }
        p = head;
        Stack<Integer> stack = new Stack<>();
        if (len % 2 == 0) {
            for (int i = 0; i < len / 2; i++) {
                stack.push(p.val);
                p = p.next;
            }
            for (int i = len / 2; i < len; i++) {
                int val = stack.pop();
                if (val != p.val) {
                    return false;
                }
                p = p.next;
            }
        } else {
            for (int i = 0; i < len / 2; i++) {
                stack.push(p.val);
                p = p.next;
            }
            p = p.next;
            for (int i = len / 2 + 1; i < len; i++) {
                int val = stack.pop();
                if (val != p.val) {
                    return false;
                }
                p = p.next;
            }
        }
        return true;
    }

    /**
     * 这个使用快慢指针，快指针走两步，慢指针走一步，慢指针入栈，这样就可以一次遍历得到
     * 也可以将后半部分翻转链表，这样可以达到o(1)复杂度
     *
     * @param head
     * @return
     */
    public boolean isPalindrome1(ListNode head) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode slow = newHead, fast = newHead;
        Stack<Integer> stack = new Stack<>();
        while (fast != null) {
            stack.push(slow.val);
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
                if (fast == null) {
                    slow = slow.next;
                }
            } else {
                fast = fast.next;
            }
        }
        while (slow != null) {
            int val = stack.pop();
            if (val != slow.val) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    @Test
    public void test() {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        // ListNode node2=new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        node.next = node1;
        // node1.next=node2;
        //  node2.next=node3;
        node1.next = node3;
        node3.next = node4;
        System.out.println(isPalindrome1(node));
    }
}
