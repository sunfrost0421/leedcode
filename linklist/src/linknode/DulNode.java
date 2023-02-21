package linknode;

public class DulNode {
    int val;
    DulNode next;
    DulNode pre;
    public DulNode(){}
    public DulNode(int val){
        this.val = val;
    }
}
/*
* 双向链表的优点：
* 1.可以在当前节点之前和之后插入
* 2.当前节点可以删除自身
* */
class DulList {
    DulNode head;//虚拟头
    DulNode tail;//最后一个节点
    public DulList(){
        head = new DulNode();
    }
    //头插，空列表时使用头插法需要更新尾结点
    public void addAtHead(int val){
        DulNode newNode = new DulNode(val);
        if(head.next != null){
            head.next.pre = newNode;
        }else {
            tail = newNode;
        }
        newNode.pre = head;
        newNode.next = head.next;
        head.next = newNode;
    }
    //尾插，注意每次使用尾插法时更新尾结点为最后一个节点
    public void addAtTail(int val){
        DulNode newNode = new DulNode(val);
        if(tail == null){
            addAtHead(val);
        }else{
            newNode.pre = tail;
            newNode.next = null;
            tail.next = newNode;
            tail = newNode;
        }
    }
    //查询，从头节点后的第一个节点到尾结点序号分别为0-Index，长度为index+1.虚拟头节点不计入
    public int get(int index){
        if(index < 0){
            return -1;
        }
        DulNode now = head;
        //循环结束后，now落在index表示的节点上
        for(int i = 0; i < index + 1; i++){
            now = now.next;
            if(now == null){
                return -1;
            }
        }
        return now.val;
    }
    //插入，确保空链表时使用头插法来更新尾结点
    public boolean addAtIndex(int index, int val){
        if(index <= 0){
            addAtHead(val);
            return true;
        }
        DulNode now = head;
        //循环结束后，now落在index表示的节点上
        for(int i = 0; i < index + 1; i++){
            now = now.next;
            if(now == null){
                return false;
            }
        }
        DulNode newNode = new DulNode(val);
        newNode.pre = now.pre;
        newNode.next = now;
        now.pre.next = newNode;
        now.pre = newNode;
        return true;
    }
    //删除
    public boolean deleteAtIndex(int index){
        if(index < 0){
            return false;
        }
        DulNode now = head;
        //循环结束后，now落在index表示的节点上
        for(int i = 0; i < index + 1; i++){
            now = now.next;
            if(now == null){
                return false;
            }
        }
        now.pre.next = now.next;
        if(now != tail){
            now.next.pre = now.pre;
        }
        return true;
    }
    //通过数组创建双向链表
    public static DulList creatByArray(int[] vals){
        DulList l = new DulList();
        for(int i = 0; i < vals.length; i++){
            l.addAtTail(vals[i]);
        }
        return l;
    }
    //正向遍历链表
    public void printForward(){
        DulNode now = head;
        while(now.next != null){
            now = now.next;
            System.out.print(now.val + "<->");
        }
        System.out.println("");
    }
    //反向遍历链表
    public void printBackward(){
        DulNode now = tail;
        while(now != head){
            System.out.print(now.val + "<->");
            now = now.pre;
        }
        System.out.println("");
    }
}
class DulTest{
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        DulList list = DulList.creatByArray(a);
        list.printForward();
        System.out.println(list.get(5));
        list.addAtHead(99);
        list.addAtIndex(3, 65);
        list.printForward();
        list.deleteAtIndex(5);
        list.printForward();
    }
}

