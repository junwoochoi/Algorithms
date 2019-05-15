package Algorithms;

import java.util.Arrays;
import java.util.Vector;

public class RideTaxi {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 4, 2, 2};
        int[] arr2 = {2, 3, 4, 4, 2, 1, 3, 1};
        int[] arr3 = {1, 2, 4, 3, 3};
        int[] arr4 = {1, 1, 1, 1, 2, 3, 4};
        int[] arr5 = {1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 4};
        System.out.println(solution(arr));
        System.out.println(solution(arr2));
        System.out.println(solution(arr3));
        System.out.println(solution(arr4));
        System.out.println(solution(arr5));
    }

    public static int solution(int[] s) {

        Arrays.sort(s);

        Vector<Integer> vector = new Vector<>();
        for (int i = s.length - 1; i >= 0; i--) {
            boolean isGetin = false;
            for (int j = 0; j < vector.size(); j++) {
                if (vector.get(j) + s[i] <= 4) {
                    vector.set(j, vector.get(j) + s[i]);
                    isGetin = true;
                    break;
                }
            }
            if (!isGetin) {
                vector.add(s[i]);
            }
        }


        return vector.size();
    }

}
