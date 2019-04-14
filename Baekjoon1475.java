package Algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/1475
 * 백준 방번호 1475번
 */
public class Baekjoon1475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            map.put(i, 0);
        }

        for (char c : number.toCharArray()) {
            int n = c - '0';
            if (n == 6 || n == 9) {
                if (map.get(6) <= map.get(9)) {
                    n = 6;
                } else {
                    n = 9;
                }
            }
            map.put(n, map.get(n) + 1);
        }
        int answer = 0;

        for(int value  : map.values()){
            answer = Math.max(answer, value);
        }

        System.out.println(answer);


    }
}
