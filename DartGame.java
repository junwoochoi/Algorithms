package algo.Algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/17682
 * 카카오 2017 다트게임 ( 난이도 하 )
 */
public class DartGame {
    public static void main(String[] args) {
        System.out.println(solution("1D2S#10S"));
    }

    public static int solution(String dartResult) {
        int answer = 0;
        Queue<Character> queue = new LinkedList<Character>();
        Queue<Character> calculateQueue = new LinkedList<Character>();
        int scores[] = new int[3];
        for (char c : dartResult.toCharArray()) {
            queue.add(c);
        }


        int i = 0;
        while (!queue.isEmpty()) {
            boolean isNumTen = false;
            calculateQueue.add(queue.poll());
            calculateQueue.add(queue.poll());
            if(((LinkedList<Character>) calculateQueue).peekLast()== 48){
                calculateQueue.add(queue.poll());
                isNumTen = true;
            }

            if (!queue.isEmpty()) {
                if (queue.peek() == '#' || queue.peek() == '*') {
                    calculateQueue.add(queue.poll());
                }
            }


            if(isNumTen){
                scores[i] = 10;
                calculateQueue.poll();
                calculateQueue.poll();
            } else {
                scores[i] = (int) calculateQueue.poll() - 48;
            }


            char scope1 = calculateQueue.poll();
            switch (scope1) {
                case 'S':
                    scores[i] = (int) Math.pow(scores[i], 1);
                    break;
                case 'D':
                    scores[i] = (int) Math.pow(scores[i], 2);
                    break;
                case 'T':
                    scores[i] = (int) Math.pow(scores[i], 3);
                    break;
            }
            if (calculateQueue.isEmpty()) {
                i++;
                continue;
            }

            if (calculateQueue.poll() == '*') {
                if (i > 0) {
                    scores[i - 1] *= 2;
                }
                scores[i] *= 2;
            } else {
                scores[i] *= -1;
            }
            i++;
        }

        answer = scores[0] + scores[1] + scores[2];

        return answer;
    }
}
