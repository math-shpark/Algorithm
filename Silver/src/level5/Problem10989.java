package level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem10989 {

	// 10989. 수 정렬하기 3
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 입력할 숫자의 개수
		int N = Integer.parseInt(br.readLine());
		// 입력한 숫자의 개수를 저장할 배열
		int[] numArr = new int[10001];

		// 입력한 숫자를 인덱스로 취해 해당 위치 1추가하는 반복문
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			numArr[num]++;
		}

		// 0번 인덱스부터 입력된 개수만큼 출력하는 반복문
		for (int i = 0; i < 10001; i++) {
			for (int j = 0; j < numArr[i]; j++) {
				sb.append(i).append('\n');
			}
		}

		System.out.println(sb);

	}

}
