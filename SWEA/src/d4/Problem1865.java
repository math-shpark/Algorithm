package d4;

import java.util.Scanner;

public class Problem1865 {
	static int N;
	static double maxProb;
	static double[][] process;
	static int[] job;
	static boolean[] isVisited;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int testCase = scan.nextInt();
		
		for (int test = 1; test <= testCase; test++) {
			
			N = scan.nextInt();
			process = new double[N][N];
			job = new int[N];
			isVisited = new boolean[N];
			maxProb = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					process[i][j] = scan.nextInt() / 100.0;
				}
			}
			
			dfs(0, 1.0);
			
			System.out.printf("#%d %.6f\n", test, maxProb);
		}
	}

	public static void dfs(int count, double sum) {
		
		if (sum * 100 <= maxProb)
			return;
		
		if (count == N) {
			if (sum * 100 > maxProb) {
				maxProb = sum * 100;
				return;
			}
		}

		for (int i = 0; i < N; i++) {
			if (!isVisited[i]) {
				isVisited[i] = true;
				dfs(count + 1, sum * process[count][i]);
				isVisited[i] = false;
			}
		}
	}
}
