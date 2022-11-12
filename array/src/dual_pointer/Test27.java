package dual_pointer;


/*
 * ʹ����һ������洢��Ԫ��
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
 * ��ʹ���µĴ洢�ռ䱩�����,ÿ���ҵ�Ŀ��Ԫ�ؾ��Ƶ������
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
 * ��ʹ���µĴ洢�ռ�,ʹ��˫ָ�뷨
 * */
class Solution2 {
    public static int removeElement(int[] nums, int val) {
        int slow_pointer = 0;
        int fast_pointer = 0;
        for (fast_pointer = 0; fast_pointer < nums.length; fast_pointer++) {
            if (nums[fast_pointer] != val) {
                nums[slow_pointer] = nums[fast_pointer];
                slow_pointer++;
                //��������Ҳ����дΪ��nums[slow_pointer++] = nums[fast_pointer];
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
