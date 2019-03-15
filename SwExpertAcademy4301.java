package algo.Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SwExpertAcademy4301 {
    static int R, C;
    static int deleteCount = 0;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static int num = 1;

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            solution();
        }
    }

    private static void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        deleteCount = 0;
        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] == 0){
                    if(i+2<R && map[i+2][j] != -1){
                        deleteCount++;
                        map[i+2][j] = -1;
                    }
                    if(j+2<C &&map[i][j+2] != -1){
                        deleteCount++;
                        map[i][j+2] = -1;
                    }
                }
            }
        }

        System.out.println("#" + num + " " + (R * C - deleteCount));
        num++;
    }



}
