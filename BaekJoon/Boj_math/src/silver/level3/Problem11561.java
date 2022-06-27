package silver.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem11561 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {
			long N = Long.parseLong(br.readLine());
			long start = 0;
			long last = (long) Math.sqrt((2 * N - 1));
			long result = 0;
			while (start <= last) {
				long mid = (start + last) / 2;
				long sum = (mid) * (mid + 1) / 2;
				if (sum <= N) {
					result = Math.max(mid, result);
					start = mid + 1;
				} else {
					last = mid - 1;
				}
			}
			System.out.println(result);

		}

	}

}
