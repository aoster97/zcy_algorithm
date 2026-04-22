// Problem2.java
package learning;

import learning.annotation.ProblemAnnotation;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

@Component
@ProblemAnnotation(id = 2, title = "选择、冒泡、插入排序", videoNumber = "04", category = "排序")
public class Video04 implements Problem {
    @Override
    @Test
    public void run() {
        System.out.println("Running Video 04: 选择、冒泡、插入排序");

    }




}
