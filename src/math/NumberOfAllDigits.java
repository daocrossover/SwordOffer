package math;

/* 面试题43(二): 从1到n整数中0-9出现的次数

 */

public class NumberOfAllDigits {
    public int[] countDigits(int num) {
        int[] res = new int[10];
        res[0] = getCount0(num);
        for (int i = 1; i < 10; i++) {
            res[i] = getCount(num, i);
        }
        return res;
    }

    // 计算从1到n整数中1-9出现的次数，k为1-9
    private int getCount(int num, int k) {
        // base代表当前位数（个位、十位...）
        // 依次统计k在每一位上有多少个数字
        int base = 1;
        int sum = 0;
        int n = num;
        while (n != 0) {
            // 以num = 123和k = 1为例，当1在个位时sum += 1 * 12
            sum += base * (n / 10);
            // 取得123当前在个位的数字是3
            int cur = n % 10;
            if (cur == k) {
                // 如果cur等于k，说明只能加上后面的num % base个数字 + 1
                sum += num % base + 1;
            } else if (cur > k) {
                // 如果cur大于k，说明还可以加上base个数字
                sum += base;
            }
            base *= 10;
            n /= 10;
        }
        return sum;
    }

    // 计算从1到n整数中0出现的次数
    private int getCount0(int num) {
        // base代表当前位数（个位、十位...）
        // 依次统计0在每一位上有多少个数字
        int base = 1;
        int sum = 0;
        int n = num;
        while (n != 0) {
            // 以num = 123和k = 0为例，当1在个位时sum += 1 * 12
            // 去掉开头为0的情况
            sum += base * (n / 10 - 1);
            // 取得123当前在个位的数字是3
            int cur = n % 10;
            if (cur == 0) {
                // 如果cur等于0，说明只能加上后面的num % base个数字 + 1
                sum += num % base + 1;
            } else if (cur > 0) {
                // 如果cur大于0，说明还可以加上base个数字
                sum += base;
            }
            base *= 10;
            n /= 10;
        }
        return sum;
    }
}
