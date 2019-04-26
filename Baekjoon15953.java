package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/15953
 * 백준 15953번 상금 헌
 */
public class Baekjoon15953 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] lastYearMoney = new int[101];
    private static int[] thisYearMoney = new int[65];

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());

        initMoney();

        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            System.out.println(solution(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
    }

    private static void initMoney() {
        initLastYearMoney();
        initThisYearMoney();
    }

    private static int solution(int a, int b) {

        int lastYear = lastYearMoney[a];
        int thisYear = thisYearMoney[b];



        return (lastYear + thisYear) * 10000;
    }

    private static void initLastYearMoney() {
        int[] money = { 500, 300, 200, 50, 30, 10};
        int temp = 1;
        int lastIndex = 1;
        for (int i = 0; i < money.length; i++) {
            for (int j = 0; j < temp; j++) {
                lastYearMoney[lastIndex++] = money[i];
            }
            temp++;
        }

    }

    private static void initThisYearMoney() {
        int money = 512;
        int temp = 1;
        int i = 1;
        while (i < 32) {
            for (int j = 0; j < temp; j++) {
                thisYearMoney[i + j] = money;
            }
            money /= 2;
            i += temp;
            temp *= 2;
        }

    }


}
