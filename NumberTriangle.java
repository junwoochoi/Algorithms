package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Vector;

public class NumberTriangle {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int lineCount = Integer.parseInt(br.readLine());
		Vector<Vector<Integer>> sumVector = new Vector<>();
		Vector<Integer> initVector = new Vector<Integer>();
		initVector.add(Integer.parseInt(br.readLine()));
		sumVector.add(initVector);
		for(int i=1; i<lineCount; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			Vector<Integer> tempVector = new Vector<>();
			Vector<Integer> beforeVector = sumVector.get(i-1);
			int j = 0;
			
			while(st.hasMoreTokens()) {
				int num = Integer.parseInt(st.nextToken());
				if(j==0) {
					tempVector.add(num+beforeVector.get(j));
				} else if(j==i) {
					tempVector.add(num+beforeVector.get(j-1));
				} else {
					int higher = Math.max(beforeVector.get(j), beforeVector.get(j-1));
					tempVector.add(higher+num);
				}				
				j++;
			}
			sumVector.add(tempVector);
 		}
		System.out.println(Collections.max(sumVector.get(lineCount-1)));
		
	}
}
