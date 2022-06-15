package silver.level2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem1326 {

	private static class Frog {
		int idx, jump;

		Frog(int idx, int jump) {
			this.idx = idx;
			this.jump = jump;
		}
	}

	// 1326. 폴짝폴짝
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int N = scan.nextInt();
		int[] bridge = new int[N];
		boolean[] isVisited = new boolean[N];

		for (int i = 0; i < N; i++) {
			bridge[i] = scan.nextInt();
		}

		int start, end;
		start = scan.nextInt() - 1;
		end = scan.nextInt() - 1;

		Frog frog = new Frog(start, 0);
		Queue<Frog> bfsQue = new LinkedList<>();
		bfsQue.add(frog);
		int minJump = Integer.MAX_VALUE;

		while (!bfsQue.isEmpty()) {
			Frog now = bfsQue.poll();
			isVisited[now.idx] = true;

			if (now.idx == end) {
				if (now.jump < minJump)
					minJump = now.jump;
				break;
			}

			int multiple = 1;

			// right
			while (true) {
				if (now.idx + bridge[now.idx] * multiple >= N)
					break;

				if (!isVisited[now.idx + bridge[now.idx] * multiple]) {
					Frog next = new Frog(now.idx + bridge[now.idx] * multiple, now.jump + 1);
					bfsQue.add(next);
				}
				multiple++;
			}

			multiple = 1;

			// left
			while (true) {
				if (now.idx - bridge[now.idx] * multiple < 0)
					break;

				if (!isVisited[now.idx - bridge[now.idx] * multiple]) {
					Frog next = new Frog(now.idx - bridge[now.idx] * multiple, now.jump + 1);
					bfsQue.add(next);
				}
				multiple++;
			}

		}

		if (minJump == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(minJump);
		}

	}

}
