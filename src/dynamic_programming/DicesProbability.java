package dynamic_programming;

/* 面试题60：n个骰子的点数
题目：把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s
的所有可能的值出现的概率。
 */

/* 思路
1. 当有i个骰子，点数和为j时，出现次数记为dp(i, j)。
2. 当有i-1个骰子时，再增加一个骰子，这个骰子的点数只可能为1、2、3、4、5或6。
那i个骰子得到点数和为j的情况有：
(i-1,j-1)：第i个骰子投了点数1
(i-1,j-2)：第i个骰子投了点数2
(i-1,j-3)：第i个骰子投了点数3
....
(i-1,j-6)：第i个骰子投了点数6

所以状态转移方程为：dp[i][j] = sum(dp[i-1][j-m]) (1 <= m <= 6 && m < j)
初始化1个骰子：dp(1,1) = dp(1,2) = dp(1,3) = dp(1,4) = dp(1,5) = dp(1,6) = 1
 */

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DicesProbability {
    /**
     * @param n an integer
     * @return a list of Map.Entry<sum, probability>
     */
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        // Write your code here
        // Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
        // to create the pair
        int face = 6;
        // n个骰子点数和最小为n，6 * n，总共有6^n种组合
        // 因为i只和i-1有关，使用两个数组来存储即可，flag和1-flag相当于i和i-1
        long[][] dp = new long[2][face * n + 1];
        int flag = 0;
        // 初始化dp数组
        for (int i = 1; i <= face; ++i) {
            dp[flag][i] = 1;
        }
        for (int i = 2; i <= n; ++i) {
            // 新的第i个骰子的dp数组清零
            for (int j = 0; j <= face * n; ++j) {
                dp[1 - flag][j] = 0;
            }
            // 点数和最小为i，最大为i * face
            for (int j = i; j <= i * face; ++j) {
                for (int k = 1; k <= face && k <= j; ++k) {
                    dp[1 - flag][j] += dp[flag][j - k];
                }
            }
            flag = 1 - flag;
        }
        double totalNum = Math.pow(6, n);
        List<Map.Entry<Integer, Double>> res = new ArrayList<>();
        for (int i = n; i <= face * n; ++i) {
            res.add(new AbstractMap.SimpleEntry<>(i, dp[flag][i] / totalNum));
        }
        return res;
    }
}
