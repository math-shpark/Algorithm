package silver.level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Problem18511 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n, k;
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		HashSet<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < k; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}

		boolean isFind = false;

		while (!isFind) {
			int num = n;

			isFind = true;

			while (num > 0) {
				int temp = num % 10;
				if (!set.contains(temp)) {
					isFind = false;
					break;
				}
				num /= 10;
			}

			if (isFind)
				break;
			else
				n--;
		}

		System.out.println(n);

	}

}
