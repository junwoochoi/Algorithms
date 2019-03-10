package algo.Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1759
 * 백준 1759 암호구하기
 */
public class Baekjoon1759 {
    static List<Character> alphabetList = new ArrayList<>();
    static List<Character> nounList = new ArrayList<>();
    static List<String> answerList = new ArrayList<>();
    static int L, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        nounList.add('a');
        nounList.add('e');
        nounList.add('i');
        nounList.add('o');
        nounList.add('u');


        for (int i = 0; i < 26; i++) {
            alphabetList.add(Character.toLowerCase(new Character((char) (65 + i))));
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        char[] inputs = new char[C];

        st = new StringTokenizer(br.readLine(), " ");

        int i = 0;
        while (st.hasMoreTokens()) {
            inputs[i++] = st.nextToken().charAt(0);
        }


        Arrays.sort(inputs);
        List<Character> answer = new ArrayList<>();
        findAll(inputs, answer, 0);




        for(String str : answerList){
            if(isPassCondition(str)) System.out.println(str);
        }
    }

    private static boolean isPassCondition(String str) {
        int nounCount = 0;
        int count = 0;

        for(char c : str.toCharArray()){
            if(nounList.contains(c)) nounCount++;
            else count++;
        }

        if(nounCount > 0 && count>1) return true;

        return false;
    }

    private static void findAll(char[] inputs, List<Character> answer, int index) {
        if(answer.size() == L){
            StringBuilder sb = new StringBuilder();
            for(char c : answer){
                sb.append(c);
            }
            answerList.add(sb.toString());
            return;
        }

        if(index>=C) return;

        List<Character> chooseThis = new ArrayList<>();
        chooseThis.addAll(answer);

        chooseThis.add(inputs[index]);

        findAll(inputs, chooseThis, index+1);
        findAll(inputs, answer, index+1);

    }

    private static boolean checkCondition(List<Character> answer) {
        int nounCount = 0;
        int consonantCount = 0;
        for (char noun : nounList) {
            if (answer.contains(noun)) nounCount++;
            else consonantCount++;
        }
        if (nounCount > 0 && consonantCount > 1) return true;

        return false;
    }
}
