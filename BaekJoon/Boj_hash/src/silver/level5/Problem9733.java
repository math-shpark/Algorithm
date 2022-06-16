package silver.level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem9733 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] opList = { "Re", "Pt", "Cc", "Ea", "Tb", "Cm", "Ex" }; // operation list
		int[] count = new int[7]; // operation count

		double total = 0; // total operation number
		String data = "";

		while ((data = br.readLine()) != null) {
			String[] arr = data.split(" ");
			total += arr.length;

			for (int i = 0; i < arr.length; i++) {
				String op = arr[i];
				for (int j = 0; j < 7; j++) {
					if (op.equals(opList[j])) {
						count[j]++;
						break;
					}
				}
			}
		}

		for (int i = 0; i < 7; i++) {
			System.out.printf("%s %d %.2f\n", opList[i], count[i], count[i] / total);
		}

		System.out.printf("%s %d %.2f\n", "Total", (int) total, 1.00);
	}

}
