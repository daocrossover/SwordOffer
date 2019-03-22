package math;

/* 面试题62：圆圈中最后剩下的数字
题目：0, 1, …, n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里
删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 */

/* 思路：
定义一个n和m的方程f(n, m)表示每次在n个数字0，...，n-1中删除第m个数字最后剩下的数字。
第一个被删除的数字为(m-1)%n，记为k，剩下的序列为k+1，k+2，...，n-1，0，...，k-1，
该序列最后剩下的数字应该也是关于n和m的函数，记为f'(n-1, m)。
最初序列最后剩下的数字一定等于删除第一个数字之后的序列最后剩下的数字，即f(n, m) = f'(n-1, m)
把k+1，k+2，...，n-1，0，...，k-1进行映射，映射结果是0～n-2的序列
k+1 -> 0
k+2 -> 1
...
n-1 -> n-k-2
0   -> n-k-1
1   -> n-k
k-1 -> n-2
将映射定义为p，p(x) = (x-k-1)%n，逆映射为p-1(x) = (x+k+1)%n
由于映射之后的序列与最初的序列有相同的形式，仍然可以用函数f来表示，即f(n-1, m)。
映射之前的序列最后剩下的数字f'(n-1, m) = p-1[f(n-1, m)] = (f(n-1, m)+k+1)%n
将k = (m-1)%n代入得：
f(n, m) = f'(n-1, m) = (f(n-1, m)+m)%n
故可以得到递推公式：
f(n, m) = 0                 n = 1
        = (f(n-1, m)+m)%n   n > 1
 */

import java.util.LinkedList;
import java.util.List;

public class LastNumberInCircle {
    // 方法1：非递归
    // 时间复杂度：O(n)，空间复杂度：O(1)
    public int lastRemaining(int n, int m) {
        if (n < 1 || m < 1) return -1;
        int last = 0;
        for (int i = 2; i <= n; ++i) {
            last = (last + m) % i;
        }
        return last;
    }

    // 方法2：递归
    public int lastRemaining1(int n, int m) {
        if (n == 0) return -1; /* 特殊输入的处理 */
        if (n == 1) return 0;  /* 递归返回条件 */
        return (lastRemaining1(n - 1, m) + m) % n;
    }

    // 方法3：使用循环链表模拟
    // 时间复杂度：O(mn)，空间复杂度：O(n)
    public static int lastRemaining2(int n, int m) {
        // 判断输入数据的合法性
        if (n < 1 || m < 1) {
            return -1;
        }
        // 为链表添加数据
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0; // 要删除元素的位置
        while (list.size() > 1) {
            // 只要移动(m-1)次就可移动到下一个要删除的元素上
            for (int i = 1; i < m; i++) {
                index = (index + 1) % list.size();
            }

            list.remove(index);
        }
        return list.get(0);
    }
}
