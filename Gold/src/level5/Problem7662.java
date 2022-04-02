package level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Problem7662 {

	// 7662. 이중 우선순위 큐
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 테스트 케이스 개수
		int testCase = Integer.parseInt(br.readLine());

		// 입력한 개수만큼 반복
		for (int test = 1; test <= testCase; test++) {
			// 연산자의 개수 입력
			int opNum = Integer.parseInt(br.readLine());
			// TreeMap 생성
			TreeMap<Integer, Integer> que = new TreeMap<>();

			// 연산 반복
			for (int op = 1; op <= opNum; op++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				// 연산자
				String command = st.nextToken();
				// 숫자
				int data = Integer.parseInt(st.nextToken());
				// 입력한 연산자에 맞춰 동작 수행
				switch (command) {
				case "I":
					// 이전에 동일한 숫자가 추가되었는지 확인한 후 개수 추가
					que.put(data, que.getOrDefault(data, 0) + 1);
					break;
				case "D":
					// 큐에 숫자가 없으면 건너뛰기
					if (que.size() == 0) {
						continue;
					}
					// 내보낼 숫자
					int outKey;

					// 입력 숫자에 맞춰 동작
					if (data == 1) {
						outKey = que.lastKey();
					} else {
						outKey = que.firstKey();
					}

					// 삭제한 숫자가 해당 숫자의 마지막 숫자였으면
					if (que.put(outKey, que.get(outKey) - 1) == 1) {
						// 해당 숫자를 삭제
						que.remove(outKey);
					}

					break;
				}
			} // 연산 반복문 종료

			// 결과 문자열 생성
			if (que.isEmpty()) {
				sb.append("EMPTY").append('\n');
			} else {
				sb.append(que.lastKey()).append(" ").append(que.firstKey()).append('\n');
			}

		} // 테스트 케이스 종료

		// 결과 출력
		System.out.println(sb);

	}

}
