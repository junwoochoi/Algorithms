package algo.Algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43165?language=java
 * 프로그래머스 타겟 넘버 문제
 */
public class TargetNumber {
    static int count = 0;

    public static void main(String[] args) {
        int[] numbers = { 1, 1, 1, 1, 1};
        int target = 3;

        int retrunNumber = solution(numbers, target);
        System.out.println(retrunNumber);
    }

    private static int solution(int[] numbers, int target) {

        dfs(numbers, 0, 0, target);

        return count;
    }

    private static void dfs(int[] numbers, int index,int sum, int target) {
        if(index==numbers.length) {
            if(sum ==target) count++;
            return;
        }



        dfs(numbers, index+1, sum+numbers[index], target);

        dfs(numbers, index+1, sum-numbers[index], target);
    }
}
