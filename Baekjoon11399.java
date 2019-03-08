package algo.Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] numbers = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<num; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);
        int answer = 0;
        for(int i=0; i<num; i++){
            int time = 0;
            for(int j=i; j>=0;j--){
                time += numbers[j];
            }
            answer += time;
        }

        System.out.println(answer);
    }
}
