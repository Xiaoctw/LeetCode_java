package 链表;

import java.util.HashMap;

@SuppressWarnings("ALL")
public class 复制带随机指针的链表_138 {
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode newHead = new RandomListNode(-1);
        RandomListNode pre = newHead;
        RandomListNode p = head;
        while (p != null) {
            pre.next = new RandomListNode(p.label);
            map.put(p, pre.next);
            pre = pre.next;
            p = p.next;
        }
        RandomListNode p1 = newHead.next, p2 = head;
        while (p2 != null) {
            p1.random = map.get(p2.random);
            p2 = p2.next;
            p1 = p1.next;
        }
        return newHead.next;
    }
}


class RandomListNode {
    int label;
    RandomListNode next, random;

    public RandomListNode(int x) {
        this.label = x;
    }
}
