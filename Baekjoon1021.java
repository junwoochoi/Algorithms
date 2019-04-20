package Algorithms;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/1021
 */
public class Baekjoon1021 {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] answer = new int[M];
        int[] arr = new int[M];
        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }
        for (int i = 0; i < M; i++) {
            answer[i] = sc.nextInt();
        }

        int cnt = 0;
        int index = 0;
        while (arr[M - 1] == 0) {
            if (deque.peekFirst() == answer[index]) {
                arr[index] = deque.removeFirst();
                index++;
            } else {
                int position = deque.indexOf(Integer.valueOf(answer[index]));
                // 오른쪽으로 이동이 유리함.
                if (position < deque.size() + 1 - position) {
                    deque.offerLast(deque.pollFirst());
                } else {
                    //왼쪽으로 이동이 유리
                    deque.offerFirst(deque.pollLast());
                }
                cnt++;
            }
        }

        System.out.println(cnt);
    }

}
