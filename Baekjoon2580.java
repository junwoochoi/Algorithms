package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2580
 * 백준 2580 스도쿠
 */
public class Baekjoon2580 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] sudoku = new int[9][9];
    private static List<Node> shouldDecide = new ArrayList<>();
    private static boolean[] decided;
    private static boolean isPrinted = false;

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = Integer.parseInt(st.nextToken());
                if (sudoku[i][j] == 0) shouldDecide.add(new Node(i, j));
            }
        }

        decided = new boolean[shouldDecide.size()];

        for (int i = 1; i <= 9; i++) {
            if (isAvailable(i, 0)) {
                sudoku[shouldDecide.get(0).x][shouldDecide.get(0).y] = i;
                decided[0] = true;
                dfs(1);
                decided[0] = false;
                sudoku[shouldDecide.get(0).x][shouldDecide.get(0).y] = 0;
            }
        }


    }


    private static boolean isAvailable(int number, int indexOfShoudDecide) {
        int x = shouldDecide.get(indexOfShoudDecide).x;
        int y = shouldDecide.get(indexOfShoudDecide).y;
        for (int i = 0; i < 9; i++) {
            if (sudoku[x][i] == number || sudoku[i][y] == number) return false;
        }

        if (!checkSquare(x, y, number)) {
            return false;
        }


        return true;
    }

    public static boolean checkSquare(int r, int c, int num) {
        r = r / 3;
        c = c / 3;
        for (int rr = r * 3; rr < (r * 3) + 3; rr++) {
            for (int cc = c * 3; cc < (c * 3) + 3; cc++) {
                if (sudoku[rr][cc] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void dfs(int index) {
        if (index == shouldDecide.size()) {
            for (int i = 0; i < 9; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < 9; j++) {
                    sb.append(sudoku[i][j]).append(" ");
                }
                System.out.println(sb.toString().trim());
            }
            isPrinted = true;
            return;
        }

        if (isPrinted) return;

        for (int i = 1; i <= 9; i++) {
            if (isAvailable(i, index)) {
                sudoku[shouldDecide.get(index).x][shouldDecide.get(index).y] = i;
                decided[index] = true;
                dfs(index + 1);
                decided[index] = false;
                sudoku[shouldDecide.get(index).x][shouldDecide.get(index).y] = 0;
            }
        }
    }

    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
