package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Code1535 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<String> set = new HashSet<String>();
		List<String> list = new ArrayList<String>();

		while (true) {
			String str = br.readLine();

			if (str.equals("END"))
				break;

			StringTokenizer st = new StringTokenizer(str);

			while (st.hasMoreTokens()) {
				String newS = st.nextToken();

				if (set.contains(newS))
					continue;
				else {
					set.add(newS);
					list.add(newS);
				}
			}

			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i));
				if (i == list.size() - 1)
					System.out.println();
				else
					System.out.print(" ");
			}

		}
	}

}
