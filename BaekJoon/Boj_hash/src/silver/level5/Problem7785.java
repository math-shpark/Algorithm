package silver.level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Problem7785 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int logCount = Integer.parseInt(br.readLine());
		HashSet<String> company = new HashSet<String>();

		StringTokenizer st;
		for (int c = 0; c < logCount; c++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String act = st.nextToken();

			if (act.equals("enter"))
				company.add(name);
			else
				company.remove(name);
		}

		String[] remain = new String[company.size()];

		int idx = 0;
		for (String name : company) {
			remain[idx] = name;
			idx++;
		}
		
		Arrays.sort(remain);

		for (int i = remain.length - 1; i >= 0; i--) {
			System.out.println(remain[i]);
		}
	}

}
