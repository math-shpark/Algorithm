package d3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem6190 {

	// 6190. 정곤이의 단조 증가하는 수
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 테스트 케이스 개수 입력
		int testCase = scan.nextInt();

		// 입력한 개수만큼 반복
		for (int test = 1; test <= testCase; test++) {

			// 수열 크기 입력
			int N = scan.nextInt();
			// 결과를 저장할 변수
			int maxNum = -1;
			// 수열 정보를 저장할 배열
			int[] numArr = new int[N];

			// 수열 정보를 배열에 저장
			for (int i = 0; i < N; i++) {
				numArr[i] = scan.nextInt();
			}

			// 수열 중 2개의 수를 뽑아 곱한 후
			// 곱한 수가 단조 증가하는 수인지 판별하고
			// 단조 증가하는 수가 맞으면 해당 값이 최댓값인지 판별하여
			// maxNum에 저장하는 반복문
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					// 수열 중 2개의 수를 뽑아 곱한 수를 문자열로 저장
					String num = String.valueOf(numArr[i] * numArr[j]);
					// 곱한 수의 자리별 숫자를 저장할 큐 생성
					Queue<Integer> numList = new LinkedList<Integer>();

					// 곱한 수를 앞자리부터 하나씩 큐에 저장
					for (int k = 0; k < num.length(); k++) {
						numList.add((int) num.charAt(k));
					}

					// 다 입력한 후 큐의 크기
					int size = numList.size();

					// 큐의 크기만큼 반복
					for (int k = 0; k < size; k++) {
						// 맨 앞자리를 취한 후 제거
						int front = numList.remove();

						// 다음 자리 수와 모두 비교하여
						// 방금 제거한 수가 마지막인 경우
						if (numList.size() == 0) {
							// 곱한 수인 num을 정수형으로 변환한 후
							int temp = Integer.parseInt(num);

							// 최댓값인지 여부를 확인하여 maxNum에 저장
							if (temp > maxNum) {
								maxNum = temp;
							}
						} else if (front > numList.peek()) {
							// 방금 뽑은 수가 마지막 수가 아니고
							// 다음 뽑을 수와 비교해서 지금 뽑은 수가 더 크면
							// 단조 증가 수가 아니므로 반복문을 종료하고
							// maxNum에는 저장하지 않음
							break;
						}
					}
				}
			}

			// 결과 출력
			System.out.println("#" + test + " " + maxNum);

		}

		// Scanner 종료
		scan.close();

	}

}
