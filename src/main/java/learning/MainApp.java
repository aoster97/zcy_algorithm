package learning;

import learning.factory.ProblemFactory;
import learning.problem.Problem;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.Scanner;

@SpringBootApplication
public class MainApp implements CommandLineRunner {

    private final ProblemFactory problemFactory;

    public MainApp(ProblemFactory problemFactory) {
        this.problemFactory = problemFactory;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n请输入题号 (输入 list 查看所有题目, exit 退出): ");
            String input = scanner.nextLine();

            if ("exit".equalsIgnoreCase(input)) break;
            if ("list".equalsIgnoreCase(input)) {
                problemFactory.listProblems();
                continue;
            }

            try {
                int id = Integer.parseInt(input);
                Problem problem = problemFactory.getProblem(id);
                problem.run();
            } catch (Exception e) {
                System.out.println("无效输入: " + input);
            }
        }
    }
}
