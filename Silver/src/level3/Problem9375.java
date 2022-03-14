package level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem9375 {

	// 9375. 패션왕 신해빈
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 테스트 케이스
		int testCase = Integer.parseInt(br.readLine());

		for (int test = 1; test <= testCase; test++) {
			// 옷 개수 입력
			int clothes = Integer.parseInt(br.readLine());
			// 카테고리별 옷 개수를 저장할 맵 생성
			HashMap<String, Integer> countCloth = new HashMap<>();
			// 조합 개수를 저장할 변수
			int pairs = 1;

			// 옷이 없으면 조합 불가
			if (clothes == 0) {
				sb.append(0).append('\n');
				continue;
			}

			// 옷이 있으면
			for (int i = 0; i < clothes; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				// 카테고리만 취해서
				String category = st.nextToken();

				// 해당 카테고리의 옷이 이미 추가된 경우
				if (countCloth.containsKey(category)) {
					int count = countCloth.get(category);
					// 개수 1 추가
					countCloth.put(category, count + 1);
				} else {
					// 해당 카테고리의 옷이 없는 경우 새로 1 추가
					countCloth.put(category, 1);
				}
			}

			// 카테고리별 옷의 개수에 선택하지 않는 경우 1을 더해 곱의 법칙 적용
			for (int clothNum : countCloth.values()) {
				pairs *= (clothNum + 1);
			}

			// 모두 선택하지 않아 아무 의상도 입지 않는 경우 1 제외한 후 결과 출력
			sb.append(pairs - 1).append('\n');
		}

		System.out.println(sb);

	}

}
