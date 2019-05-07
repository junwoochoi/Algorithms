package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/9466
 * 백준 9466번 텀 프로젝트
 */
public class Baekjoon9466 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] students;
    private static boolean[] visited;
    private static boolean[] done;
    private static int cnt;

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            int studentNumber = Integer.parseInt(br.readLine());
            //입력받는 학생 값
            students = new int[studentNumber + 1];
            //끝까지 확인했는 지 확인
            done = new boolean[studentNumber + 1];
            //방문 했는 지 확인
            visited = new boolean[studentNumber + 1];
            //사이클을 이루는 학생 수
            cnt = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= studentNumber; i++) {
                students[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= studentNumber; i++) {
                //방문하지 않았으면 방문
                if (!visited[i]) {
                    visited[i] = true;
                    dfs(i);
                }
            }

            System.out.println(studentNumber-cnt);
        }
    }

    private static void dfs(int student) {
        int nextStudent = students[student];
        //다음 학생이 이미 방문을 하였고,
        if (visited[nextStudent]) {
            //아직 done이 아니면( 안 끝났는데 다시 돌아왔으므로, 사이클을 이루는 것임)
            if (!done[nextStudent]) {
                //한바퀴 더 돌면서 사이클을 이루는 학생 수 카운트
                for (int x = nextStudent; student != x; x = students[x]) {
                    cnt++;
                }
                //자기 자신까지 카운트
                cnt++;
            }
        } else {
            //방문처리
            visited[nextStudent] = true;
            dfs(nextStudent);
        }

        done[student] = true;
    }

}
