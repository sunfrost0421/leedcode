package linknode;


public class LinkNode {
    int val;
    LinkNode next;
    public LinkNode(){};
    public LinkNode(int val){
        this.val = val;
    }
    public LinkNode(int val, LinkNode next){
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public LinkNode getNext() {
        return next;
    }

    public void setNext(LinkNode next) {
        this.next = next;
    }
}
class LinkTest{
    //不含虚拟头节点的链表
    public static LinkNode creatHeadLinkByArray(int[] vals){
        LinkNode head = new LinkNode();
        LinkNode now = head;
        for(int i = 0; i < vals.length; i++){
            now.next = new LinkNode(vals[i]);
            now = now.next;
        }
        return head.next;
    }
    public static void printAll(LinkNode head){
        if(head == null){
            System.out.println("null");
        }
        while(head != null){
            System.out.print(head.val+"->");
            head = head.next;
        }
        System.out.println("");
    }
    public static LinkNode removeElements(LinkNode head, int val){
        if(head==null)
            return null;
        head.next=removeElements(head.next,val);
        if(head.val==val){
            return head.next;
        }else{
            return head;
        }
    }
    //翻转链表
    public static LinkNode reverseList(LinkNode head){
        if(head == null){
            return null;
        }
        LinkNode cur = head.next;
        LinkNode pre = head;
        LinkNode temp;
        int count = 0;
        int i = 0;
        while(cur != null){
            temp = cur.next;
            cur.next = pre;
            i = count;
            while(i != 0){
                pre = pre.next;
                i--;
            }
            pre.next = temp;
            pre = cur;
            cur = temp;
            count++;
        }
        return pre;
    }
    public static void main(String[] args) {
        int[] vals = {1,2,3,4,5};
        LinkNode head = creatHeadLinkByArray(vals);
        printAll(head);
        LinkNode rlist = reverseList(head);
        printAll(rlist);
    }
}



