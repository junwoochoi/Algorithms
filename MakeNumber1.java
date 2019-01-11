package algo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/1463
 * 백준 1463번문제 1로 만들기
 */
public class MakeNumber1 {
    static int[] cache = new int[10000001];
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();


        makeCache(num);
        System.out.println(cache[num]);
        sc.close();
    }

    private static void makeCache(int num) {
        cache[2] = 1;
        cache[3] = 1;
        for(int i=4; i<=num; i++){
            int compareNum = -1;
            if(i % 2 == 0){
                compareNum = i/2;
            }
            if(i % 3 == 0){
                compareNum = i/3;
            }
            cache[i] = (compareNum == -1) ? cache[i-1]+1 : Math.min(cache[compareNum], cache[i-1])+1;

        }

    }


}
