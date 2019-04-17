package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10828
 * 백준 10828번 스택 구현
 */
public class Baekjoon10828 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Stack stack = new Stack();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    System.out.println(stack.pop());
                    break;
                case "empty":
                    System.out.println(stack.empty());
                    break;
                case "top":
                    System.out.println(stack.top());
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                default:
                    continue;
            }
        }
    }


    public static class Stack {
        private List<Integer> list = new ArrayList<>();

        public void push(Integer num) {
            list.add(num);
        }

        public int pop() {
            if (empty() == 1) return -1;
            Integer num = list.get(list.size()-1);
            list.remove(list.size()-1);

            return (int) num;
        }

        public int size() {
            return list.size();
        }

        public int empty() {
            return list.isEmpty() ? 1 : 0;
        }

        public int top() {
            if (list.isEmpty()) {
                return -1;
            }
            return (int) list.get(list.size()-1);
        }


    }
}
