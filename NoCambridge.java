package algo.Algorithms;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/2789
 * 백준 2789번 문제
 */
public class NoCambridge {

    private static final String CAMBRIDGE = "CAMBRIDGE";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        for(int i=0; i<CAMBRIDGE.length(); i++){
            str = str.replaceAll(CAMBRIDGE.substring(i,i+1),"");
        }

        System.out.println(str);

    }
}
