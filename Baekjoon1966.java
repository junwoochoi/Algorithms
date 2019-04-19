package Algorithms;

import java.util.*;

/**
 * https://www.acmicpc.net/problem/1966
 * 백준 1966 프린터 큐
 */
public class Baekjoon1966 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for (int i = 0; i < testCase; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] priority = new int[N];
            for (int j = 0; j < N; j++) {
                priority[j] = sc.nextInt();
            }
            solution(priority, N, M);
        }
    }

    private static void solution(int[] priority, int n, int m) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            queue.add(i);
        }


        int count = 0;
        loop1: while(!queue.isEmpty()){
            int current = queue.poll();
            for(int num : queue){
                if(priority[num]>priority[current]){
                    queue.add(current);
                    continue loop1;
                }
            }
            count++;
            if(current == m) break loop1;
        }

        System.out.println(count);
    }
}
