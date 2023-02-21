package linknode;

public class Circle {
    public static LinkNode detectCycle(LinkNode head) {
        LinkNode fast = head;
        LinkNode slow = head;
        if(head == null||head.next == null){
            return null;
        }
        while(slow != fast && slow != head){
            if(fast.next == null||fast == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        LinkNode head = new LinkNode(0);
        LinkNode n1 = new LinkNode(1);
        LinkNode n2 = new LinkNode(2);
        LinkNode n3 = new LinkNode(3);
        LinkNode n4 = new LinkNode(4);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n1;
        LinkNode res = detectCycle(head);
        System.out.println(res.val);
    }
}
