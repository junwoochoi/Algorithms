package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 * https://www.acmicpc.net/problem/10866
 * 백준 덱 구
 */
public class Baekjoon10866 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Deque deque = new Deque();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push_front":
                    deque.push_front(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deque.push_back(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_back":
                    System.out.println(deque.pop_back());
                    break;
                case "pop_front":
                    System.out.println(deque.pop_front());
                    break;
                case "empty":
                    System.out.println(deque.empty());
                    break;
                case "front":
                    System.out.println(deque.front());
                    break;
                case "back":
                    System.out.println(deque.back());
                    break;
                case "size":
                    System.out.println(deque.size());
                    break;
                default:
                    continue;
            }
        }
    }


    public static class Deque {
        private Vector<Integer> list = new Vector<>();

        public void push_back(Integer num) {
            list.add(num);
        }

        public void push_front(Integer num) {
            list.add(0, num);
        }

        public int pop_front() {
            if (empty() == 1) return -1;
            Integer num = list.get(0);
            list.remove(0);

            return num;
        }

        public int pop_back() {
            if (empty() == 1) return -1;
            Integer num = list.get(list.size() - 1);
            list.remove(list.size() - 1);

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

        public int back() {
            if (list.isEmpty()) {
                return -1;
            }
            return list.get(list.size() - 1);
        }


    }
}


