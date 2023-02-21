package kmp;

import java.util.Arrays;
//ǰ׺��ͳһ���Ƶķ�ʽ
public class Solution {
    public static int[] getNext(String s){
        //�Ӵ�Ϊ��
        if(s == null || s.length() == 0){
            return null;
        }
        int[] res = new int[s.length()];
        res[0] = -1;
        //�Ӵ�����Ϊ1,ֻ��һ����ĸ
        if(s.length() == 1){
            return res;
        }
        //�Ӵ����ȴ���1
        res[1] = 0;
        int i = 0;
        int j = 1;
        while(j < s.length() - 1){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j++;
                res[j] = i;
            }else if(i > 0){
                i = res[i];
            }else if(i == 0){
                j++;
                res[j] = 0;
            }
        }
        System.out.println(Arrays.toString(res));
        return res;
    }

    public static int kmp(String s, String sub){
        if(sub.length() > s.length()){
            return -1;
        }
        int[] next = getNext(sub);
        int i = 0;
        int j = 0;
        while(i < s.length()){
            if(s.charAt(i) == sub.charAt(j)){
                i++;
                j++;
                if(j == sub.length()){
                    return i - j;
                }
            }else{
                j = next[j];
                if(j == -1){
                    i++;
                    j = 0;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "abcabdadb";
        String sub = "abda";
        System.out.println(kmp(s, sub));
    }
}
