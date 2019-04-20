package Algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/5430
 * 백준 5430 AC
 */
public class Baekjoon5430 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            Deque<Integer> deque = new LinkedList<>();
            String functionList = br.readLine();
            int length = Integer.parseInt(br.readLine());
            String input = br.readLine().substring(1);
            if(length == 0){
                solution(functionList, deque);
                continue;
            }
            StringTokenizer st = new StringTokenizer(input.substring(0, input.length() - 1), ",");
            while(st.hasMoreTokens()){
                deque.add(Integer.parseInt(st.nextToken()));
            }

            solution(functionList, deque);
        }
    }

    private static void solution(String functionList, Deque<Integer> deque) {

        boolean isBackWord = false;
        for(char c : functionList.toCharArray()) {
            if(c == 'R'){
                isBackWord = !isBackWord;
            } else {
                if(deque.isEmpty()){
                    System.out.println("error");
                    return;
                }
                if(isBackWord){
                    deque.pollLast();
                } else {
                    deque.pollFirst();
                }
            }
        }
        if(isBackWord){
            int[] backward = new int[deque.size()];
            for (int i = 0; i < backward.length; i++) {
                backward[i] = deque.pollLast();
            }

            System.out.println(Arrays.toString(backward).replaceAll(" ",""));
            return;
        }
        System.out.println(deque.toString().replaceAll(" ", ""));
    }
}
