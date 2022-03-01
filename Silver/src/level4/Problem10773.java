package level4;

import java.util.Scanner;
import java.util.Stack;

public class Problem10773 {

	// 10773. 제로
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// 숫자 개수
		int K = scan.nextInt();

		// 숫자를 저장하고 뺄 스택
		Stack<Integer> num = new Stack<>();

		for (int i = 0; i < K; i++) {
			// 다음 숫자를 읽어서
			int nextNum = scan.nextInt();

			if (nextNum == 0) {
				// 0이면 스택의 top을 지우고
				num.pop();
			} else {
				// 아니면 스택에 push
				num.push(nextNum);
			}
		}

		// 합
		int sum = 0;
		int range = num.size();

		// stack에 남아 있는 수를 더하는 반복문
		for (int i = 0; i < range; i++) {
			sum += num.pop();
		}

		// 결과 출력
		System.out.println(sum);

		scan.close();

	}

}
