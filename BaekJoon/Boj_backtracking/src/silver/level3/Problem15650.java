package silver.level3;

import java.util.Scanner;

public class Problem15650 {

	public static int[] arr;
	public static int N, M;

	// 15650. N과 M(2)
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		// 숫자 범위 입력
		N = scan.nextInt();
		// 수열 길이 입력
		M = scan.nextInt();
		// 뽑은 수열을 저장할 배열 크기 입력
		arr = new int[M];
		// dfs
		dfs(1, 0);

		scan.close();

	}

	public static void dfs(int at, int depth) {

		if (depth == M) {
			for (int val : arr) {
				System.out.print(val + " ");
			}
			System.out.println();
			return;
		}

		for (int i = at; i <= N; i++) {

			arr[depth] = i;
			dfs(i + 1, depth + 1);

		}
	}
}
