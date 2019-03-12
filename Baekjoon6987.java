package algo.Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/6987
 * 백준 6987 월드컵
 */
public class Baekjoon6987 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] input = new int[6][3];
    static int[][] result;
    static boolean flag;
    static List<Integer> printList = new ArrayList<>();

    static final Integer WIN = 0;
    static final Integer DRAW = 1;
    static final Integer LOSE = 2;

    public static void main(String[] args) throws IOException {
        inputLoop:
        for (int i = 0; i < 4; i++) {
            flag = false;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            result = new int[6][3];
            input = new int[6][3];
            for (int x = 0; x < 6; x++) {
                int sum = 0;
                for (int y = 0; y < 3; y++) {
                    input[x][y] = Integer.parseInt(st.nextToken());
                    sum += input[x][y];
                }
                if (sum != 5) {
                    printList.add(0);
                    continue inputLoop;
                }
            }
            solution(0, 1, 0);
            if (flag) {
                printList.add(1);
            } else {
                printList.add(0);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int answer : printList) {
            sb.append(answer);
            sb.append(" ");
        }
        System.out.println(sb.toString().trim());

    }

    private static void solution(int team1, int team2, int game) {
        if (team1== 6) {
            flag = true;
            return;
        }

        if (team2 == 6) {
            if (check(team1)) {
                solution(team1 + 1, team1 + 2, game + 1);
            }
            return;
        }

        //team1 승리
        input[team1][WIN]--;
        input[team2][LOSE]--;

        solution(team1, team2 + 1, game + 1);

        //위에서 바꾼값 초기화
        input[team1][WIN]++;
        input[team2][LOSE]++;


        if (flag)
            return;

        //team1 무승부
        input[team1][DRAW]--;
        input[team2][DRAW]--;

        solution(team1, team2+1, game + 1);

        input[team1][DRAW]++;
        input[team2][DRAW]++;

        if (flag)
            return;


        //team1패배
        input[team1][LOSE]--;
        input[team2][WIN]--;

        solution(team1, team2+1, game+1);

        input[team1][LOSE]++;
        input[team2][WIN]++;

        if(flag)
            return;


    }

    private static boolean check(int team) {
        if (input[team][WIN] != 0 || input[team][DRAW] != 0 || input[team][LOSE] != 0) {
            return false;
        }
            return true;
        }
    }


