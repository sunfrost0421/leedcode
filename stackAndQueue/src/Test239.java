import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Test239 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        MyQueue q = new MyQueue();
        int[] res = new int[nums.length - k + 1];
        //������ʼ״̬
        for(int i = 0; i < k; i++){
            q.add(nums[i]);
        }
        int j = 0;
        //�������ڣ���¼��ͷ���ȳ�Ԫ�أ�����Ԫ��
        for(int i = k; i < nums.length; i++){
            res[j] = q.element();
            q.remove(nums[i - k]);
            q.add(nums[i]);
            j++;
        }
        res[j] = q.element();
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,1,2,0,5};
        int[] res = maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(res));
    }
}

//����һ����������
class MyQueue {
    private Deque<Integer> q = new LinkedList<>();
    //���,���ֶ��еĵ����ݼ���,ɾ�����������б���Ԫ��С��Ԫ��
    public void add(int numIn) {
        while(!q.isEmpty() && q.getLast() < numIn){
            q.removeLast();
        }
        q.add(numIn);
    }
    //���ӣ�����һ���ο�Ԫ�أ��жϳ��ӵĲο�Ԫ���Ƿ�Ϊ�������еĶ�ͷ
    public void remove(int numOut) {
        if(numOut == q.element()){
            q.remove();
        }
    }
    //���ض�ͷԪ��
    public int element(){
        return q.element();
    }
}
