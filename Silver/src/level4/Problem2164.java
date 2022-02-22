package level4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem2164 {

	// 2164. 카드 2
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 카드 위치를 저장할 큐 생성
		Queue<Integer> card = new LinkedList<Integer>();
		// 카드 개수 입력
		int N = scan.nextInt();

		// 큐에 카드 넣는 반복문
		for (int i = 1; i <= N; i++) {
			card.add(i);
		}

		// 문제에서 제시하는 활동을 큐에 카드 1개 남을 때까지 반복
		while (card.size() > 1) {
			// 맨 위 카드 버리고
			card.remove();

			// 다음 카드를
			int second = card.peek();
			// 맨 위에서 제거하고
			card.remove();
			// 맨 밑으로 넣음
			card.add(second);
		}

		// 마지막에 남은 카드 1개 출력
		System.out.println(card.peek());

		// Scanner 종료
		scan.close();

	}

}
