package design;

/* 面试题2：实现Singleton模式
题目：设计一个类，我们只能生成该类的一个实例。
 */

public class Singleton {
    // 利用一个静态变量来记录Singleton类的唯一实例
    // volatile关键字确保在uniqueInstance变量被初始化成Singleton实例时，
    // 多个线程正确地处理uniqueInstance变量
    private volatile static Singleton uniqueInstance;

    // 其他有用的实例化变量

    // 把构造器声明为私有的，只有Singleton类内才能调用构造器
    private Singleton() {}

    // 用getInstance()方法实例化对象，并返回这个实例
    public static Singleton getInstance() {
        // 检查实例，如果不存在就进入同步区块，只有第一次才彻底执行
        if (uniqueInstance == null) {
            synchronized (Singleton.class) {
                // 进入区块后，再检查一次，如果仍然是null，才创建实例
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
