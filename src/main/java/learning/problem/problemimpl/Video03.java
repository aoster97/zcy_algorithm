// Problem1.java
package learning.problem.problemimpl;

import learning.annotation.ProblemAnnotation;
import learning.problem.Problem;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

@Component
@ProblemAnnotation(id = 1, title = "二进制和位运算", videoNumber = "03", category = "入门")
public class Video03 implements Problem {

    /**
     * $DESCRIPTION
     * <p>
     * 4位的数可以表示一个整数，比如 1000 可以表示 8。int : 32位 ,long: 64位
     * 一. 二进制表示:
     * 无符号整数 : 以4位为例子,没有符号位,全部用来表示数值,一共可以表示2^4个数字,范围 0~ 2^4-1(15) , 32位, 范围 0 ~ 2^32-1 ,64位同理
     * 有符号整数 : 第一个为符号位置,正数和负数表示的位数不同,正数表示的数字范围是 0 ~ 2^3-1,负数表示的数字范围是 -1 ~ -2^3 ,非负数的个数和负数的个数相同,
     * 有符号数据通过补码表示 :
     * 转换方法:
     * 1. 2进制原码转计算机补码  : 以 -2为例子, 先按正数转化为0010 ,然后再末尾减去1 ,得到0001 ,再全部取反得到1110
     * -7 为例子, 先按正数转化为0111 ,然后再末尾减去1 ,得到0110 ,再全部取反得到1001
     * -8 为例子, 先按正数转化为1000 ,然后再末尾减去1 ,得到0111 ,再全部取反得到1000
     * 2. 计算机补码转2进制原码  : 以1001为例子, 取反为0110 ,再末尾加1得到0111, 用无符号数读取数值为7,看符号为1,所以是 -7
     * 简记 : 原(大) -1 取反 补(靠近补码的操作是取反)
     * 补(小) 取反 +1 原
     * <p>
     * 二. 按位取反 ~
     * 三. 常见的位运算 |、&、^、~、<<、>>、>>>
     * | : 按位或,如果两个位相同则结果为0,否则为1,
     * & : 按位与,如果两个位相同则结果为1,否则为0,
     * ^ : 按位异或,如果两个位相同则结果为0,否则为1,
     * ~ : 按位取反,将1变为0,将0变为1,
     * << : 左移,将数字左移n位,相当于乘以2的n次方,
     * >> : 右移,将数字右移n位,相当于除以2的n次方,
     * >>> : 无符号右移,将数字无符号右移n位,相当于除以2的n次方,
     * <p>
     * 四. 位运算的实现
     * printBinary 方法
     * 五. | ,&位运算符 和 ||、&& 逻辑或、逻辑与 之间的区别
     * <p>
     * 六. 相反数
     * <p>
     * <p>
     * 七. 加法逻辑的重要性
     * <p>
     * <p>
     * 八. 关于溢出
     * <p>
     * 九. 异或逻辑的位运算, 使用位运算实现 加减乘除
     *
     * @since 2025-12-01
     */

    @Override
    public void run() {
        System.out.println("Running Video 03: 二进制和位运算");
        // 非负数
        int a =78;
        System.out.println(a);
        printBinary(a);
        System.out.println("========a========");

        // 负数
        int b = -6;
        System.out.println(b);
        printBinary(b);
        System.out.println("========b========");

        int c = 0b1001110;
        System.out.println(c);
        printBinary(c);
        System.out.println("========c========");

        // 直接写十六进制的形式定义变量
        // 0100 -> 4
        // 1110 -> e
        // 0x4e -> 01001110
        int d = 0x4e;
        System.out.println(d);
        printBinary(d);
        System.out.println("========d========");

        // ~、相反数
        System.out.println(a);
        printBinary(a);
        printBinary(~a);
        int e = ~a + 1;
        System.out.println(e);
        printBinary(e);
        System.out.println("========e========");

        // int、long的最小值，取相反数、绝对值，都是自己
        int f = Integer.MIN_VALUE;
        System.out.println(f);
        printBinary(f);
        System.out.println(-f);
        printBinary(-f);
        System.out.println(~f + 1);
        printBinary(~f + 1);
        System.out.println("========f========");

        // | & ^
        int g = 0b0001010;
        int h = 0b0001100;
        printBinary(g | h);
        printBinary(g & h);
        printBinary(g ^ h);
        System.out.println("=======g、h======");
        // 可以这么写 : int num = 3231 | 6434;
        // 可以这么写 : int num = 3231 & 6434;
        // 不能这么写 : int num = 3231 || 6434;
        // 不能这么写 : int num = 3231 && 6434;
        // 因为 ||、&& 是 逻辑或、逻辑与，只能连接boolean类型
        // 不仅如此，|、& 连接的两侧一定都会计算
        // 而 ||、&& 有穿透性的特点
        System.out.println("test1测试开始");
        boolean test1 = returnTrue() | returnFalse();
        System.out.println("test1结果，" + test1);
        System.out.println("test2测试开始");
        boolean test2 = returnTrue() || returnFalse();
        System.out.println("test2结果，" + test2);
        System.out.println("test3测试开始");
        boolean test3 = returnFalse() & returnTrue();
        System.out.println("test3结果，" + test3);
        System.out.println("test4测试开始");
        boolean test4 = returnFalse() && returnTrue();
        System.out.println("test4结果，" + test4);
        System.out.println("=======|、&、||、&&=======");

        // <<
        int i = 0b0011010;
        printBinary(i);
        printBinary(i << 1);
        printBinary(i << 2);
        printBinary(i << 3);
        System.out.println("========= << =========");

        // 非负数 >> >>>，效果一样
        printBinary(i);
        printBinary(i >> 2);
        printBinary(i >>> 2);
        System.out.println("=======i >> >>>=======");
        // 负数 >> >>>，效果不一样
        int j = 0b11110000000000000000000000000000;
        printBinary(j);
        printBinary(j >> 2); // 有符号数右移,补符号位
        printBinary(j >>> 2); // 无符号数右移,补0
        System.out.println("=======j >> >>>=======");
        // 非负数 << 1，等同于乘以2
        // 非负数 << 2，等同于乘以4
        // 非负数 << 3，等同于乘以8
        // 非负数 << i，等同于乘以2的i次方
        // ...
        // 非负数 >> 1，等同于除以2
        // 非负数 >> 2，等同于除以4
        // 非负数 >> 3，等同于除以8
        // 非负数 >> i，等同于除以2的i次方
        // 只有非负数符合这个特征，负数不要用
        int k = 10;
        System.out.println(k);
        System.out.println(k << 1);
        System.out.println(k << 2);
        System.out.println(k << 3);
        System.out.println(k >> 1);
        System.out.println(k >> 2);
        System.out.println(k >> 3);
        System.out.println("=======k=======");

    }

    public void printBinary(int num) {
        /**
         * $DESCRIPTION
         * 可以写成 (num & (1 << i)) != 0 ? "1" : "0"
         * 下面这句写法，可以改成 : System.out.print((a & (1 << i)) != 0 ? "1" : "0");
         * 但不可以改成 :
         * System.out.print((a & (1 << i)) == 1 ? "1" : "0");
         * 因为a如果第i位有1，那么(a & (1 << i))是2的i次方，而不一定是1
         * 比如，a = 0010011
         * a的第0位是1，第1位是1，第4位是1
         * (a & (1<<4)) == 16（不是1），说明a的第4位是1状态
         *
         * @since 2025/12/2
         */

        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    public static boolean returnTrue() {
        System.out.println("进入了returnTrue函数");
        return true;
    }

    public static boolean returnFalse() {
        System.out.println("进入了returnFalse函数");
        return false;
    }

}
