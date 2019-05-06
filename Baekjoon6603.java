package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/6603
 * 백준 6603번 로또
 */
public class Baekjoon6603 {
    private static int[] numbers;
    private static int[] combi;
    private static StringBuilder
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        while (!input.equals("0")) {
            StringTokenizer st = new StringTokenizer(input);
            int length = Integer.parseInt(st.nextToken());
            numbers = new int[length];
            combi = new int[length];


            for (int i = 0; i < length; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            lotto(0, 0);


            input = br.readLine();
        }
    }

    private static void lotto(int num, int depth) {
        if(depth == 6) {                    //탈출조건
            for(int i=0; i<6; i++) {
                //조합하나를 출력한 뒤 탈출
            }

            return;
        }

        for(int i=num; i<k; i++) {    //lotto배열 0부터 k-1까지 탐색함
            combi[depth] = numbers[i];    //depth는 깊이 -> 0~5번째 깊이까지 재귀를통해 새로 탐색한 숫자를 넣음.
            lotto(i+1, depth+1);            //재귀 들어가는 부분 , 하나의 깊이를 탐색 후 저장했으니 다음 함수호출할때는 깊이+1을 해줘야함.
        }



    }
}
