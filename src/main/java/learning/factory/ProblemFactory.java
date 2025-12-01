// ProblemFactory.java
package learning.factory;

import learning.annotation.ProblemAnnotation;
import learning.problem.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ProblemFactory {

    private final Map<Integer, Problem> problems = new HashMap<>();
    private final Map<String, Problem> videoProblems = new HashMap<>();

    @Autowired
    public ProblemFactory(ApplicationContext context) {
        Map<String, Problem> beans = context.getBeansOfType(Problem.class);

        for (Problem problem : beans.values()) {
            ProblemAnnotation annotation = problem.getClass().getAnnotation(ProblemAnnotation.class);
            if (annotation != null) {
                problems.put(annotation.id(), problem);
                if (!annotation.videoNumber().isEmpty()) {
                    videoProblems.put(annotation.videoNumber(), problem);
                }
            }
        }
    }

    public Problem getProblem(int id) {
        if (!problems.containsKey(id)) {
            throw new IllegalArgumentException("No problem with id: " + id);
        }
        return problems.get(id);
    }

    public Problem getProblemByVideoNumber(String videoNumber) {
        return videoProblems.get(videoNumber);
    }

    public void listProblems() {
        problems.forEach((id, problem) -> {
            ProblemAnnotation annotation = problem.getClass().getAnnotation(ProblemAnnotation.class);
            System.out.println(id + " -> " + annotation.title() +
                             " (Video: " + annotation.videoNumber() + ", Category: " + annotation.category() + ")");
        });
    }

    public void listProblemsByCategory(String category) {
        System.out.println("Category: " + category);
        problems.forEach((id, problem) -> {
            ProblemAnnotation annotation = problem.getClass().getAnnotation(ProblemAnnotation.class);
            if (annotation != null && category.equals(annotation.category())) {
                System.out.println("  " + annotation.videoNumber() + " (" + id + ") -> " + annotation.title());
            }
        });
    }
}
