package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Code3699 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine()); // test case

		for (int t = 0; t < tc; t++) {
			int count = Integer.parseInt(br.readLine()); // the number of clothes
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			StringTokenizer st;

			for (int i = 0; i < count; i++) {
				st = new StringTokenizer(br.readLine());
				String name = st.nextToken();
				String category = st.nextToken();

				if (map.containsKey(category)) {
					map.put(category, map.get(category) + 1);
				} else {
					map.put(category, 1);
				}
			}

			Object[] keyArr = map.keySet().toArray(); // key array

			int result = 1;

			for (Object key : keyArr) {
				result *= map.get(key) + 1;
			}

			System.out.println(result - 1);
		}
	}

}
