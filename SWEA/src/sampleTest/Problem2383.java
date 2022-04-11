package sampleTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem2383 {

	// 정점 클래스 생성
	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	// 계단 클래스 생성
	static class Stairs {
		Node node;
		// 계단 길이, 계단에 있는 사용자 수
		int value, count;
		// 이용 가능 여부
		boolean isOkay;

		public Stairs(int x, int y, int value) {
			this.node = new Node(x, y);
			this.value = value;
			this.count = 0;
			this.isOkay = true;
		}

		// 내려가는 사람이 추가될 경우
		public void down() {
			// 추가된 사람까지 3명이면 이용 불가 표시
			if (++count == 3)
				this.isOkay = false;
		}

		// 다른 경우의 수에서 사용할 수 있도록 계단 상태 초기화
		public void reset() {
			this.count = 0;
			this.isOkay = true;
		}

		// 보행자가 계단을 다 내려와서 나가는 경우
		public void out() {
			// 사용 중인 사람 수 1 차감
			count--;
			// 최소 1명은 들어갈 수 있으므로 이용 가능 표시
			this.isOkay = true;
		}

	}

	// 사람 수
	static int personNum;
	// 최소 시간
	static int minTime;
	// 계단별 보행자와의 거리 저장 배열
	private static int[][] distance;
	// 계단 목록
	private static Stairs[] stairs;
	// 보행자별 선택한 계단 목록
	private static boolean[] choice;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 개수 입력
		int testCase = Integer.parseInt(br.readLine());

		for (int test = 1; test <= testCase; test++) {
			StringTokenizer st;
			// 사람 목록
			ArrayList<Node> people = new ArrayList<>();

			// 초기화
			personNum = 0;
			stairs = new Stairs[2];
			minTime = Integer.MAX_VALUE;

			// 방 한 변의 길이
			int N = Integer.parseInt(br.readLine());
			// 계단 배열 인덱스
			int idx = 0;

			// 공간 정보 입력
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < N; j++) {
					int data = Integer.parseInt(st.nextToken());
					// 사람이면 사람 리스트에 추가
					if (data == 1) {
						people.add(new Node(i, j));
						personNum++;
					} else if (data != 0)
						// 계단이면 계단 목록에 추가
						stairs[idx++] = new Stairs(i, j, data);
				}
			}

			// 배열 크기 입력
			distance = new int[2][personNum];
			choice = new boolean[personNum];

			// 2개의 계단을 각각 기준으로 하여
			// 각 계단 기준 보행자와의 거리들을 배열에 저장하는 반복문
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < personNum; j++) {
					distance[i][j] = calDis(stairs[i].node, people.get(j));
				}
			}

			// 중복 순열
			// 0번 인덱스의 사람부터 계단 선택
			permutation(0);

			// 결과 문자열 작성
			sb.append("#").append(test).append(" ").append(minTime).append('\n');
		}
		// 결과 출력
		System.out.println(sb);
	}

	// 중복 순열
	private static void permutation(int count) {
		// 다 뽑으면 거리 계산 후 최솟값만 저장
		if (personNum == count) {
			process(makeDisArr());
			return;
		}

		// 재귀
		choice[count] = true;
		permutation(count + 1);
		choice[count] = false;
		permutation(count + 1);
	}

	// 최단 시간인지 확인하는 메서드
	private static void process(int[] disArr) {

		// 계단을 내려갔는지 여부를 저장할 배열
		boolean[] isOut = new boolean[personNum];
		// 지금 선택한 계단 목록으로 계산된 시간
		int time = 0;

		// 계단 상태 초기화
		stairs[0].reset();
		stairs[1].reset();

		// 계단 대기 명단
		ArrayList<Integer> wait = new ArrayList<>();

		// 이미 최소 시간이 아니면 넘어간다.
		while (++time < minTime) {
			// 대기 명단 비우기
			wait.clear();

			for (int i = 0; i < personNum; i++) {
				// 이미 내려간 사람은 건너뛰기
				if (isOut[i])
					continue;

				// true면 0번 계단, false면 1번 계단
				int stairIdx = (choice[i]) ? 0 : 1;

				// 계단에 도달한 사람은
				if (disArr[i] == 0)
					// 대기 명단에 추가
					wait.add(i);
				else {
					// 계단을 방금 다 내려온 사람은
					if (--disArr[i] < (-1) * stairs[stairIdx].value) {
						// 계단에 있는 사람 명단에서 1 차감 후
						stairs[stairIdx].out();
						// 내려왔음을 표시
						isOut[i] = true;
					}
				}
			}

			// 대기 명단에 있는 사람을 1명씩 확인해서
			for (Integer i : wait) {
				int stairIdx = (choice[i]) ? 0 : 1;
				// 선택한 계단이 이용 가능하면
				if (stairs[stairIdx].isOkay) { // 내려갈 수 있으면 내려감
					// 음수로 내려온 계단 길이 표시
					disArr[i]--;
					// 계단에 1명 추가됐음을 반영
					stairs[stairIdx].down();
				}
			}

			// 모든 사람이 다 내려왔으면
			if (isFinish(isOut))
				// 최소 시간이므로 시간 반영
				minTime = time;
		}
	}

	// 모두 내려왔는지 확인하는 메서드
	private static boolean isFinish(boolean[] check) {
		// 한 명이라도 아직 못내려오면 false
		for (int i = 0; i < personNum; i++) {
			if (!check[i])
				return false;
		}
		return true;
	}

	// 선택한 계단과의 거리들을 배열로 반환하는 메서드
	private static int[] makeDisArr() {
		// 보행자별 선택한 계단을 기준으로 거리를 저장할 배열
		int[] disArr = new int[personNum];

		// true면 0번 인덱스 계단과의 거리
		// false면 1번 인덱스 계단과의 거리
		for (int i = 0; i < personNum; i++) {
			disArr[i] = (choice[i]) ? distance[0][i] : distance[1][i];
		}

		return disArr;
	}

	// 거리 계산
	private static int calDis(Node a, Node b) {
		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
	}
}
