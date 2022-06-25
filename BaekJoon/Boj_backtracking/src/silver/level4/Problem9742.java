package silver.level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem9742 {

	static char[] arr, temp;
	static boolean[] isUsed;
	static int order, now;
	static String result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			String data = br.readLine();

			if (data == null)
				break;

			st = new StringTokenizer(data);

			String str = st.nextToken(); // data
			arr = str.toCharArray();
			temp = new char[str.length()];
			isUsed = new boolean[str.length()];
			order = Integer.parseInt(st.nextToken()); // order
			now = 0;
			result = "";

			int maxPer = 1;

			for (int i = str.length(); i >= 1; i--) {
				maxPer *= i;
			}

			System.out.print(str + " " + order + " = ");

			if (maxPer < order) {
				System.out.println("No permutation");
			} else {
				permutation(0);
				System.out.println(result);
			}

		}

	}

	private static void permutation(int count) {

		if (count == arr.length) {
			now++;
			if (now == order) {
				for (int i = 0; i < temp.length; i++) {
					result += temp[i];
				}
			}
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (isUsed[i])
				continue;
			isUsed[i] = true;
			temp[count] = arr[i];
			permutation(count + 1);
			isUsed[i] = false;
		}

	}

}
