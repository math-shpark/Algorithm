package level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Problem2751 {

	// 2751. 수 정렬하기 2
	public static void main(String[] args) throws NumberFormatException, IOException {

		// 입력 스트림 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 입력할 숫자의 개수
		int N = Integer.parseInt(br.readLine());

		// 입력한 숫자를 저장할 리스트
		ArrayList<Integer> list = new ArrayList<>();

		// 리스트에 숫자 입력
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}

		// 리스트 정렬
		Collections.sort(list);

		// 정렬 결과를 sb에 연결
		for (int i = 0; i < N; i++) {
			sb.append(list.get(i)).append('\n');
		}

		// 결과 출력
		System.out.println(sb);

	}

}
