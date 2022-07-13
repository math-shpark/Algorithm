package silver.level5;

import java.util.Scanner;

public class Problem1064 {

	private static class Coordinate {
		int x;
		int y;

		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		Coordinate[] arr = new Coordinate[3];

		double[] dist = new double[3];

		for (int i = 0; i < 3; i++) {
			arr[i] = new Coordinate(scan.nextInt(), scan.nextInt());
		}

		if ((arr[1].y - arr[0].y) * (arr[2].x - arr[1].x) == (arr[1].x - arr[0].x) * (arr[2].y - arr[1].y))
			System.out.println(-1);

		else {
			double minVal = Double.MAX_VALUE;
			double maxVal = Double.MIN_VALUE;

			for (int i = 0; i < 3; i++) {
				dist[i] = Math
						.sqrt(Math.pow(arr[i].x - arr[(i + 1) % 3].x, 2) + Math.pow(arr[i].y - arr[(i + 1) % 3].y, 2));
			}

			for (int i = 0; i < 3; i++) {
				double sum = 0;
				sum += dist[i];
				sum += dist[(i + 1) % 3];
				sum *= 2;

				if (sum > maxVal)
					maxVal = sum;
				if (sum < minVal)
					minVal = sum;
			}

			System.out.println(maxVal - minVal);
		}
	}

}