package algo.Algorithms;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/5585
 * 백준 5585번 문제
 * 거스름돈
 */
public class Bakjoon5585 {
    public static void main(String[] args) {
        int[] currency = {500, 100, 50, 10, 5, 1};
        Scanner sc = new Scanner(System.in);

        int count = 0;
        int money = 1000 - sc.nextInt();
        for (int change : currency) {
            count += money / change;
            money %= change;
            if(money==0){
                break;
            }
        }

        System.out.println(count);
    }
}
