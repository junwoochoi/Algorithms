package algo.Algorithms;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/9625
 * 백준 9625번 문제 BABBA
 */
public class BABBA {
    public static void main(String[] args) {
        int A[] = new int[46];
        int B[] = new int[46];

        A[0] = 1;
        B[0] = 0;
        for(int i=1; i<46; i++){
            A[i] = B[i-1];
            B[i] = A[i-1] + B[i-1];
        }
        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();


        System.out.println(A[input]+" "+B[input]);
        sc.close();
    }
}
