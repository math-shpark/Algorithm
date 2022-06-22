package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Code1516 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String str = br.readLine();
			HashMap<String, Integer> map = new HashMap<String, Integer>();

			if (str.equals("END"))
				break;

			String[] arr = str.split(" ");

			for (int i = 0; i < arr.length; i++) {
				if (map.containsKey(arr[i])) {
					map.put(arr[i], map.get(arr[i]) + 1);
				} else {
					map.put(arr[i], 1);
				}
			}

			Object[] keyArr = map.keySet().toArray();
			Arrays.sort(keyArr);

			for (int i = 0; i < keyArr.length; i++) {
				System.out.println(keyArr[i] + " : " + map.get(keyArr[i]));
			}
		}
	}

}
