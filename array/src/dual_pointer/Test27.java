package dual_pointer;


/*
 * 使用另一个数组存储新元素
 * */
class Solution {
    public static int removeElement(int[] nums, int val) {
        int[] res = new int[nums.length];
        int i, j = 0;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                res[j] = nums[i];
                j++;
            }
        }
        for (i = 0; i < nums.length; i++) {
            nums[i] = res[i];
        }
        return j;
    }
}

/*
 * 不使用新的存储空间暴力求解,每次找到目标元素就移到最后面
 * */
class Solution1 {
    public static int removeElement(int[] nums, int val) {
        int new_length = nums.length;
        for (int i = 0; i < new_length; i++) {
            if (nums[i] == val) {
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[nums.length - 1] = val;
                new_length--;
                i--;
            }
        }
        return new_length;
    }
}

/*
 * 不使用新的存储空间,使用双指针法
 * */
class Solution2 {
    public static int removeElement(int[] nums, int val) {
        int slow_pointer = 0;
        int fast_pointer = 0;
        for (fast_pointer = 0; fast_pointer < nums.length; fast_pointer++) {
            if (nums[fast_pointer] != val) {
                nums[slow_pointer] = nums[fast_pointer];
                slow_pointer++;
                //以上两句也可以写为：nums[slow_pointer++] = nums[fast_pointer];
            }
        }
        return slow_pointer;
    }
}


public class Test27 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        int new_length = Solution2.removeElement(nums, val);
        for (int i = 0; i < new_length; i++) {
            System.out.print(nums[i] + ", ");
        }

    }
}
