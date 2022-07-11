package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Code1836 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine()); // N
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} // data input

		int maxSum = -1;
		int temp = 0;

		for (int i = 0; i < n; i++) {
			temp += arr[i];
			if (temp > maxSum)
				maxSum = temp;
			if (temp < 0)
				temp = 0;
		}

		System.out.println(maxSum);
	}

}
