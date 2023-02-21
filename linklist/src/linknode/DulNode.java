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
* ˫��������ŵ㣺
* 1.�����ڵ�ǰ�ڵ�֮ǰ��֮�����
* 2.��ǰ�ڵ����ɾ������
* */
class DulList {
    DulNode head;//����ͷ
    DulNode tail;//���һ���ڵ�
    public DulList(){
        head = new DulNode();
    }
    //ͷ�壬���б�ʱʹ��ͷ�巨��Ҫ����β���
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
    //β�壬ע��ÿ��ʹ��β�巨ʱ����β���Ϊ���һ���ڵ�
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
    //��ѯ����ͷ�ڵ��ĵ�һ���ڵ㵽β�����ŷֱ�Ϊ0-Index������Ϊindex+1.����ͷ�ڵ㲻����
    public int get(int index){
        if(index < 0){
            return -1;
        }
        DulNode now = head;
        //ѭ��������now����index��ʾ�Ľڵ���
        for(int i = 0; i < index + 1; i++){
            now = now.next;
            if(now == null){
                return -1;
            }
        }
        return now.val;
    }
    //���룬ȷ��������ʱʹ��ͷ�巨������β���
    public boolean addAtIndex(int index, int val){
        if(index <= 0){
            addAtHead(val);
            return true;
        }
        DulNode now = head;
        //ѭ��������now����index��ʾ�Ľڵ���
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
    //ɾ��
    public boolean deleteAtIndex(int index){
        if(index < 0){
            return false;
        }
        DulNode now = head;
        //ѭ��������now����index��ʾ�Ľڵ���
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
    //ͨ�����鴴��˫������
    public static DulList creatByArray(int[] vals){
        DulList l = new DulList();
        for(int i = 0; i < vals.length; i++){
            l.addAtTail(vals[i]);
        }
        return l;
    }
    //�����������
    public void printForward(){
        DulNode now = head;
        while(now.next != null){
            now = now.next;
            System.out.print(now.val + "<->");
        }
        System.out.println("");
    }
    //�����������
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

