package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem6808 {

	// 규영이의 카드
	static int[] kyu;
	// 인영이의 카드
	static int[] young;
	// 이긴 횟수
	static int win;
	// 진 횟수
	static int lose;
	// 선택 여부 저장 배열
	static boolean[] isSelected;

	// 6808. 규영이와 인영이의 카드게임
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 개수 입력
		int testCase = Integer.parseInt(br.readLine());

		// 입력한 개수만큼 반복
		for (int test = 1; test <= testCase; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			// 배열 초기화
			kyu = new int[9];
			young = new int[9];
			isSelected = new boolean[19];

			// 횟수 초기화
			win = 0;
			lose = 0;

			// 카드 정보 입력
			for (int i = 0; i < 9; i++) {
				// 카드 정보를 입력하고
				kyu[i] = Integer.parseInt(st.nextToken());
				// 선택된 카드임을 표시
				isSelected[kyu[i]] = true;
			}

			// 남은 카드들을 인영이의 배열에 입력
			// 카드 정보를 넣을 위치
			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				if (isSelected[i] == false) {
					young[idx] = i;
					idx++;
				}
			}

			// 순열
			permutation(0);

			// 결과 문자열
			sb.append("#").append(test).append(" ").append(win).append(" ").append(lose).append('\n');
		}

		// 결과 출력
		System.out.println(sb);

	}

	// 순열
	private static void permutation(int count) {

		// 경계
		// 9개 숫자의 나열이 완료되면 재귀 종료
		if (count == 9) {
			// 규영이의 점수
			int kyuScore = 0;
			// 인영이의 점수
			int youngScore = 0;

			for (int i = 0; i < 9; i++) {
				// 규영이가 이긴 경우
				if (kyu[i] > young[i]) {
					kyuScore += kyu[i];
					kyuScore += young[i];
				} else {
					// 동일한 카드는 낼 수 없으므로
					// 나머지는 인영이가 이긴 경우
					youngScore += kyu[i];
					youngScore += young[i];
				}
			}

			// 결과 횟수 반영
			if (kyuScore > youngScore) {
				win++;
			} else if (youngScore > kyuScore) {
				lose++;
			}

			return;
		}

		// 재귀
		for (int i = count; i < 9; i++) {
			int temp = young[count];
			young[count] = young[i];
			young[i] = temp;

			permutation(count + 1);

			young[i] = young[count];
			young[count] = temp;
		}

	}

}
