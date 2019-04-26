package Algorithms;

import java.util.Arrays;
import java.util.HashSet;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12981
 * 영어 끝말잇기
 */
public class EnglishEndword {
    public static void main(String[] args) {
        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};

        System.out.println(Arrays.toString(solution(n, words)));
    }

    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        HashSet<String> usedBefore = new HashSet<>();
        usedBefore.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            int beforeSetSize = usedBefore.size();
            usedBefore.add(words[i]);
            char lastWordEndCharacter = words[i-1].charAt(words[i-1].length()-1);
            if (usedBefore.size() == beforeSetSize || lastWordEndCharacter != words[i].charAt(0)) {
                int personNumber = (i % n) + 1;

                answer[0] = personNumber;
                answer[1] = (i / n) + 1;
                return answer;
            }
        }
        return answer;
    }
}