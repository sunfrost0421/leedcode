import java.util.Arrays;

public class SortWithCompare {
    /**
     * ð������:�ռ临�Ӷ�O(1)��ʱ�临�Ӷ�O(n2)
     * @param input����������ǰ����
     * @return �������������
     */
    public static int[] bubbleSort(int[] input){
        for(int i = 0; i < input.length - 1; i++){
            int flag = 0;
            for(int j = 0; j < input.length - 1 - i; j++){
                if(input[j] > input[j+1]){
                    int t = input[j+1];
                    input[j+1] = input[j];
                    input[j] = t;
                    flag = 1;
                }
            }
            if(flag == 0){
                break;
            }
        }
        System.out.println(Arrays.toString(input));
        return input;
    }

    /**
     * ѡ������:�ռ临�Ӷ�O(1)��ʱ�临�Ӷ�O(n2)
     * @param input����������ǰ����
     * @return �������������
     */
    public static int[] selectionSort(int[] input) {
        for(int i = 0; i< input.length; i++){
            int minIndex = i;
            for(int j = i+1; j< input.length ; j++){
                if(input[j]<input[minIndex]){
                    minIndex = j;
                }
            }
            int min = input[minIndex];
            input[minIndex] = input[i];
            input[i] = min;
        }
        System.out.println(Arrays.toString(input));
        return input;
    }


    /**
     * ��������:�ռ临�Ӷ�O(1)��ʱ�临�Ӷ�O(n2)
     * @param input����������ǰ����
     * @return �������������
     */
    public static int[] insertionSort(int[] input) {
        //�Ե�һ����Ϊ��׼�������������ǰ��
        for(int i = 1; i < input.length; i++){
            int cur = input[i];
            int preIndex = i - 1;
            //�����ǰ��С��ǰһ����������Ҫ����ǰ������򣬷���ֱ�ӷ���ԭλ
            while(cur < input[preIndex]&&preIndex>=0){
                input[preIndex+1] = input[preIndex];
                preIndex--;
            }
            input[preIndex+1] = cur;
        }
        System.out.println(Arrays.toString(input));
        return input;
    }

    public static int[] shellSort(int[] input) {
        int n = input.length;
        int gap = n / 2;
        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                int current = input[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && input[preIndex] > current) {
                    input[preIndex + gap] = input[preIndex];
                    preIndex -= gap;
                }
                input[preIndex + gap] = current;
            }
            gap /= 2;
        }
        return input;
    }

    public static int[] quickSort(int[] input){
        return input;
    }


    public static void main(String[] args) {
        int[] a = {9,3,7,6,2,1,4,8,0,5};
        bubbleSort(a);
        insertionSort(a);
        selectionSort(a);

    }
}


