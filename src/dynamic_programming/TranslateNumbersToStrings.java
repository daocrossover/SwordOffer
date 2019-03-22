package dynamic_programming;

/* 面试题46：把数字翻译成字符串
译成"b"，……，11翻译成"l"，……，25翻译成"z"。一个数字可能有多个翻译。例
如12258有5种不同的翻译，它们分别是"bccfi"、"bwfi"、"bczi"、"mcfi"和
"mzi"。请编程实现一个函数用来计算一个数字有多少种不同的翻译方法。
 */

public class TranslateNumbersToStrings {
    int GetTranslationCount(String number) {
        int length = number.length();
        int[] dp = new int[length];
        int count = 0;
        for (int i = length - 1; i >= 0; --i) {
            if (i < length - 1) {
                count = dp[i + 1];
            } else {
                count = 1;
            }
            if (i < length - 1) {
                int digit1 = number.charAt(i) - '0';
                int digit2 = number.charAt(i+1) - '0';
                int converted = digit1 * 10 + digit2;
                if (converted >= 10 && converted <= 25) {
                    if (i < length - 2) {
                        count += dp[i + 2];
                    } else {
                        count++;
                    }
                }
            }
            dp[i] = count;
        }
        return dp[0];
    }
}
