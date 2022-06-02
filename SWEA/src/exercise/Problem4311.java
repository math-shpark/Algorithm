package exercise;

import java.util.Scanner;

public class Problem4311 {
	static int N, O, M, W, ans;
	static int[] numArr = new int[10];
	static int[] opArr = new int[4];
	static int[] visit = new int[1000];
	static int[] check = new int[1000];

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int testCase = scan.nextInt();
		for (int test = 1; test <= testCase; test++) {
			N = scan.nextInt();
			O = scan.nextInt();
			M = scan.nextInt();
			ans = Integer.MAX_VALUE;

			start();

			for (int i = 0; i < N; i++) {
				int num = scan.nextInt();
				numArr[num] = 1;
			}

			for (int i = 0; i < O; i++) {
				int op = scan.nextInt();
				opArr[op - 1] = 1;
			}

			W = scan.nextInt();

			if (numArr[0] == 1 && W == 0) {
				System.out.println("#" + test + " " + 1);
				continue;
			}

			create();

			boolean flag = false;

			for (int i = 1; i <= 999; i++) {
				if (check[i] == 1) {
					if (i == W) {
						flag = true;
						ans = visit[i];
						break;
					}
					calTouch(i, visit[i]);
				}
			}
			if (ans == Integer.MAX_VALUE)
				ans = -1;
			else if (!flag)
				ans++;

			System.out.println("#" + test + " " + ans);
		}
	}

	static void start() {
		for (int i = 0; i < 10; i++)
			numArr[i] = 0;
		for (int i = 0; i < 4; i++)
			opArr[i] = 0;
		for (int i = 0; i < 1000; i++) {
			visit[i] = Integer.MAX_VALUE;
			check[i] = 0;
		}
	}

	static void create() {
		for (int i = 1; i < 10; i++) {
			if (numArr[i] == 1) {
				searchCase(i, 1);
			}
		}
	}

	static void searchCase(int num, int depth) {
		if (num < 0 || num > 999)
			return;
		visit[num] = depth;
		check[num] = 1;
		for (int i = 0; i < 10; i++) {
			if (numArr[i] == 1) {
				searchCase(num * 10 + i, depth + 1);
			}
		}
	}

	static void calTouch(int num, int cnt) {
		if (num < 0 || num > 999)
			return;

		if (cnt >= ans)
			return;

		if (cnt > M - 1)
			return;

		if (num == W) {
			ans = ans <= cnt ? ans : cnt;
			return;
		}

		if (visit[num] < cnt)
			return;

		if (check[num] == 0 && visit[num] == cnt)
			return;

		visit[num] = cnt;

		for (int i = 1; i <= 999; i++) {
			if (check[i] == 1) {
				if (opArr[0] == 1)
					calTouch(num + i, cnt + visit[i] + 1);
				if (opArr[1] == 1)
					calTouch(num - i, cnt + visit[i] + 1);
				if (opArr[2] == 1 && i > 1)
					calTouch(num * i, cnt + visit[i] + 1);
				if (opArr[3] == 1 && i > 1)
					calTouch(num / i, cnt + visit[i] + 1);
			}
		}
	}

}
