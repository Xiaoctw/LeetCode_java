package 链表;

@SuppressWarnings("ALL")
public class 旋转链表_61 {
    /**
     * 每个节点向右移动k个位置
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) {
            return head;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode p3 = newHead;
        int count = 0;
        int length = 0;
        //这里可能会很耗时，当k很大时需要循环很多遍
        while (p3.next != null) {
            length++;
            p3 = p3.next;
        }
        count %= length;
        p3 = newHead;
        while (count < k) {
            count++;
            if (p3.next == null) {
                p3 = newHead.next;
            } else {
                p3 = p3.next;
            }
        }
        if (p3.next == null) {
            return head;
        }
        ListNode p1 = newHead, p2 = head;
        while (p3.next != null) {//向后遍历
            p3 = p3.next;
            p2 = p2.next;
            p1 = p1.next;
        }
        p1.next = null;
        p3.next = newHead.next;
        newHead.next = p2;
        return newHead.next;
    }

}
