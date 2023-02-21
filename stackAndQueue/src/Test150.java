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
        //判断一个字符串是否为数字
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]+$");
        return pattern.matcher(s).matches();
    }
    public static int evalRPN(String[] tokens) {
        //建立一个栈，存储数字
        Deque<Integer> stack = new LinkedList<>();
        int a = 0;
        int b = 0;
        //遍历逆波兰表达式，默认逆波兰表达式是合法有效的
        for(int i = 0; i < tokens.length; i++){
            //如果是数字就入栈，否则取出两个数字
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