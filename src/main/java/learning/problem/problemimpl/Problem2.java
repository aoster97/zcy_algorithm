// Problem2.java
package learning.problem.problemimpl;

import learning.annotation.ProblemAnnotation;
import learning.problem.Problem;
import org.springframework.stereotype.Component;

@Component
@ProblemAnnotation(id = 2, title = "异或运算和经典题目", videoNumber = "02", category = "位运算")
public class Problem2 implements Problem {
    @Override
    public void run() {
        System.out.println("Running Video 02: 异或运算和经典题目");
        // 实现相关算法
        System.out.println("异或运算示例:");
        int a = 5; // 二进制: 101
        int b = 3; // 二进制: 011
        System.out.println(a + " XOR " + b + " = " + (a ^ b)); // 结果: 6 (二进制: 110)

        // 不使用临时变量交换两个数
        System.out.println("交换前: a=" + a + ", b=" + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("交换后: a=" + a + ", b=" + b);
    }
}
