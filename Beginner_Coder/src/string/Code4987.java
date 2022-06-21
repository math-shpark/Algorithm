package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Code4987 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		String a = st.nextToken(); // A
		String b = st.nextToken(); // B

		String result = "";
		while (true) {
			String str = br.readLine(); // new string

			if (str.equals(a)) {
				System.out.println(result); // print
				break;
			}

			if (str.length() == 3) {
				result += str; // Case 1. String length 3
			} else if (str.length() >= 3 + b.length()) {
				String part = str.substring(3, 3 + b.length());
				if (part.equals(b)) {
					if (str.subSequence(0, b.length()).equals(b) || str.subSequence(1, 1 + b.length()).equals(b)
							|| str.subSequence(2, 2 + b.length()).equals(b))
						continue;
					result += str;
				}
			}

		}
	}

}
