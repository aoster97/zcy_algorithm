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
    @Test
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
