package learning.problem.problemimpl;

import learning.annotation.ProblemAnnotation;
import learning.problem.Problem;
import org.springframework.stereotype.Component;

@Component
@ProblemAnnotation(id = 1, title = "选择、冒泡、插入排序")
public class Problem1 implements Problem {
    @Override
    public void run() {
        System.out.println("Running Problem 1: Two Sum");
        // 题解代码
    }
}
