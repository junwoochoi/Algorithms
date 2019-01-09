package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://algospot.com/judge/problem/read/JUMPGAME#
 * 점프게임 알고스팟
 */
public class JumpGame {


    static int cache[][] = new int[100][100];
    static int board[][] = new int[100][100];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            checkIfPossible(br);
        }
    }

    private static void checkIfPossible(BufferedReader br) throws IOException {
        int length = Integer.parseInt(br.readLine());
        board = new int[length][length];


        for (int i = 0; i < length; i++) {
            Arrays.fill(cache[i], -1);
            StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
            int j = 0;
            while (st.hasMoreTokens()) {
                board[i][j++] = Integer.parseInt(st.nextToken());
            }
        }

        //해당 숫자의 자리에 value가 존재하는 지 확인, 배열의 길이보다 크면 더이상 실행안함.

        String answer = checkIndex(board, 0, 0) ? "YES" : "NO";

        System.out.println(answer);

    }

    private static boolean checkIndex(int[][] board, int i, int j) {
        if (i >= board.length || j >= board.length) {
            return false;
        }
        if(cache[i][j] == 1) {
            return false;
        }
        if (board[i][j] == 0) {
            return true;
        }
        else cache[i][j] = 1;

        int moveIndex = board[i][j];

        return checkIndex(board, i + moveIndex, j) || checkIndex(board, i, j + moveIndex);
    }
}
