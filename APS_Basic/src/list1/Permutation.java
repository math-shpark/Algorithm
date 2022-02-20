package list1;

public class Permutation {

	public static void main(String[] args) {

		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				if (i != j) {
					for (int k = 1; k <= 3; k++) {
						if (i != k && j != k) {
							System.out.printf("%d%d%d\n", i, j, k);
						}
					}
				}
			}
		}

	}

}
