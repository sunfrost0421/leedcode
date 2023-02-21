import java.util.Arrays;

public class Test16 {
    public static void main(String[] args) {
        int[] a = {-1, 2, 1, -4};
        Solution1.threeSumClosest(a,1);
    }
}

class Solution1 {
    public static int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3){
            return 0;
        }
        Arrays.sort(nums, 0, nums.length);
        int left = 0;
        int right = 0;
        int sum = 0;
        int sub = 0;
        int min = 1000000;
        for(int i = 0; i < nums.length; i++){
            left = i + 1;
            right = nums.length - 1;
            while(left < right){
                sum = nums[i] + nums[left] + nums[right];
                if(sum < target){
                    sub = target - sum;
                    left++;
                }else if(sum > target){
                    sub = sum - target;
                    right--;
                }else if(sum == target){
                    return sum;
                }
                if(sub < min){
                    min = sub;
                }
            }
        }
        System.out.println(min);
        return min;
    }
}