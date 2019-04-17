package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/9012
 * 백준 9012번 괄호
 */
public class Baekjoon9012 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            solution(br.readLine());
        }
    }

    private static void solution(String input) {
        if(input.charAt(0) == ')' || input.charAt(input.length()-1) == '('){
            System.out.println("NO");
            return;
        }
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                continue;
            }

            if (c == ')' && !stack.isEmpty()) {
                stack.pop();
            } else {
                System.out.println("NO");
                return;
            }
        }
        if(!stack.isEmpty()){
            System.out.println("NO");
            return;
        }
        System.out.println("YES");
    }
}
