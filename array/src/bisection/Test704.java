package bisection;
/*自己书写的二分法，左闭右开*/
class Solution1 {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;//左闭右开
        while(true){
            int middle = (right + left)/2;
            if(target >= nums[middle]){
                if(target == nums[middle])
                    return middle;
                else {
                    left = middle;
                    if(right - left == 1)
                        return -1;
                }
            }
            else {
                right = middle;
                if(right == left)
                    return -1;
            }
        }
    }
}
/*优化后的二分法，左闭右开*/
class Solution2 {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int middle = 0;
        while(left < right){
            middle = (left + right)/2;
            if(target > nums[middle])
                left = middle + 1;
            else if(target < nums[middle])
                right = middle;
            else if(target == nums[middle])
                return middle;
        }
        return -1;
    }
}
/*优化后的二分法，左闭右闭*/
class Solution3 {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int middle = 0;
        while(left <= right){
            middle = (left + right + 1)/2;
            if(target > nums[middle])
                left = middle + 1;
            else if(target < nums[middle])
                right = middle - 1;
            else if(target == nums[middle])
                return middle;
        }
        return -1;
    }
}
public class Test704 {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        int res = Solution3.search(nums, target);
        System.out.println(res);
    }
}
