package array;

/* 面试题58（二）：左旋转字符串
题目：字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
请定义一个函数实现字符串左旋转操作的功能。比如输入字符串"abcdefg"和数
字2，该函数将返回左旋转2位得到的结果"cdefgab"。
 */

public class RotateString {
    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] s = str.toCharArray();
        n %= s.length;
        // 翻转字符串的前面n个字符
        reverse(s, 0, n - 1);
        // 翻转字符串的后面部分
        reverse(s, n, s.length - 1);
        // 翻转整个字符串
        reverse(s, 0, s.length - 1);
        return new String(s);
    }

    private void reverse(char[] s, int start, int end) {
        while (start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }
}
