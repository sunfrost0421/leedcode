import java.util.Deque;
import java.util.LinkedList;
import java.util.regex.Pattern;

public class Test150 {
    public static void main(String[] args) {
        String[] t = {"4","13","5","/","+"};
        Solution.evalRPN(t);
        System.out.println("----");
    }
}
class Solution {
    public static boolean isNum(String s){
        //�ж�һ���ַ����Ƿ�Ϊ����
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]+$");
        return pattern.matcher(s).matches();
    }
    public static int evalRPN(String[] tokens) {
        //����һ��ջ���洢����
        Deque<Integer> stack = new LinkedList<>();
        int a = 0;
        int b = 0;
        //�����沨�����ʽ��Ĭ���沨�����ʽ�ǺϷ���Ч��
        for(int i = 0; i < tokens.length; i++){
            //��������־���ջ������ȡ����������
            if(isNum(tokens[i])){
                stack.push(Integer.valueOf(tokens[i]));
            }
            else{
                b = stack.pop();
                a = stack.pop();
                if(tokens[i].equals("+")){stack.push(a+b);}
                else if(tokens[i].equals("-")){stack.push(a-b);}
                else if(tokens[i].equals("*")){stack.push(a*b);}
                else if(tokens[i].equals("/")){stack.push(a/b);}
            }
        }
        return stack.peek();
    }
}