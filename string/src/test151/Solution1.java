package test151;

public class Solution1 {
    //�ⷨһ�����ַ����ָ�Ϊ������ʣ��ٷ�����䵽�µ��ַ����С�
    //ʱ�临�Ӷȣ�ƥ�䡢�ָ���
    //�ռ临�Ӷȣ��ַ�������O(N)���µ�StringBuilder O(N)
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
