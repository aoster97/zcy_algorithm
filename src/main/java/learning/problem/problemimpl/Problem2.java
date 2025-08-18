package learning.problem.problemimpl;

import learning.annotation.ProblemAnnotation;
import learning.problem.Problem;
import org.springframework.stereotype.Component;

@Component
@ProblemAnnotation(id = 2, title = "Add Two Numbers")
public class Problem2 implements Problem {
    @Override
    public void run() {
        System.out.println("Running Problem 2: Add Two Numbers");
        // 题解代码
    }
}