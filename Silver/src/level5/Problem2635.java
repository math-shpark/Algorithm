package level5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem2635 {

	// 2635. 수 이어가기
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 첫 번째 수 입력
		int first = scan.nextInt();
		// 최다 숫자를 저장할 리스트
		List<Integer> result = new ArrayList<>();

		// 1부터 시작해서 최다 숫자가 나오는 두 번째 숫자를 찾는 반복문
		for (int second = 1; second <= first; second++) {

			// 선택한 두 번째 숫자로 만드는 수열을 저장할 리스트
			List<Integer> tempList = new ArrayList<>();

			// 첫 번째 수와 두 번째 수 입력
			tempList.add(first);
			tempList.add(second);
			// 다음 순번 인덱스
			int index = 2;

			while (true) {
				// 앞 2개의 숫자 차이가 0 이상이면
				if (tempList.get(index - 2) - tempList.get(index - 1) >= 0) {
					// 차이를 다음 인덱스에 넣고
					tempList.add(tempList.get(index - 2) - tempList.get(index - 1));
					// 다음 순번 1 추가
					index++;
				} else {
					// 조건을 만족하지 않으면 반복문 종료
					break;
				}
			}

			// 현재 만든 리스트가 현재 최장 리스트보다 더 길면 대체
			if (result.size() < tempList.size()) {
				result = tempList;
			}

		}

		// 결과 리스트 길이 출력
		System.out.println(result.size());

		// 리스트에 담긴 데이터 출력
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i) + " ");
		}

		// Scanner 종료
		scan.close();

	}

}
