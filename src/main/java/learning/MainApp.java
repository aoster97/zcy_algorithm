// MainApp.java
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
            System.out.println("\n=== 左程云算法练习系统 ===");
            System.out.println("1. 输入题号练习 (例如: 1)");
            System.out.println("2. 输入视频编号练习 (例如: 01, 02)");
            System.out.println("3. 输入 'category <分类>' 查看分类题目");
            System.out.println("4. 输入 'list' 查看所有题目");
            System.out.println("5. 输入 'exit' 退出");
            System.out.print("请选择操作: ");

            String input = scanner.nextLine().trim();

            if ("exit".equalsIgnoreCase(input)) {
                System.out.println("感谢使用，再见！");
                break;
            }

            if ("list".equalsIgnoreCase(input)) {
                problemFactory.listProblems();
                continue;
            }

            if (input.startsWith("category ")) {
                String category = input.substring(9).trim();
                problemFactory.listProblemsByCategory(category);
                continue;
            }

            // 尝试按视频编号查找
            if (input.matches("\\d{2}")) { // 匹配两位数字格式
                Problem problem = problemFactory.getProblemByVideoNumber(input);
                if (problem != null) {
                    problem.run();
                } else {
                    System.out.println("未找到视频编号为 " + input + " 的题目");
                }
                continue;
            }

            // 按题号查找
            try {
                int id = Integer.parseInt(input);
                Problem problem = problemFactory.getProblem(id);
                problem.run();
            } catch (NumberFormatException e) {
                System.out.println("无效输入: " + input + "，请输入有效的题号或视频编号");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }
}
