package algo.Algorithms;

import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42889?language=java
 * 2018 카카오 블라인드 테스트
 * 실패율 문제
 */
public class FailRate {
    public static void main(String[] args) {
        FailRate failRate = new FailRate();
        int[] stages = {3,5,1,2,3,5,7};
        failRate.solution(8,  stages);
    }

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        List<Integer> list = new ArrayList<>();
        int[] reachedArray = new int[N + 1];
        int[] stuckArray = new int[N + 1];
        double[] failRateArray = new double[N+1];
        int count = 0;
        for (int stage : stages) {
            if (stage >= 1) {
                count++;
            }
        }
        reachedArray[1] = count;

        for(int i=1; i<=N; i++){
            list.add(i);
            int stuckCount = 0;
            for(int stage : stages){
                if(stage==i){
                    stuckCount++;
                }
            }
            stuckArray[i] = stuckCount;
            failRateArray[i] = stuckArray[i] / (double) reachedArray[i];
            if(reachedArray[i] == 0){
                failRateArray[i] = 0;
            }
            if(i!=N){
                reachedArray[i+1] = reachedArray[i]-stuckArray[i];
            }
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Double.compare(failRateArray[o2], failRateArray[o1]);
            }
        });


        for(int i=0; i<N; i++){
            answer[i] = list.get(i);
        }


        return answer;
    }
}
