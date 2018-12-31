package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Insertion {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<count; i++) {
			int length = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] answer = new int[length];
			int[] paramArr = new int[length];
			List<Integer> numArr = new ArrayList<>();
			int j=0;
			while(st.hasMoreTokens()) {
				paramArr[length-j-1] = Integer.parseInt(st.nextToken());
				j++;
				numArr.add(j);
			}
			for(int param : paramArr) {
				answer[numArr.size()-1]=numArr.get(numArr.size()-param-1);
				numArr.remove(numArr.size()-param-1);
			}
			sb.append(Arrays.toString(answer).substring(1,Arrays.toString(answer).length()-1).replaceAll(",", ""));
			if(i!=count-1) {
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}
