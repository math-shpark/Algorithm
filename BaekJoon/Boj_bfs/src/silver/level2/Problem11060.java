package silver.level2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem11060 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt(); // N

		int[] arr = new int[n];
		boolean[] isCheck = new boolean[n]; // backtracking

		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}

		int jump = -1;
		boolean isArr = false; // isArrived

		Queue<Integer> bfsQue = new LinkedList<Integer>();
		bfsQue.add(0); // start
		isCheck[0] = true;

		while (!bfsQue.isEmpty()) {
			jump++;
			int range = bfsQue.size();

			for (int i = 0; i < range; i++) {
				int now = bfsQue.poll();

				if (now == n - 1) {
					isArr = true;
					break;
				}

				for (int j = 1; j <= arr[now]; j++) {
					if (now + j >= n)
						break;
					if (isCheck[now + j])
						continue;
					isCheck[now + j] = true;
					bfsQue.add(now + j);
				}
			}
		} // BFS

		System.out.println(isArr ? jump : -1); // print
	}

}
