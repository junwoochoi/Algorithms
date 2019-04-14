package Algorithms;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/2292
 * 백준 벌집 2292번
 */
public class Baekjoon2292 {
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        int num = sc.nextInt();
        int temp = 1;
        int count =1;

        for (int i = 0; i < num; i++) {
            if(temp == 0){
                temp = 6 * count++;
            }
            temp--;
        }


        System.out.println(count);

    }
}
