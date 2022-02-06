package level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1110 {

	// 1110. 더하기 사이클
	public static void main(String[] args) throws IOException {

		// 입력 스트림 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 초기 입력 숫자 저장
		String num = br.readLine();
		// 입력한 숫자를 자리마다 별도로 배열에 저장
		String[] numArr = new String[2];

		// 두자리수인지 여부에 따라 배열 저장
		if (Integer.parseInt(num) < 10) {
			numArr[0] = "0"; // 한 자리수면 십의 자리에 0을 저장
			numArr[1] = num; // 일의 자리에 입력한 숫자 저장
			num = "0" + num; // 입력한 숫자를 0X형태로 변환
		} else {
			numArr = num.split(""); // 두 자리수이면 입력한 숫자를 바로 쪼개어 저장
		}

		// 싸이클 길이를 저장할 변수 생성
		// 바로 자기 자신이 나와도 1 사이클이므로
		// 초기값은 1로 설정
		int count = 1;

		// 원래 숫자가 될 때까지 무한 반복
		while (true) {

			// 각 자리 숫자를 더한 값을 저장할 변수 선언
			// 새로운 숫자의 합을 다시 저장하기 위해
			// 반복문이 다시 시작하면 덧셈 결과는 0으로 다시 초기화하여 반복 실행
			int sum = 0;

			// String 타입으로 배열에 저장된 것을 정수 타입으로 변환한 후 더한 값을 저장
			for (int i = 0; i < 2; i++) {
				sum += Integer.parseInt(numArr[i]);
			}

			// 더한 결과를 문자열 타입으로 변환
			String sumStr = String.valueOf(sum);
			// 덧셈 결과의 각 자리 숫자를 별도로 배열에 저장
			String[] sumArr = sumStr.split("");

			// 입력한 숫자의 일의 자리를 십의 자리로
			// 덧셈 결과의 일의 자리를 일의 자리로
			// 문자열 연결로 새로운 숫자 생성
			String newNum = numArr[1] + sumArr[sumArr.length - 1];

			// 새로운 숫자가 입력 숫자와 같으면
			// 지금까지 사이클 횟수를 출력하고
			// 반복문 종료
			if (num.equals(newNum)) {
				System.out.println(count);
				break;
			} else {
				// 입력 숫자와 다르면
				// 사이클 횟수를 추가하고
				// 입력 숫자 자리에 새로운 숫자를 대체한 후
				// 반복문 다시 실행
				numArr = newNum.split("");
				count++;
			}

		}

	}

}
