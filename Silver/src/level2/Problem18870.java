package level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem18870 {

	// 18870. 좌표 압축
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 좌표 개수 입력
		int N = Integer.parseInt(br.readLine());
		// 입력받은 순서대로 저장할 배열
		int[] numArr = new int[N];
		// 입력받은 좌표를 정렬할 배열
		int[] sortArr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 배열에 좌표를 입력하는 반복문
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			numArr[i] = num;
			sortArr[i] = num;
		}

		// 배열 정렬(오름차순)
		Arrays.sort(sortArr);

		// 작은 좌표부터 순위를 저장할 맵 생성
		Map<Integer, Integer> orderMap = new HashMap<>();

		// 순위를 저장할 변수
		int order = 0;

		// 맵에 좌표 순위를 저장하고
		// 저장하려는 좌표가 이미 입력된 경우 건너뜀
		for (int i = 0; i < N; i++) {
			if (orderMap.containsKey(sortArr[i])) {
				continue;
			} else {
				orderMap.put(sortArr[i], order);
				order++;
			}
		}

		// 결과 출력
		for (int i = 0; i < N; i++) {
			sb.append(orderMap.get(numArr[i])).append(" ");
		}

		System.out.println(sb);

	}

}
