package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/1874
 * 백준 1874 스택 수열
 */
public class Baekjoon1874 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] inputs = new int[n];
        int[] outputs = new int[n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
        }

        Arrays.fill(outputs, -1);

        StringBuilder sb = new StringBuilder();
        int i = 1;
        while (outputs[n - 1] == -1) {
            if(stack.size()>n){
                System.out.println("NO");
                return;
            }
            stack.push(i++);
            sb.append("+").append("\n");

            while (!stack.isEmpty() && stack.peek() == inputs[j]) {
                outputs[j++] = stack.pop();
                sb.append("-").append("\n");
            }

        }

        System.out.println(sb.toString());
    }

}
