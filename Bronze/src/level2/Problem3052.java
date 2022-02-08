package level2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Problem3052 {

	// 3052. 나머지
	public static void main(String[] args) {

		// 서로 다른 데이터의 개수가 필요하므로 중복은 저장하지 않는 Set 타입 객체 사용
		Set<Integer> remainderSet = new HashSet<>();

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 입력값을 Set에 저장
		for (int i = 0; i < 10; i++) {
			remainderSet.add(scan.nextInt() % 42);
		}

		// 중복 데이터를 제외하고 저장된 Set의 크기가 서로 다른 나머지의 개수
		System.out.println(remainderSet.size());

		// 종료
		scan.close();

	}

}
