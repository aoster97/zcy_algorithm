// Problem1.java
package learning.problem.problemimpl;

import learning.annotation.ProblemAnnotation;
import learning.problem.Problem;
import org.springframework.stereotype.Component;

@Component
@ProblemAnnotation(id = 1, title = "二进制和位运算", videoNumber = "03", category = "入门")
public class Problem1 implements Problem {

   /**
    * $DESCRIPTION
    *  4位的数可以表示一个整数，比如 1000 可以表示 8。int : 32位 ,long: 64位
    * 二进制表示:
    *  无符号整数 : 以4位为例子,没有符号位,全部用来表示数值,一共可以表示2^4个数字,范围 0~ 2^4-1(15) , 32位, 范围 0 ~ 2^32-1 ,64位同理
    *  有符号整数 : 第一个为符号位置,正数和负数表示的位数不同,正数表示的数字范围是 0 ~ 2^3-1,负数表示的数字范围是 -1 ~ -2^3 ,非负数的个数和负数的个数相同,
    *  有符号数据通过补码表示 :
    *   转换方法:
    *       1. 2进制原码转计算机补码  : 以 -2为例子, 先按正数转化为0010 ,然后再末尾减去1 ,得到0001 ,再全部取反得到1110
    *                               -7 为例子, 先按正数转化为0111 ,然后再末尾减去1 ,得到0110 ,再全部取反得到1001
    *                               -8 为例子, 先按正数转化为1000 ,然后再末尾减去1 ,得到0111 ,再全部取反得到1000
    *       2. 计算机补码转2进制原码  : 以1001为例子, 取反为0110 ,再末尾加1得到0111, 用无符号数读取数值为7,看符号为1,所以是 -7
    *
    *
    * @author
    * @since 2025-12-01
    */


    @Override
    public void run() {
        System.out.println("Running Video 03: 二进制和位运算");
        // 实现相关算法
        System.out.println("选择排序实现:");

    }
}
