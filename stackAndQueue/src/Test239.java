import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Test239 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        MyQueue q = new MyQueue();
        int[] res = new int[nums.length - k + 1];
        //构建初始状态
        for(int i = 0; i < k; i++){
            q.add(nums[i]);
        }
        int j = 0;
        //滑动窗口，记录队头，先出元素，再入元素
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

//创建一个单调队列
class MyQueue {
    private Deque<Integer> q = new LinkedList<>();
    //入队,保持队列的单调递减性,删除队列中所有比新元素小的元素
    public void add(int numIn) {
        while(!q.isEmpty() && q.getLast() < numIn){
            q.removeLast();
        }
        q.add(numIn);
    }
    //出队，传入一个参考元素，判断出队的参考元素是否为单调队列的队头
    public void remove(int numOut) {
        if(numOut == q.element()){
            q.remove();
        }
    }
    //返回队头元素
    public int element(){
        return q.element();
    }
}
