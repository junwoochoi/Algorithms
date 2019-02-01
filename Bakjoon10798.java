package algo.Algorithms;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * https://www.acmicpc.net/problem/10798
 * 백준 세로읽기 10798번
 */
public class Bakjoon10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = new String[5];
        for (int i = 0; i < 5; i++) {
            inputs[i] = br.readLine();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (inputs[j].length() > i) {
                    sb.append(inputs[j].charAt(i));
                }
            }
        }
        System.out.println(sb.toString());
    }
}
