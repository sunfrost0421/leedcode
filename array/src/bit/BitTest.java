package bit;

public class BitTest {
    public static void showBinary(int a){
        System.out.println("Int: " + a + "  Binary: "
                + Integer.toBinaryString(a));
    }
    public static void main(String[] args) {
        int x = -7;
        showBinary(x);
        showBinary(~x+1);//���෴�����൱��-x

    }
}
