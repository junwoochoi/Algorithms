package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 * https://www.acmicpc.net/problem/10845
 * 백준 10845번 큐 구현
 */
public class Baekjoon10845 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Queue queue = new Queue();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    queue.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    System.out.println(queue.pop());
                    break;
                case "empty":
                    System.out.println(queue.empty());
                    break;
                case "front":
                    System.out.println(queue.front());
                    break;
                case "back":
                    System.out.println(queue.back());
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                default:
                    continue;
            }
        }
    }


    private static class Queue {
        private Vector<Integer> list = new Vector<>();

        public void push(Integer num) {
            list.add(num);
        }

        public int pop() {
            if (empty() == 1) return -1;
            Integer num = list.get(0);
            list.remove(0);

            return num;
        }

        public int size() {
            return list.size();
        }

        public int empty() {
            return list.isEmpty() ? 1 : 0;
        }

        public int front() {
            if (list.isEmpty()) {
                return -1;
            }
            return list.get(0);
        }

        public int back(){
            if (list.isEmpty()) {
                return -1;
            }
            return list.get(list.size()-1);
        }


    }
}
