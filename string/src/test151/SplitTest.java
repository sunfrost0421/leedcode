package test151;

public class SplitTest {
    public static void showStrings(String[] ss, String msg){
        System.out.print(msg+":");
        for(String s : ss){
            System.out.print("["+s+"]");
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        String s1 = "001000200304000";
        System.out.println(s1);
        //�ָ��ַ����е�ÿһ���ַ�
        String[] s2 = s1.split("");
        showStrings(s2, "split('')");
        //
        String[] s3 = s1.split("0");
        showStrings(s3, "split('0')");
        //
        String[] s7 = s1.split("0+");
        showStrings(s7, "split('0+')");
        //ռ��ƥ��,+
        String reg = "0+";
        String s4 = s1.replaceAll(reg,"q");
        System.out.println("replaceAll('0+', 'q'):"+s4);
        //̰��ƥ�䣬Ĭ��
        String reg2 = "0";
        String s5 = s1.replaceAll(reg2,"q");
        System.out.println("replaceAll('0', 'q'):"+s5);
        //����ƥ�䣬?
        String reg3 = "0?";
        String s6 = s1.replaceAll(reg3,"q");
        System.out.println("replaceAll('0?', 'q'):"+s6);

    }
}
