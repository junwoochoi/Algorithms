package Algorithms;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 들어온 스트링에 모든 알파벳이 사용되어있는지 확인하는 문제
 */
public class Pangram {
    private static int testCase = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        testCase = Integer.parseInt(sc.nextLine());
        String[] inputs = new String[testCase];

        for (int i = 0; i < testCase; i++) {
            inputs[i] = sc.nextLine();
        }


        System.out.println(isPangram(inputs));
    }

    private static String isPangram(String[] inputs) {
        char[] alphabets = new char[26];

        initAlphabets(alphabets);

        StringBuilder answerBuilder = new StringBuilder();

        for(String input : inputs){
            HashSet<Character> inputSet = new HashSet<>();

            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if(c == ' ') continue;
                if(!Character.isAlphabetic(c) ){
                    throw new IllegalArgumentException();
                }

                inputSet.add((char) c);
            }


            if(inputSet.size() == 26) {
                answerBuilder.append("1");
            } else {
                answerBuilder.append("0");
            }
        }

        return answerBuilder.toString();
    }

    private static void initAlphabets(char[] alphabets) {
        for (int i = 97; i < 97 + 26; i++) {
            alphabets[i-97] = (char) i;
        }
    }
}
