package level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1259 {

	// 1259. 팰린드롬수
	public static void main(String[] args) throws NumberFormatException, IOException {

		// 입력 스트림 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 0을 입력할 때까지 무한 반복
		while (true) {
			// 숫자를 문자열로 입력
			String num = br.readLine();

			// 팰린드롬 수인지 여부를 저장할 변수
			boolean isPal = true;

			// 0을 입력한 경우 반복문 종료
			if (num.equals("0")) {
				break;
			}

			// 입력한 문자열이 팰린드롬 수인지 판별하는 반복문
			for (int i = 0; i < num.length() / 2; i++) {
				// 팰린드롬 수가 아니면 false를 반환하고
				// 반복문 종료
				if (num.charAt(i) != num.charAt(num.length() - i - 1)) {
					isPal = false;
					break;
				}

				// 팰린드롬 수가 맞으면 true 인 상태를 유지하고
				// 반복문 종료
			}

			// 팰린드롬 수인지 여부에 따라 결과 출력
			if (isPal) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}

		}

	}

}
