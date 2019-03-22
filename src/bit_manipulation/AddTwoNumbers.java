package bit_manipulation;

/* 面试题65：不用加减乘除做加法
题目：写一个函数，求两个整数之和，要求在函数体内不得使用＋、－、×、÷
四则运算符号。
 */

/* 拓展
不使用新的变量交换两个变量的值
1. 基于加减法
a = a + b
b = a - b
a = a - b

2. 基于异或运算
a = a ^ b
b = a ^ b
a = a ^ b
 */

public class AddTwoNumbers {
    public int Add(int num1,int num2) {
        do {
            // 第一步相加但是不计算进位，使用异或运算
            int sum = num1 ^ num2;
            // 第二步记录进位，使用与运算，向左移1位
            int carry = (num1 & num2) << 1;
            // 第三步将前面步骤到结果相加，重复前面到部分直到不产生进位
            num1 = sum;
            num2 = carry;
        } while(num2 != 0);
        return num1;
    }
}
