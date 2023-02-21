package Test459;

import java.util.Arrays;

public class Solution {
    public static int[] getNext(String s){
        int j = 0;
        int[] next = new int[s.length()];
        next[0] = 0;
        for(int i = 1; i < s.length(); i++){
            while(j > 0 && s.charAt(i) != s.charAt(j)){
                j = next[j - 1];
            }
            if(s.charAt(i) == s.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        System.out.println(Arrays.toString(next));
        return next;
    }
    public static boolean repeatedSubstringPattern(String s) {
        int[] next = new int[s.length() + 1];
        next[0] = -1;
        if(s.length() == 1){
            return false;
        }
        next[1] = 0;
        int i = 0;
        int j = 1;
        while(j < s.length()){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j++;
                next[j] = i;
            }else{
                if(i == 0){
                    j++;
                    next[j] = 0;
                }else{
                    i = next[i];
                }
            }
        }
        System.out.println(Arrays.toString(next));
        if(next[s.length()] == 0){
            return false;
        }
        int len = s.length() - next[s.length()];
        int res = s.length() % len;
        if(res == 0){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        repeatedSubstringPattern("abac");
        getNext("abac");
    }
}
