package level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1541 {

	// 1541. 잃어버린 괄호
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 식을 문자열로 읽기
		String equation = br.readLine();
		// 주어진 식을 -기호를 기준으로 분리하여 배열에 저장
		String[] separate = equation.split("-");
		// - 기호를 기준으로 나뉜 식들은 +만 있으므로 해당 식의 결과들을 저장할 배열 생성
		int[] numArr = new int[separate.length];

		for (int i = 0; i < separate.length; i++) {

			try {
				// 숫자만 있는 경우
				// 숫자로 변환한 후 numArr 배열에 저장
				int num = Integer.parseInt(separate[i]);
				numArr[i] = num;
			} catch (Exception e) {
				// 식으로 구성된 경우
				// +기호로 분리한 후
				// 각 숫자를 모두 더한 값을 numArr에 저장
				String[] num = separate[i].split("\\+");
				for (int j = 0; j < num.length; j++) {
					numArr[i] += Integer.parseInt(num[j]);
				}
			}

		}

		// 최솟값을 저장할 변수
		int minVal = numArr[0];

		// 최솟값을 구하기 위해서는 최대한 큰 수를 빼야 함
		// - 기호를 기준으로 식을 나눠 최대한 큰 수를 얻도록 더한 후
		// 그 결과들을 모두 빼주면 최솟값을 얻을 수 있음
		for (int i = 1; i < numArr.length; i++) {
			minVal -= numArr[i];
		}

		// 결과 출력
		System.out.println(minVal);

	}

}
