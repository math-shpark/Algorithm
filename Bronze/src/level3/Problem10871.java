package level3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem10871 {

	// 10871. X보다 작은 수
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 숫자의 개수 입력
		int nums = scan.nextInt();
		// 기준 숫자 입력
		int standard = scan.nextInt();

		// 기준 숫자보다 작은 숫자를 저장할 리스트
		List<Integer> list = new ArrayList<>();

		// 기준 숫자보다 작으면 리스트에 추가하는 반복문
		for (int i = 0; i < nums; i++) {
			int num = scan.nextInt();

			if (num < standard) {
				list.add(num);
			}
		}

		// 결과 출력
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}

		// Scanner 종료
		scan.close();

	}

}
