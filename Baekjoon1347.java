package algo.Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1347
 * 백준 1347 미로만들기
 */
public class Baekjoon1347 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String[][] map = new String[102][102];
    static int currentPositionX = 50;
    static int currentPositionY = 50;
    static int currentLookAt = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        br.readLine();
        String input = br.readLine();

        Queue<String> queue = new LinkedList<>();


        for (int i = 0; i < input.length(); i++) {
            queue.add(String.valueOf(input.charAt(i)));
        }
        map[currentPositionX][currentPositionY] = ".";

        while (!queue.isEmpty()) {
            String current = queue.poll();


            if ("R".equals(current)) {
                currentLookAt += 1;
                if (currentLookAt == 4) {
                    currentLookAt = 0;
                }
                continue;
            }

            if ("L".equals(current)) {
                currentLookAt -= 1;
                if (currentLookAt == -1) {
                    currentLookAt = 3;
                }

                continue;
            }




            if ("F".equals(current)) {
                currentPositionX += dx[currentLookAt];
                currentPositionY += dy[currentLookAt];
                if (!".".equals(map[currentPositionX][currentPositionY]))
                    map[currentPositionX][currentPositionY] = ".";
            }
        }

        List<String> answer = new ArrayList<>();
        int length = 0;
        int C = 0;
        int startX = Integer.MAX_VALUE;
        int startY = Integer.MAX_VALUE;
        int endY = 0;
        for (int i = 0; i < 102; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 102; j++) {
                if (".".equals(map[i][j])) {
                    sb.append(map[i][j]);
                    startX = Math.min(startX, j);
                    C = Math.max(C, j);
                }
            }
            if (sb.length() > 0) {
                answer.add(sb.toString());
                length++;
                startY = Math.min(startY, i);
                endY = i;
            }
        }


        for (int i = startY; i < endY + 1; i++) {
            String[] strings = Arrays.copyOfRange(map[i], startX, C + 1);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < strings.length; j++) {
                if (".".equals(strings[j])) {
                    sb.append(".");
                } else {
                    sb.append("#");
                }
            }
            System.out.println(sb.toString());
        }


    }
}