// ProblemAnnotation.java
package learning.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ProblemAnnotation {
    int id();
    String title() default "";
    String videoNumber() default "";  // 视频编号，如"01", "02"
    String category() default "";     // 分类/主题
}
