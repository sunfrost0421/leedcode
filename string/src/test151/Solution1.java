package test151;

public class Solution1 {
    //解法一：将字符串分割为多个单词，再反向填充到新的字符串中。
    //时间复杂度：匹配、分割、填充
    //空间复杂度：字符串数组O(N)、新的StringBuilder O(N)
    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] s1 = s.split(" ");
        for(int i = s1.length - 1; i >= 0; i--){
            if(s1[i] == null||s1[i] == ""){
                continue;
            }
            sb.append(s1[i].trim());
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println(reverseWords(s));
    }
}
