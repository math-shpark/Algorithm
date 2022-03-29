package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1231 {

	// 문자열 연결
	static StringBuilder sb = new StringBuilder();
	// 노드 안에 적힌 글자를 저장할 배열
	static String[] treeLetter;
	// 노드 개수
	static int N;

	// 1231. 중위 순회
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 10개의 테스트 케이스 반복
		for (int test = 1; test <= 10; test++) {
			// 노드 개수 입력
			N = Integer.parseInt(br.readLine());

			// 노드 번호를 인덱스로 취하므로 1 더 큰 크기의 배열로 지정
			treeLetter = new String[N + 1];

			// 노드 내 글자를 배열에 저장하는 반복문
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int nodeNum = Integer.parseInt(st.nextToken());

				treeLetter[i] = st.nextToken();
			}

			// 출력 양식
			sb.append("#").append(test).append(" ");

			// 중위순위 메소드
			// 뿌리 노드는 1로 고정
			search(1);
			
			// 줄 넘김
			sb.append('\n');
		}
		
		// 결과 출력
		System.out.println(sb);

	}

	private static void search(int node) {

		// 기본
		if (node > N) {
			return;
		}

		// 재귀
		// 왼쪽 자식 노드 검색 후
		search(2 * node);
		// 현재 노드 검색 후
		sb.append(treeLetter[node]);
		// 오른쪽 자식 노드 검색
		search(2 * node + 1);
	}

}
