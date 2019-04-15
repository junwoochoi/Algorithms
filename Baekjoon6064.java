package Algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/6064
 * 백준 카잉달력
 */
public class Baekjoon6064 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        while (testCase-->0){
            int M = sc.nextInt();
            int N = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            solution(M, N, x, y );
        }
    }

    private static void solution(int m, int n, int x, int y) {
        int num = 1;
        int i = 1;
        int j = 1;
        while (i!=x){
            i++;
            j++;
            if(i==m+1) i=1;
            if(j==n+1) j=1;
            num++;
        }

        int count = num;
        int limit = lcm(m,n);
        while(j!=y){
            if(count>limit){
                System.out.println(-1);
                return;
            }
            j = (j+m)%n;
            if(j==0){
                j=n;
            }
            count+=m;
        }

        System.out.println(count);
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }


}
