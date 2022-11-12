package bisection;

class Solution4 {
    public static int mySqrt(int x) {
        int left = 0;
        int right = 1<<16;
        while(left != right){
            int middle = (left + right)/2;
            long m1 = (long)middle * (long)middle;
            long m2 = (long)(middle + 1) * (long)(middle + 1);
            if(m2 < x){
                left = middle + 1;
            }
            else if(m1 > x)
                right = middle;
            else if(m2 == x)
                return middle + 1;
            else
                return middle;
        }
        return -1;
    }
}

public class Test69 {
    public static void main(String[] args) {
        int res = Solution4.mySqrt(2147395599);
        System.out.println(res);
    }
}
