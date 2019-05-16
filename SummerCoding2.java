package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class SummerCoding2 {
    private static List<String> list = new ArrayList<>();
    private static List<String> answer = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution(7)));

    }

    public static String[] solution(int n) {
        long start = System.currentTimeMillis();
        dfs(0, n);

        long end = System.currentTimeMillis();
        System.out.println("걸린 시간 : " + (end - start) + "ms");
        return answer.stream().toArray(String[]::new);
    }

    private static void dfs(int depth, int n) {
        if (depth == n * 2) {
            if (isAvailable()) {
                answer.add(list.stream().collect(Collectors.joining()));
            }
            return;
        }

        if (depth != n * 2 - 1) {
            list.add("(");
            dfs(depth + 1, n);
            list.remove(list.size() - 1);
        }

        if (depth != 0) {
            list.add(")");
            dfs(depth + 1, n);
            list.remove(list.size() - 1);
        }


    }

    private static boolean isAvailable() {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("(")) {
                stack.push("(");
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
