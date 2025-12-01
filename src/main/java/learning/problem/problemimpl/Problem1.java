// Problem1.java
package learning.problem.problemimpl;

import learning.annotation.ProblemAnnotation;
import learning.problem.Problem;
import org.springframework.stereotype.Component;

@Component
@ProblemAnnotation(id = 1, title = "认识时间复杂度和简单排序算法", videoNumber = "01", category = "基础理论")
public class Problem1 implements Problem {
    @Override
    public void run() {
        System.out.println("Running Video 01: 认识时间复杂度和简单排序算法");
        // 实现相关算法
        System.out.println("选择排序实现:");
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        selectionSort(arr);
        printArray(arr);
    }

    private void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int minIdx = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    private void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
