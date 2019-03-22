package hash_table;

/* 面试题50（二）：字符流中第一个只出现一次的字符
题目：请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从
字符流中只读出前两个字符"go"时，第一个只出现一次的字符是'g'。当从该字
符流中读出前六个字符"google"时，第一个只出现一次的字符是'l'。
 */


public class FirstCharacterInStream {
    // occurrence[i]: A character with ASCII value i;
    // occurrence[i] = -1: The character has not found;
    // occurrence[i] = -2: The character has been found for mutlple times
    // occurrence[i] >= 0: The character has been found only once
    private int[] occurrence;
    private int index;

    FirstCharacterInStream() {
        occurrence = new int[256];
        index = 0;
    }

    void Insert(char ch) {
        if (occurrence[ch] == -1) {
            occurrence[ch] = index;
        } else if (occurrence[ch] >= 0) {
            occurrence[ch] = -2;
        }
        index++;
    }

    int FirstAppearingOnce() {
        int pos = -1;
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < 256; ++i) {
            if(occurrence[i] >= 0 && occurrence[i] < minIndex) {
                minIndex = occurrence[i];
                pos = i;
            }
        }
        return pos;
    }
}
