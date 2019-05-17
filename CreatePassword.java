package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 백준 1759번 암호만들기 다시 풀어보기
 */
public class CreatePassword {
    private static char[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        arr = new char[C];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);


        dfs(0, L, new StringBuilder());

    }

    private static void dfs(int depth, int length, StringBuilder sb) {
        if (sb.length() == length) {
            if (isAvailable(sb.toString(), length)) {
                System.out.println(sb.toString());
            }
            return;
        }

        if (depth >= arr.length) {
            return;
        }


        sb.append(arr[depth]);
        dfs(depth + 1, length, sb);

        sb.deleteCharAt(sb.length() - 1);

        dfs(depth + 1, length, sb);
    }

    private static boolean isAvailable(String string, int length) {
        List<Character> nounList = Arrays.asList('a', 'e', 'i', 'o', 'u');
        int count = 0;
        for (char c : string.toCharArray()) {
            if (nounList.contains(c)) {
                count++;
            }
        }

        if (count == 0 || length-count < 2)
            return false;


        return true;
    }
}
