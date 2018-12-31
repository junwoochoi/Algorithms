package algo;

import java.util.Scanner;
import java.util.Vector;

public class JWAPattern {

	
	public static String getDate(int num,Vector<String> yearVector,Vector<String> dateVector) {
		StringBuffer sb = new StringBuffer();
		
		
		int check = num -1 ;

		int yearIndex = check / 10;
		int dateIndex = (check % 10);
		String reverseDate = new StringBuffer(dateVector.get(dateIndex)).reverse().toString();
		String reverseYear = new StringBuffer(yearVector.get(yearIndex)).reverse().toString();
		sb.append(yearVector.get(yearIndex)).append(dateVector.get(dateIndex)).append(reverseDate.substring(2,4)).append(reverseYear);
		
		sb.insert(12, ":").insert(10, ":").insert(8, " ").insert(6, "-").insert(4, "-");
		return sb.toString();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		Vector<String> yearVector = new Vector<>();
		 Vector<String> dateVector = new Vector<>();
		 
		 for (int i = 2000; i < 4464; i++) {
				String yearStr = String.valueOf(i);
				if (yearStr.matches("[2-9][0-5][0-9][0-5]")) {
					yearVector.add(yearStr);
				}
			}

			for (int j = 1; j < 13; j++) {
				String monStr = String.valueOf(j);
				if (j < 10) {
					monStr = "0" + monStr;
				}

				if (monStr.matches("[0-1][0-2]")) {
					dateVector.add(monStr+"11");
					dateVector.add(monStr+"22");
				}
			}
			
		int count = Integer.parseInt(sc.nextLine());
		String[] arr = new String[count];
		for(int i=0;i<count;i++) {
			int num = Integer.parseInt(sc.nextLine());
			arr[i]= getDate(num, yearVector, dateVector);
		}
		for(String str: arr) {			
			System.out.println(str);
		}

	}
}
