package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://algospot.com/judge/problem/read/ITES
 * 
 * @author jwoochoi
 */
public class ITES {

	public static class LCG {
		static final long mask = 1024L * 1024L * 1024L * 4L - 1L;
		long seed = 1983;

		public long next() {
			long ret = seed % 10000 + 1;
			seed = (seed * 214013 + 2531011) & mask;
			return ret;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int caseCount = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < caseCount; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			long k = Long.parseLong(st.nextToken());
			long n = Long.parseLong(st.nextToken());

			Queue<Long> queue = new LinkedList<Long>();

			long sum = 0;
			int answer = 0;
			LCG rand = new LCG();
			for (int j = 1; j < n; j++) {

				long signal = rand.next();

				queue.add(signal);
				sum += signal;

				if (sum == k) {
					answer++;
					sum -= queue.poll();
					continue;
				}
				while (sum > k) {
					sum -= queue.poll();
				}
				if (sum == k) {
					answer++;
				}

			}
			sb.append(answer);
			if (i != caseCount) {
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}

}
