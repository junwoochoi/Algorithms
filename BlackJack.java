package algo.Algorithms;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/2798
 * 백준 2798번 문제 블랙잭
 */
public class BlackJack {
    private static int n;
    private static int m;
    private static int answer;
    private static int cards[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        cards = new int[n];

        for (int i = 0; i < n; i++) {
            cards[i] = sc.nextInt();
        }

        findMaxSum(0, 0, 0);

        System.out.println(answer);

    }

    private static void findMaxSum(int index, int sum, int count) {
        if (sum > m) {
            return;
        }
        if(index>=n){
            return;
        }
        if(count == 3){
            answer = Math.max(answer, sum);
            return;
        }



        findMaxSum(index+1, sum+cards[index], count+1);
        findMaxSum(index+1, sum, count);
    }


}
