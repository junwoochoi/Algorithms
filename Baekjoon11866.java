package Algorithms;

import java.util.*;

/**
 * https://www.acmicpc.net/problem/11866
 * 백준 11866 조세퍼스 문제 0
 */
public class Baekjoon11866 {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int N = sc.nextInt();
        int K = sc.nextInt();
        List<Integer> josephus = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
        int position = 1;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (position % K != 0) {
                queue.add(current);
            } else {
                josephus.add(current);
            }
            position++;
        }

        System.out.println(josephus.toString().replace('[', '<').replace(']', '>'));
    }
}
