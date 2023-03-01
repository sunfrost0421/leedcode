import java.util.*;

public class Test347 {
    public static void main(String[] args) {
        int k = 3;
        int[] res = new int[k];
        int[] nums = {1,1,1,2,2,3,3,3,3,4,4,5,5,6,7,7,8,8,9};
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : nums){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        System.out.println(map);

        //map转化为视图
        Set<Map.Entry<Integer, Integer>> set =  map.entrySet();

        //创建一个优先级队列，在优先级队列中，越小的元素优先级越高
        Queue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();//如果o2.value>o1.value，则返回正值，说明第一个参数大于第二个参数，也就是o1>o2
                //说明o.value越大，o的值越小，o的优先级越高。所以o.value的最大值将置于堆顶,所以改优先级队列为大顶堆
            }
        });

        //将n个视图元素存入优先级队列，时间复杂度O(nlog n)
        for(Map.Entry<Integer, Integer> m : set){
            q.add(m);
        }
        //将k个元素弹出，时间复杂度O(log k)
        for(int i = 0; i < k; i++){
            res[i] = q.remove().getKey();
        }
        System.out.println(Arrays.toString(res));
    }
}
