package level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11723 {

	// 11726. 집합
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 원소 포함 여부를 저장할 배열
		boolean[] set = new boolean[21];

		// 명령 개수
		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 명령 입력
			String command = st.nextToken();
			// 입력한 명령에 맞춰 동작 수행
			switch (command) {
			case "add":
				int addNum = Integer.parseInt(st.nextToken());
				set[addNum] = true;
				break;
			case "remove":
				int removeNum = Integer.parseInt(st.nextToken());
				set[removeNum] = false;
				break;
			case "check":
				int checkNum = Integer.parseInt(st.nextToken());
				if (set[checkNum]) {
					sb.append(1).append('\n');
				} else {
					sb.append(0).append('\n');
				}
				break;
			case "toggle":
				int toggleNum = Integer.parseInt(st.nextToken());
				set[toggleNum] = !set[toggleNum];
				break;
			case "all":
				for (int j = 1; j <= 20; j++) {
					set[j] = true;
				}
				break;
			case "empty":
				for (int j = 1; j <= 20; j++) {
					set[j] = false;
				}
				break;
			}
		}
		// 결과 출력
		System.out.println(sb);

	}

}
