package dual_pointer;
//双指针，分别遍历两个字符串
class Solution3 {
    public static String getSimpleString(String s){
        int fast = 0;
        int slow = 0;
        String[] array_s = s.split("");
        for(fast = 0;fast < array_s.length;fast++){
            if(!array_s[fast].equals("#")){
                array_s[slow] = array_s[fast];
                slow++;
            }
            else if(array_s[fast].equals("#")&&slow!=0){
                slow--;
            }
        }
        StringBuilder sb = new StringBuilder("");
        for(int i = 0;i < slow;i++){
            sb.append(array_s[i]);
        }
        return sb.toString();
    }
}
//双指针，两个指针用在两个字符串上
class Solution4 {
    public static boolean backspaceCompare(String s, String t) {
        int i = s.length()-1;
        int j = t.length()-1;
        int s_skip = 0;
        int t_skip = 0;
        char cs = '0';
        char ct = '0';
        while(i>=0||j>=0){
            while(i>=0){
                if(s.charAt(i)=='#'){
                    s_skip++;
                }else{
                    if(s_skip == 0){
                        break;
                    }else{
                        s_skip--;
                    }
                }
                i--;
            }
            while(j>=0){
                if(t.charAt(j)=='#'){
                    t_skip++;
                }else{
                    if(t_skip == 0){
                        break;
                    }else{
                        t_skip--;
                    }
                }
                j--;
            }
            if(i>=0||j>=0){
                if(i>=0&&j>=0) {
                    if (s.charAt(i) != t.charAt(j)) {
                        return false;
                    }
                }else{
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }
}

public class Test844 {
    public static void main(String[] args) {
        String s1 = "xywrrmp";
        String s2 = "xywrrmu#p";
        System.out.println(Solution4.backspaceCompare(s1,s2));

    }
}
