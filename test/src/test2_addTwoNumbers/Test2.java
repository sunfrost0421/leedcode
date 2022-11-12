package test2_addTwoNumbers;



class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

}

class Solution{
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        int up = 0;
        int sum = 0;
        int v1=0,v2=0;
        ListNode l = new ListNode();
        ListNode now = l;
        do{
            if(l1==null&&l2==null&&up==0)
                break;
            if(l1==null) v1 = 0;
            else v1 = l1.val;
            if(l2==null) v2 = 0;
            else v2 = l2.val;
            sum = v1+v2+up;
            up = 0;
            if(sum>=10)
            {
                up=1;
                sum-=10;
            }
            now.next = new ListNode(sum);
            now = now.next;
            sum = 0;
            if(l1!=null) l1 = l1.next;
            if(l2!=null) l2 = l2.next;
        }
        while(true);
        return l.next;
    }
    public static void printAll(ListNode l){
        while (l!=null){
            System.out.println(l.val);
            l = l.next;
        }
    }
}

public class Test2 {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(3);
        a1.next = a2;
        a2.next = a3;
        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(7);
        ListNode b4 = new ListNode(2);
        b1.next = b2;
        b2.next = b3;
        b3.next = b4;
        ListNode c = Solution.addTwoNumbers(a1,b1);
        Solution.printAll(c);
    }
}
