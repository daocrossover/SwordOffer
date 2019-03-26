package array;

/* 面试题17：打印1到最大的n位数
题目：输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则
打印出1、2、3一直到最大的3位数即999。
*/

/* 思路
当输入的n很大，可能已经超过了long，成为大数问题。
使用数组或者字符串来表示数字
 */

public class Print1ToMaxOfNDigits {
    public void print(int n) {
        if (n <= 0) return;
        int[] number = new int[n];

        while (!increment(number)){
            printNumber(number);
        }
    }

    // 对表示数字的数组进行加1操作
    private boolean increment(int[] number) {
        boolean isOverflow = false;
        int carry = 0;
        for (int i = number.length - 1; i >= 0; --i) {
            int sum = 0;
            if (i == number.length - 1) {
                sum++;
            }
            sum += number[i] + carry;
            if (sum >= 10) {
                if (i == 0) {
                    isOverflow = true;
                } else {
                    carry = 1;
                    sum -= 10;
                    number[i] = sum;
                }
            } else {
                number[i] = sum;
                break;
            }
        }
        return isOverflow;
    }

    // 打印出每个数字，开头的0不打印出来
    private void printNumber(int[] number) {
        boolean isBeginning = true;
        for (int i = 0; i < number.length; ++i) {
            if (isBeginning && number[i] != 0) {
                isBeginning = false;
            }
            if (!isBeginning) {
                System.out.print(number[i]);
            }
        }
        System.out.println();
    }
}
