package level4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Problem11866 {

	// 11866. 요세푸스 문제
	public static void main(String[] args) {
		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 사람 수
		int N = scan.nextInt();
		// 죽일 순번
		int K = scan.nextInt();

		// 사람을 줄세울 큐 생성
		Queue<Integer> people = new LinkedList<>();
		// 죽은 사람을 순서대로 저장할 리스트 생성
		List<Integer> killed = new ArrayList<>();

		// 큐에 사람을 넣는 반복문
		for (int i = 1; i <= N; i++) {
			people.add(i);
		}

		// 큐에 모든 사람이 죽을 때까지 반복
		while (people.size() != 0) {
			for (int i = 0; i < K; i++) {
				// 죽을 순번이 되면
				if (i == K - 1) {
					// killed 리스트에 추가하고 큐에서 제거
					killed.add(people.remove());
				} else {
					// 아직 죽을 순번이 아니면
					// 순번 맨 뒤로 보냄
					int front = people.remove();
					people.add(front);
				}
			}
		}

		// StringBuilder 생성
		StringBuilder sb = new StringBuilder();

		// 출력 양식에 맞춰 출력
		sb.append("<");
		sb.append(killed.get(0));

		for (int i = 1; i < killed.size(); i++) {
			sb.append(", ");
			sb.append(killed.get(i));
		}

		sb.append(">");

		String result = sb.toString();

		System.out.println(result);

		// Scanner 종료
		scan.close();

	}

}
