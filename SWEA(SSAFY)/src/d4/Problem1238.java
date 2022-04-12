package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1238 {

	// 1238. Contact
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 10개의 테스트 케이스
		for (int test = 1; test <= 10; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			// 데이터 길이
			int size = Integer.parseInt(st.nextToken());
			// 시작 번호
			int start = Integer.parseInt(st.nextToken());

			// 데이터를 임시로 저장할 배열
			int[] temp = new int[size];

			// 가장 큰 노드 번호
			int maxNum = 0;

			// 데이터 임시 저장
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < size; i++) {
				temp[i] = Integer.parseInt(st.nextToken());
				if (temp[i] > maxNum)
					maxNum = temp[i];
			}

			// 인접 행렬
			int[][] space = new int[maxNum + 1][maxNum + 1];
			// 탐색 여부 저장 배열
			boolean[] isVisited = new boolean[maxNum + 1];

			// 연결 정보 입력
			for (int i = 0; i < size; i += 2) {
				int from = temp[i];
				int to = temp[i + 1];

				space[from][to] = 1;
			}

			// bfs 큐 생성
			Queue<Integer> bfsQue = new LinkedList<>();
			// 출발 노드 표시 및 추가
			isVisited[start] = true;
			bfsQue.add(start);

			// 마지막에 연락받은 사람을 저장할 리스트
			ArrayList<Integer> current = new ArrayList<>();

			// bfs
			while (!bfsQue.isEmpty()) {
				// 최근에 연락받은 사람 목록 초기화
				current.clear();
				// 동시에 연결 가능한 범위
				int range = bfsQue.size();
				while (range-- > 0) {
					// 다른 사람에게 연락해야 하는 사람
					int call = bfsQue.poll();
					// 가장 마지막으로 연락받은 사람 리스트에 일단 추가
					current.add(call);
					for (int next = 1; next <= maxNum; next++) {
						// 이미 연락한 사람은 pass
						if (isVisited[next])
							continue;

						// 아직 연락되지 않은 사람 중 지금 사람과 연결된 사람이면 전화
						if (space[call][next] == 1) {
							// 연락 여부 표시
							isVisited[next] = true;
							// 다음 사람에게 연락해야 하는 사람으로 큐에 추가
							bfsQue.add(next);
						}
					}
				} // 동시 연락 종료
			}
			// 더이상 추가되는 사람이 없어 탐색이 종료되면
			// current 리스트에 저장된 사람이 마지막으로 연락된 사람
			// 내림차순으로 정렬
			current.sort(Collections.reverseOrder());

			// 결과 문자열 생성
			sb.append("#").append(test).append(" ").append(current.get(0)).append('\n');
		}
		// 결과 출력
		System.out.println(sb);
	}

}
