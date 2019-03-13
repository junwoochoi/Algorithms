package algo.Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/3055
 * 백준 3055번 문제 탈출
 */
public class Baekjoon3055 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int R, C;
    static List<String[][]> inputs = new ArrayList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Node startPoint;
    static int answer = Integer.MAX_VALUE;
    static int[][] visited;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        String[][] input = new String[R][C];
        visited = new int[R][C];


        for (int i = 0; i < R; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                input[i][j] = String.valueOf(str.charAt(j));
                if (input[i][j].equals("S")) {
                    startPoint = new Node(i, j, 0);
                    input[i][j] = ".";
                }

            }
        }
        inputs.add(input);


        bfs();

        if(answer==Integer.MAX_VALUE)
            System.out.println("KAKTUS");
        else System.out.println(answer);

    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();

        queue.add(startPoint);
        visited[startPoint.x][startPoint.y] = startPoint.time;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            int x = current.x;
            int y = current.y;


            if (inputs.size() <= current.time + 1) {
                timePass(current.time);
            }

            String[][] map = inputs.get(current.time+1);
//            for (int i = 0; i < R; i++) {
//                StringBuilder sb = new StringBuilder();
//                for (int j = 0; j < C; j++) {
//                    sb.append(map[i][j]);
//                    sb.append(" ");
//                }
//                System.out.println(sb.toString());
//            }
            for (int i = 0; i < 4; i++) {
                int nX = dx[i] + x;
                int nY = dy[i] + y;

                if (nX < 0 || nY < 0 || nX >= R || nY >= C) continue;

                if (map[nX][nY].equals("*") || map[nX][nY].equals("X")) continue;

                if(visited[nX][nY] <= current.time+1) continue;

                visited[nX][nY] = current.time+1;
                queue.offer(new Node(nX, nY, current.time+1));

                if(map[nX][nY].equals("D")){
                    answer = Math.min(answer, current.time+1);
                }
            }
        }
    }

    private static void timePass(int time) {
        String[][] beforeArray = inputs.get(time);
        String[][] returnArray = deepCopy(inputs.get(time));
        for (int j = 0; j < R; j++) {
            for (int k = 0; k < C; k++) {
                if (beforeArray[j][k].equals("*")) {
                    moving:
                    for (int l = 0; l < 4; l++) {
                        int nX = dx[l] + j;
                        int nY = dy[l] + k;

                        if (nX < 0 || nY < 0 || nX >= R || nY >= C) continue moving;

                        if (beforeArray[nX][nY].equals("X") || beforeArray[nX][nY].equals("D")) continue moving;

                        returnArray[nX][nY] = "*";
                    }
                }
            }
        }
        inputs.add(time+1, returnArray);
    }

    public static String[][] deepCopy(String[][] original) {
        if (original == null) {
            return null;
        }

        final String[][] result = new String[original.length][];
        for (int i = 0; i < original.length; i++) {
            result[i] = Arrays.copyOf(original[i], original[i].length);
            // For Java versions prior to Java 6 use the next:
            // System.arraycopy(original[i], 0, result[i], 0, original[i].length);
        }
        return result;
    }


    static class Node {
        int x, y, time;

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

}
