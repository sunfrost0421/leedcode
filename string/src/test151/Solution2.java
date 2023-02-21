package test151;

public class Solution2 {
    public static String reverseWords(String s){
        return " ";
    }
    public static String removeSpace(String s){
        StringBuilder sb = new StringBuilder();
        boolean is_word = false;
        int end = s.length() - 1;
        while(s.charAt(end) == ' '){
            end--;
        }
        for(int i = 0; i <= end; i++){
            if(s.charAt(i) == ' '){
                if(is_word == true){
                    sb.append(" ");
                }
                is_word = false;
            }else{
                is_word = true;
                sb.append(s.charAt(i));
            }
        }
        System.out.println(sb.toString());

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "  jkh jj   kk ";
        removeSpace(s);
    }
}
