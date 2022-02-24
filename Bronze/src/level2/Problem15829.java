package level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem15829 {

	// 15829. Hashing
	public static void main(String[] args) throws NumberFormatException, IOException {

		// 입력 스트림 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 문자열 길이 입력
		int L = Integer.parseInt(br.readLine());
		// 문자열 입력
		String str = br.readLine();

		// 해쉬값
		long H = 0;
		// 거듭제곱
		long r = 31;

		// 해쉬함수 적용
		for (int i = 0; i < L; i++) {
			int num = str.charAt(i) - 'a' + 1;
			if (i == 0) {
				H += num;
			} else {
				// 전체의 나머지를 취하면
				// 전체 값이 범위를 벗어날 수 있으므로
				// 사전에 나머지만 취해 범위를 벗어나지 않게 함
				H += (num * r) % 1234567891;
				r = r * 31 % 1234567891;
			}

		}

		// 결과 출력
		System.out.println(H % 1234567891);

	}

}
