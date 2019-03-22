package math;

/* 面试题44：数字序列中某一位的数字
题目：数字以0123456789101112131415…的格式序列化到一个字符序列中。在这
个序列中，第5位（从0开始计数）是5，第13位是1，第19位是4，等等。请写一
个函数求任意位对应的数字。
 */

public class DigitsInSequence {
    public int digitAtIndex(int index) {
        if (index < 0) return -1;
        int digits = 1;
        while (true) {
            int numbers = countOfIntegers(digits);
            if (index < numbers * digits) {
                return digitAtIndex(index, digits);
            } else {
                index -= numbers * digits;
                digits++;
            }
        }
    }

    // 求位数为digits的数字总共有多少个
    // digits = 1，（0 - 9），10
    // digits = 2，（10 - 99），90
    // digits = 3，（100 - 999），900
    private int countOfIntegers(int digits) {
        if (digits == 1) return 10;
        return 9 * (int)Math.pow(10, digits - 1);
    }

    // 第一个digits位数
    private int beginNumber(int digits) {
        if (digits == 1) return 0;
        return (int)Math.pow(10, digits - 1);
    }

    private int digitAtIndex(int index, int digits) {
        // 计算index所在的数字number
        int number = beginNumber(digits) + index / digits;
        int indexFromRight = digits - index % digits;
        for (int i = 1; i < indexFromRight; ++i) {
            number /= 10;
        }
        return number % 10;
    }
}
