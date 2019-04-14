package Algorithms;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/2775
 * 백준 부녀회장이 될거야 2775번
 */
public class Baekjoon2775 {
    static int[][] house = new int[15][15];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        initHouse();

        while(T-->0){
            System.out.println(house[sc.nextInt()][sc.nextInt()]);
        }


    }

    private static void initHouse() {
        // 0층 입주
        for (int i = 1; i < 15; i++) {
            house[0][i] = i;
        }

        //나머지 층 계산
        for (int i = 1; i < 15; i++) {
            for (int j = 1; j < 15; j++) {
                int sum = 0;
                for(int k = 1; k<=j; k++){
                    sum += house[i-1][k];
                }

                house[i][j] = sum;
            }
        }
    }


}
