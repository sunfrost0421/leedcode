package linklist;

import linknode.LinkNode;
//使用虚拟头结点创建链表
public class LinkList {
    private LinkNode head;
    //创建一个空链表
    public LinkList(){
        head = new LinkNode(0);
    }
    //从头部添加一个节点
    public void addByValFromHead(int val){
        LinkNode node = new LinkNode(val);
        node.setNext(head.getNext());
        head.setNext(node);
    }
    //在第n个节点后添加一个节点
    public boolean addByValAt(int index, int val){
        LinkNode now = head;
        for(int i = 0; i < index; i++){
            now = now.getNext();
            if(now == null){
                return false;
            }
        }
        LinkNode node = new LinkNode(val);
        now.setNext(node);
        node.setNext(now.getNext());
        return true;
    }
    //遍历链表输出
    public int printLinkList(){
        int length = 0;
        LinkNode now = head;
        while(now.getNext() != null){
            length++;
            now = now.getNext();
            System.out.print(now.getVal()+"->");
        }
        System.out.println("\nlength : " + length);
        return length;
    }
    //通过值删除节点,返回删除后的头结点
    public LinkNode removeByVal(int val){
        LinkNode now = head;
        if(now.getNext() == null){
            return null;
        }
        while(now.getNext() != null){
            if(now.getNext().getVal() == val){
                now.setNext(now.getNext().getNext());
            }else{
                now = now.getNext();
            }
        }
        return head.getNext();
    }
    //通过数组创建一个链表
    public static LinkList creatLinkByArray(int[] vals){
        LinkList list = new LinkList();
        for(int i = vals.length - 1; i >= 0; i--){
            list.addByValFromHead(vals[i]);
        }
        return list;
    }
}

class LinkListTest{
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6};
        LinkList list = LinkList.creatLinkByArray(a);
        list.printLinkList();
        LinkNode n = list.removeByVal(1);
        list.printLinkList();
        System.out.println(n.getVal());
    }
}


