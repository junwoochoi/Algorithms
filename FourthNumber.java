package algo.Algorithms;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/2997
 * 백준 2997번 문제 네번째 수
 */
public class FourthNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int input[] = new int[3];

        input[0] = sc.nextInt();
        input[1] = sc.nextInt();
        input[2] = sc.nextInt();

        Arrays.sort(input);

        int diff1 = input[2] - input[1];
        int diff2 = input[1] - input[0];
        int diff = 0;

        if(diff1<diff2){
            diff = diff1;
            System.out.println(input[1]-diff);
        } else if(diff1>diff2){
            diff = diff2;
            System.out.println(input[2]-diff);
        } else {
            diff = diff1;
            System.out.println(input[2]+diff);
        }




        sc.close();
    }
}
