package algo.Algorithms;

import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/17681
 * 카카오 2017 기출문제 비밀지도 ( 난이도 하 )
 */
public class SecretMap {
    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = { 9, 20, 28, 18, 11};
        int[] arr2 = { 30, 1, 21, 17, 28};

        System.out.println(Arrays.toString(solution(n,arr1,arr2)));
    }
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        boolean[][] map = new boolean[n][n];
        getBooleanMap(n, arr1, arr2, map);


        for(int i=0; i<n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<n;j++){
                if(map[i][j]){
                    sb.append("#");
                    continue;
                }
                sb.append(" ");
            }
            answer[i] = sb.toString();
        }




        return answer;
    }

    private static void getBooleanMap(int n, int[] arr1,int[] arr2, boolean[][] map) {
        for(int i=0; i<n; i++){
            String binaryString = Integer.toBinaryString(arr1[i]| arr2[i]);
            int j=0;
            while (binaryString.length()<n){
                binaryString = "0"+binaryString;
            }

            for(char c : binaryString.toCharArray()){
                if(c == '1'){
                    map[i][j] = true;
                } else {
                    map[i][j] = false;
                }
                j++;
            }

        }
    }
}
