package search;

import java.util.HashSet;

public class Problem42839 {

	static String[] numArr;
	static boolean[] isSelected;
	static HashSet<Integer> set = new HashSet<Integer>();
	static int total = 0;

	// 소수 찾기
	public static void main(String[] args) {
		String numbers = "17";
		int answer = solution(numbers);
		System.out.println(answer);
	}

	private static int solution(String numbers) {
		numArr = numbers.split("");

		for (int i = 1; i <= numArr.length; i++) {
			isSelected = new boolean[numArr.length];
			comb(i, 0, "");
		}

		return total;
	}

	private static void comb(int max, int count, String num) {
		if (count == max) {
			int n = Integer.parseInt(num);
			if (!set.contains(n) && check(n)) {
				set.add(n);
				total++;
			} else {
				set.add(n);
			}
			return;
		}

		for (int i = 0; i < numArr.length; i++) {
			if (!isSelected[i]) {
				isSelected[i] = true;
				comb(max, count + 1, num + numArr[i]);
				isSelected[i] = false;
			}
		}
	}

	private static boolean check(int num) {
		int count = 0;
		for (int i = 1; i <= num; i++) {
			if (num % i == 0)
				count++;
		}
		return count == 2 ? true : false;
	}

}
