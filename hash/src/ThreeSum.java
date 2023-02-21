import java.util.*;


public class ThreeSum {
    /*
    方法一：哈希表
     */
    public static List<List<Integer>> threeSum1(int[] nums){
        ArrayList<List<Integer>> res = new ArrayList<>();
        int temp = 0;
        Set<Integer> record1 = new HashSet<>();
        Set<Integer> record2 = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            //提出一个数，先找到包含这个数的所有解
            if(record1.contains(nums[i])){
                continue;
            }
            record2.addAll(record1);
            for(int j = i + 1; j < nums.length; j++){
                temp = - nums[i] - nums[j];
                if(record2.contains(nums[j])){
                    continue;
                }else{
                    if(set.contains(temp)){
                        res.add(new ArrayList<>(Arrays.asList(
                                nums[i], nums[j], temp
                        )));
                        record2.add(nums[j]);
                        record2.add(temp);
                    }
                }
                set.add(nums[j]);
            }
            set.clear();
            record2.clear();
            record1.add(nums[i]);
        }
        return res;
    }

}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums, 0, nums.length);
        ArrayList<List<Integer>> res = new ArrayList<>();
        int left = 0;
        int right = 0;
        if(nums == null||nums.length < 3){
            return null;
        }
        for(int i = 0; i < nums.length; i++){
            left = i + 1;
            right = nums.length - 1;
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            while(left < right){
                if(nums[left] + nums[right] + nums[i] == 0){
                    res.add(new ArrayList<Integer>(Arrays.asList(
                            nums[i], nums[right], nums[left]
                    )));
                    while(left < right && nums[left] == nums[left + 1]){
                        left++;
                    }
                    while(left < right && nums[right] == nums[right - 1]){
                        right--;
                    }
                    left++;
                    right--;
                }
                else if(nums[left] + nums[right] + nums[i] < 0){
                    left++;
                }
                else if(nums[left] + nums[right] + nums[i] > 0){
                    right--;
                }
            }
        }
        return res;
    }
}
