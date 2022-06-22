package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Code5096 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 2; i++) {
			String str = br.readLine();
			String[] arr = str.split(" ");
			Arrays.sort(arr);

			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[j]);
				if (j == arr.length - 1)
					System.out.println();
				else
					System.out.print(" ");
			}
		}
	}

}
