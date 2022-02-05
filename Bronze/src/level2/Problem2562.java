package level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Problem2562 {

	// 2562. 최댓값
	public static void main(String[] args) throws NumberFormatException, IOException {

		// 입력 스트림 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력 값을 저장할 리스트 생성
		List<Integer> numList = new ArrayList<>();

		// 입력한 값을 리스트에 저장
		for (int i = 0; i < 9; i++) {
			int num = Integer.parseInt(br.readLine());
			numList.add(num);
		}

		// 최댓값을 저장할 변수
		int max = 0;
		// 최댓값이 저장된 인덱스 저장할 변수
		int index = 0;

		for (int i = 0; i < numList.size(); i++) {
			if (max < numList.get(i)) {
				max = numList.get(i);
				index = i;
			}
		}

		System.out.println(max);
		System.out.println(index + 1); // 필요한 건 인덱스가 아닌 순서이므로 1을 더해줌

	}

}
