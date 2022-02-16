package level2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Problem2309 {

	// 2309. 일곱 난쟁이
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);
		// 9명의 난쟁이의 키를 저장할 배열
		int[] numArr = new int[9];
		// 합이 100이 되는 난쟁이를 찾은 후 해당 난쟁이들의 키를 저장할 리스트
		List<Integer> result = new ArrayList<>();

		// 난쟁이의 키를 배열에 저장
		for (int i = 0; i < 9; i++) {
			numArr[i] = scan.nextInt();
		}

		// 9명 중 차례대로 2명씩 제외한 후 나머지 난쟁이의 키를 더한 후
		// 100이 되면 해당 난쟁이들의 키를 리스트로 저장하고
		// 반복문을 중단
		Outer: for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				// 임시로 뽑은 7명의 난쟁이의 키를 저장할 리스트
				List<Integer> list = new ArrayList<>();

				for (int k = 0; k < 9; k++) {
					if (k == i || k == j) {
						// 임의 2명을 제외하고
						continue;
					} else {
						// 나머지 7명의 키를 저장
						list.add(numArr[k]);
					}
				}

				// 임의로 뽑은 7명의 키를 더한 값을 저장할 변수
				int sum = 0;

				// 7명의 키를 더하는 반복문
				for (int k = 0; k < 7; k++) {
					sum += list.get(k);
				}

				// 임의로 뽑은 7명의 키 합이 100이면
				// 해당 리스트를 반환하고
				// 반복문 종료
				if (sum == 100) {
					result = list;
					break Outer;
				}
			}
		}

		// 뽑힌 7명의 키를 오름차순으로 정렬
		result.sort(Comparator.naturalOrder());

		// 결과 출력
		for (int i = 0; i < 7; i++) {
			System.out.println(result.get(i));
		}

		scan.close();

	}

}
