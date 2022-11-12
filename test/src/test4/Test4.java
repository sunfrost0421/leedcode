package test4;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //1.将nums2添加到链表中，时间复杂度O(N)
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0;i<nums2.length;i++)
        {
            list.add(nums2[i]);
        }
        //2.将nums1的元素通过比较插入链表，时间复杂度？？？
        ListIterator<Integer> iter = list.listIterator();
        for(int i=0;i<nums1.length;i++)
        {
            while(iter.hasNext()){
                if(nums1[i]<iter.next())
                {
                    iter.previous();
                    iter.add(nums1[i]);
                    break;
                }
            }
            if(!iter.hasNext())
            {
                iter.add(nums1[i]);
            }
        }
//        iter = list.listIterator();
//        while(iter.hasNext())
//        {
//            System.out.print(iter.next()+" ");
//        }
//        System.out.println("");
        //3.求中位数，时间复杂度O((M+N)/2)
        iter = list.listIterator();
        int flag = (nums1.length+nums2.length)%2;
        int index = (nums1.length+nums2.length)/2;
        double result = 0;
        if(flag == 1){
            for(int i=0;i<index+1;i++){
                result = iter.next();
            }
        }
        if(flag == 0){
            for(int i=0;i<index;i++){
                result = iter.next();
            }
            result = (result+iter.next())/2.0;
        }
//        System.out.println("length="+(nums1.length+nums2.length)+"result="+result);
        return result;
    }
}

public class Test4
{
    public static void main(String[] args) {
        int[] a = {0,3,8,10};
        int[] b = {1,2,3,4,5,6};
        Solution.findMedianSortedArrays(a,b);
    }
}
