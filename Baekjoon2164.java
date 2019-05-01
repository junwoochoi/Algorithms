package Algorithms;

import java.util.*;

/**
 * https://www.acmicpc.net/problem/2164
 * 백준 2164번 카드2
 */
public class Baekjoon2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        sc.close();

        if(N==1){
            System.out.println(1);
            return;
        }
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }



        while(true){
            // 맨위에 카드 버림
            queue.poll();

            if(queue.size()==1){
                System.out.println(queue.peek());
                return;
            }

            //맨위에 카드 맨 아래로 옮김.
            queue.offer(queue.poll());

        }
    }
}
