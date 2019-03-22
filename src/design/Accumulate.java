package design;

/* 面试题64：求1+2+…+n
题目：求1+2+…+n，要求不能使用乘除法、for、while、if、else、switch、case
等关键字及条件判断语句（A?B:C）。
 */

class Sum {
    private static int n = 0;
    private static int sum = 0;
    public Sum() {
        n++;
        sum += n;
    }

    public static void reset() {
        n = 0;
        sum = 0;
    }

    public static int getSum() {
        return sum;
    }
}

public class Accumulate {
    // 方法1：使用递归
    // 关键是无法直接使用if语句来指定返回条件，故利用条件与的特性。
    // &&具有短路原则，即在第一个条件语句为false的情况下不会去执行第二个条件语句。
     // 当n <= 0时就不会执行后面的条件语句，直接返回
    public int getSum(int n) {
        int sum = n;
        boolean b = (n > 0) && ((sum += getSum(n - 1)) > 0);
        return sum;
    }

    // 方法2：使用构造函数
    // 将累加值存到一个static变量中，实例化n个Sum类型后得到最后累加值
    public int getSum1(int n) {
        Sum.reset();
        Sum[] a = new Sum[n];
        for (int i = 0; i < n; ++i) {
            a[i] = new Sum();
        }
        return Sum.getSum();
    }
}
