package level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Problem1764 {

	// 1764. 듣보잡
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int noListen = Integer.parseInt(st.nextToken());
		int noLook = Integer.parseInt(st.nextToken());

		HashSet<String> noListenSet = new HashSet<>();
		ArrayList<String> noListenLook = new ArrayList<>();

		for (int i = 0; i < noListen; i++) {
			noListenSet.add(br.readLine());
		}

		for (int i = 0; i < noLook; i++) {
			String person = br.readLine();
			if (noListenSet.contains(person)) {
				noListenLook.add(person);
			}
		}

		sb.append(noListenLook.size()).append('\n');

		Collections.sort(noListenLook);

		for (int i = 0; i < noListenLook.size(); i++) {
			sb.append(noListenLook.get(i)).append('\n');
		}
		
		System.out.println(sb);

	}

}
