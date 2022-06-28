package silver.level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Problem1302 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine()); // N
		HashMap<String, Integer> book = new HashMap<String, Integer>();

		for (int i = 0; i < n; i++) {
			String bookname = br.readLine();

			if (book.containsKey(bookname)) {
				book.put(bookname, book.get(bookname) + 1);
			} else {
				book.put(bookname, 1);
			}
		}

		int maxCount = 0;
		String result = "";

		Object[] keyArr = book.keySet().toArray();
		Arrays.sort(keyArr);

		for (Object key : keyArr) {
			if (book.get(key) > maxCount) {
				maxCount = book.get(key);
				result = (String) key;
			}
		}

		System.out.println(result);

	}

}
