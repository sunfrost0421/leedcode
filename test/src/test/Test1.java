package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution1 {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int i = 0,j = 0;
        for(i=0;i<nums.length;i++)
        {
            for(j=i+1;j<nums.length;j++)
            {
                if(nums[i]+nums[j] == target)
                {
                    result[0]=i;
                    result[1]=j;
                }
            }
        }
        return result;
    }
}

class Solution2{
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] result = new int[2];
        for(int i = 0;i<nums.length;i++)
        {
            if(map.containsKey(target-nums[i])){
                result[0] = map.get(target-nums[i]);
                result[1] = i;
            }
            else
                map.put(nums[i],i);
        }
        return result;
    }
}

public class Test1
{
    public static void main(String[] args) {
        int[] aa = {3,3};
        int target = 6;
        System.out.println(Arrays.toString(Solution1.twoSum(aa,target)));
        int[] bb = {2,11,7,15,9};
        target = 9;
        Arrays.stream(Solution2.twoSum(bb,target)).forEach(System.out::println);
    }

}
