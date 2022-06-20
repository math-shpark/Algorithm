package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Code1880 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String key = br.readLine();
		char[] arr = new char[26];
		arr = key.toCharArray();

		String str = br.readLine(); // secret
		char[] origin = new char[str.length()]; // original sentence

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			int idx = 0;

			if (c >= 'A' && c <= 'Z') {
				idx += c - 'A';
				origin[i] = (char) (arr[idx] - 'a' + 'A');
			} else if (c >= 'a' && c <= 'z') {
				idx += c - 'a';
				origin[i] = arr[idx];
			} else {
				origin[i] = ' ';
			}
		}

		String result = "";
		for (int i = 0; i < origin.length; i++) {
			result += origin[i];
		}

		System.out.println(result);

	}

}
