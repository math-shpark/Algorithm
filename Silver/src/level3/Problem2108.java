package level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2108 {

	// 2108. 통계학
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// N 입력
		int N = Integer.parseInt(br.readLine());
		// 카운팅 정렬에 사용할 배열
		int[] count = new int[8001];
		// 전체 합
		int sum = 0;
		// 최소 데이터
		int maxValue = Integer.MIN_VALUE;
		// 최대 데이터
		int minValue = Integer.MAX_VALUE;

		// 숫자 개수를 카운팅 배열에 반영하고
		// sum에 데이터를 더하고
		// 최대, 최소 데이터를 찾는 반복문
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			count[num + 4000]++;
			sum += num;
			if (maxValue < num) {
				maxValue = num;
			}
			if (minValue > num) {
				minValue = num;
			}
		}

		// 평균 출력
		sb.append((int) Math.round((double) sum / N)).append('\n');

		// 최빈 수 저장 변수
		int maxCount = 0;
		// 이미 해당 횟수의 숫자가 나왔는지 여부 저장
		boolean isFirst = false;
		// 최빈 값
		int commonNum = 0;

		for (int i = minValue + 4000; i <= maxValue + 4000; i++) {

			// 최빈값을 처음 찾으면
			// 저장하고
			if (maxCount < count[i]) {
				maxCount = count[i];
				// 해당 값을 저장하고
				commonNum = i - 4000;
				// 한 번 나왔음에 표시
				isFirst = true;
			} else if (maxCount == count[i] && isFirst) {
				// 해당 최빈값이 두 번째로 나오면
				// 해당 값을 저장하고
				commonNum = i - 4000;
				// 뒤에 또 해당 값이 나와도 반영되지 않도록 false 저장
				isFirst = false;
			}

			// 누적합
			if (i == 0) {
				continue;
			} else {
				count[i] += count[i - 1];
			}
		}

		// 중간값을 찾아 출력
		for (int i = minValue + 4000; i <= maxValue + 4000; i++) {
			if (count[i] >= (N + 1) / 2) {
				sb.append(i - 4000).append('\n');
				break;
			}
		}

		// 최빈값 출력
		sb.append(commonNum).append('\n');

		// 범위 출력
		sb.append(maxValue - minValue);

		// 결과 출력
		System.out.println(sb);

	}

}
