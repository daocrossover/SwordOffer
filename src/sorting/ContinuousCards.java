package sorting;

/* 面试题61：扑克牌的顺子
题目：从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王可以看成任意数字。
为了方便起见,你可以认为大小王是0。
 */

import java.util.Arrays;

public class ContinuousCards {
    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        Arrays.sort(numbers);
        // 统计大小王的数量
        int count = 0;
        for (int i = 0; i < numbers.length && numbers[i] == 0; ++i) {
            count++;
        }
        for (int i = count; i < numbers.length - 1; ++i) {
            // 两个数相等，有对子，不可能是顺子
            if (numbers[i + 1] == numbers[i]) {
                return false;
            }
            // 用癞子去替代间隔
            count -= numbers[i + 1] - numbers[i] - 1;
        }
        return count >= 0;
    }
}
