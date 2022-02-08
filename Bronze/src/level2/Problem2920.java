package level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Problem2920 {

	// 2920. 음계
	public static void main(String[] args) throws IOException {

		// 입력 스트림 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력 값을 문자열로 저장
		String str = br.readLine();

		// 입력값을 3개의 배열로 저장
		String[] arr1 = str.split(" "); // 오리지널
		String[] arr2 = str.split(" "); // 오름차순
		String[] arr3 = str.split(" "); // 내림차순

		// 오름차순 정렬
		Arrays.sort(arr2);
		// 내림차순 정렬
		Arrays.sort(arr3, Collections.reverseOrder());

		// 동일한 배열에 따라 결과 출력
		if (Arrays.equals(arr1, arr2)) {
			System.out.println("ascending");
		} else if (Arrays.equals(arr1, arr3)) {
			System.out.println("descending");
		} else {
			System.out.println("mixed");
		}

	}

}
