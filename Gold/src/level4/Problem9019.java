package level4;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem9019 {

	// 9019. DSLR
	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner scan = new Scanner(System.in);
		// 테스트 케이스 개수 입력
		int T = scan.nextInt();

		// 입력한 개수만큼 반복
		for (int tc = 1; tc <= T; tc++) {
			// 시작 숫자와 도착 숫자 입력
			int start = scan.nextInt();
			int end = scan.nextInt();
			// 이미 다른 경로를 통해 도착했는지 여부를 저장할 배열
			boolean[] visit = new boolean[10000];
			// 출발 숫자 표시
			visit[start] = true;

			// bfs 큐
			Queue<Register> bfsQue = new LinkedList<>();
			bfsQue.add(new Register(start, ""));

			while (!bfsQue.isEmpty()) {
				Register cur = bfsQue.poll();

				if (cur.num == end) {
					System.out.println(cur.command);
					break;
				}

				if (!visit[cur.D()]) {
					bfsQue.add(new Register(cur.D(), cur.command + "D"));
					visit[cur.D()] = true;
				}
				if (!visit[cur.S()]) {
					bfsQue.add(new Register(cur.S(), cur.command + "S"));
					visit[cur.S()] = true;
				}
				if (!visit[cur.L()]) {
					bfsQue.add(new Register(cur.L(), cur.command + "L"));
					visit[cur.L()] = true;
				}
				if (!visit[cur.R()]) {
					bfsQue.add(new Register(cur.R(), cur.command + "R"));
					visit[cur.R()] = true;
				}

			}
		}

		scan.close();

	}

	static class Register {
		int num;
		String command;

		Register(int num, String command) {
			this.num = num;
			this.command = command;
		}

		int D() {
			return (num * 2) % 10000;
		}

		int S() {
			return num == 0 ? 9999 : num - 1;
		}

		int L() {
			return num % 1000 * 10 + num / 1000;
		}

		int R() {
			return num % 10 * 1000 + num / 10;
		}
	}

}
