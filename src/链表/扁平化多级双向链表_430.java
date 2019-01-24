package 链表;

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {
    }

    public Node(int _val, Node _prev, Node _next, Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
}

@SuppressWarnings("ALL")
public class 扁平化多级双向链表_430 {
    public Node flatten(Node head) {
        Node newHead = new Node();
        newHead.next = head;
        construct(head);
        return newHead.next;
    }

    private Node construct(Node node) {
        if (node == null) {
            return null;
        }
        Node nodeNext = node.next;
        node.next = construct(node.child);
        if (node.next != null) {
            node.next.prev = node;
        }
        node.child = null;
        Node p = node;
        while (p.next != null) {
            p = p.next;
        }
        p.next = construct(nodeNext);
        if (p.next != null) {
            p.next.prev = p;
        }
        return node;
    }
}
