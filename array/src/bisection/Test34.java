package bisection;

import java.util.Arrays;

class Solution {
    public static int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int[] res = {-1, -1};
        if(nums.length == 0)
            return res;
        if(nums[0] == target){
            res[0] = 0;
        }
        if(nums[nums.length - 1] == target){
            res[1] = nums.length - 1;
        }
        while(left < right){
            int middle = left + (right - left)/2;
            if(target > nums[middle]){
                left = middle + 1;
            }
            else if(target < nums[middle]){
                right = middle;
            }
            else{
                //����߽粻Ϊԭ���������ʱ������߽�
                //��ʱ��[0, middle)Ѱ����߽�
                int left_l = 0;
                int right_l = middle;
                int middle_l;
                while(res[0] == -1){
                    middle_l = left_l + (right_l - left_l)/2;
                    if(nums[middle_l] < target){
                        left_l = middle_l + 1;
                    }
                    else if(nums[middle_l] == target && nums[middle_l - 1] == target){
                        right_l = middle_l;
                    }
                    else{
                        res[0] = middle_l;
                        break;
                    }
                    if(left_l == right_l){
                        res[0] = middle;
                        break;
                    }
                }
                //���ұ߽粻Ϊԭ�������Ҷ�ʱ�����ұ߽�
                //��ʱ��[middle+1, nums.length)Ѱ���ұ߽�
                int left_r = middle + 1;
                int right_r = nums.length;
                int middle_r;
                while(res[1] == -1){
                    middle_r = left_r + (right_r - left_r)/2;
                    if(nums[middle_r] > target){
                        right_r = middle_r;
                    }
                    else if(nums[middle_r] == target && nums[middle_r + 1] == target){
                        left_r = middle_r + 1;
                    }
                    else if(nums[middle_r] == target && nums[middle_r + 1] != target){
                        res[1] = middle_r;
                        break;
                    }
                    if(left_r == right_r){
                        res[1] = middle;
                        break;
                    }
                }
                break;
            }
            if(left == right){
                break;
            }
        }
        return res;
    }
}

public class Test34 {
    public static void main(String[] args) {
        //������һ��û��Ԫ�ص��������
        int[] nums = {};
        int[] nums2 = new int[]{};
        System.out.println(nums.length == 0);
        //��������û�������κζ���
        int[] nums3 = null;
        System.out.println(nums3 == null);
//        int target = 0;
//        int[] res = Solution.searchRange(nums, target);
//        System.out.println(Arrays.toString(res));
    }
}
