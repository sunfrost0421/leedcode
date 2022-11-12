package test3_SubString;

/*Test3
* ����һ���ַ��� s �������ҳ����в������ظ��ַ��� ��Ӵ� �ĳ��ȡ�
* */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//����ƥ���㷨O(n3)
class Solution1{
    public static int lengthOfLongestSubstring(String s) {
        int i=0,j=0;
        int len = 1;
        int result=0;
        if(s.isEmpty())
            return 0;
        else
            result = 1;
        char[] cs = s.toCharArray();
        for(i=1;i<s.length();i++)
        {
            len = 1;
            for(j=i-1;j>=0;j--)
            {
                int k=i;
                while(j!=k){
                    if(cs[j]!=cs[k]) k--;
                    else break;
                }
                if(k==j)
                    len++;
                else
                    break;
            }
            if(result<len)
                result = len;
        }
        return result;
    }
}

//ʹ��HashSet�ж�O(n2)�Ƿ��ظ�����дЧ�ʲ���
class Solution2{
    public static boolean isSingle(String s){
        if(s.isEmpty())
            return true;
        String[] ss = s.split("");
        Set<String> set = new HashSet<>();
        for (String c:ss){
            set.add(c);
        }
        if(set.size()==s.length())
            return true;
        else
            return false;
    }
    public static int lengthOfLongestSubstring(String s){
        if(s.isEmpty())
            return 0;
        if(s.length()==1)
            return 1;
        String[] ss = s.split("");
        int len = 0;
        int result = 1;
        int i=0,j=1;
        while(j!=s.length()+1)
        {
            if(isSingle(s.substring(i,j))){
                len++;
            }
            else{
                i++;
            }
            j++;
        }
        return len;
    }
}

class Solution3{
    public static int lengthOfLongestSubstring(String s){
        int left = 0;
        int len = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            if(map.containsKey(s.charAt(i)))
                left = Math.max(map.get(s.charAt(i))+1,left);
            map.put(s.charAt(i),i);
            len = Math.max(len,i-left+1);
        }
        return len;
    }
}

public class Test3 {
    public static void main(String[] args) {
        String ss = "ab";
        System.out.println(Solution2.lengthOfLongestSubstring(ss));
    }
}
