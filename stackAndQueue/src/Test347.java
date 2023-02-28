import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Test347 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3,3,3,3,4,4,5,5,6,7,7,8,8,9};
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : nums){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        System.out.println(map);

    }
}
