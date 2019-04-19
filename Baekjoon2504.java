package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/2504
 * 백준 2504번 괄호의 값
 */
public class Baekjoon2504 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        if (input.charAt(0) == ')' || input.charAt(0) == ']' || input.charAt(input.length() - 1) == '(' || input.charAt(input.length() - 1) == '[') {
            System.out.println(0);
            return;
        }
        Stack<Character> stack = new Stack();
        //가능한지 확인
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '(' || c == '[') stack.push(c);
            else {
                if (c == ')' && !stack.isEmpty()) {
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        System.out.println(0);
                        return;
                    }
                } else if (c == ']' && !stack.isEmpty()) {
                    if (stack.peek() == '[') {
                        stack.pop();
                    } else {
                        System.out.println(0);
                        return;
                    }
                }
            }

        }

        if (!stack.isEmpty()) {
            System.out.println(0);
            return;
        }





    }
}
