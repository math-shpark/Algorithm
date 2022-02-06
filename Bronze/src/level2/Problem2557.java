package level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2557 {

	// 2557. 숫자의 개수
	public static void main(String[] args) throws IOException {

		// 입력 스트림 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력받는 3개의 숫자 저장
		int num1 = Integer.parseInt(br.readLine());
		int num2 = Integer.parseInt(br.readLine());
		int num3 = Integer.parseInt(br.readLine());

		// 입력받은 수 곱한 후 저장
		int multiple = num1 * num2 * num3;

		// 곱한 결과를 문자열 타입으로 변환
		String number = String.valueOf(multiple);

		// 문자열 타입으로 표현된 결과값을 한자리씩 잘라서 배열에 저장
		String[] numSet = number.split("");

		// 숫자별 나온 개수를 저장할 배열 생성
		int[] nums = new int[10];

		// 한자리씩 저장된 배열의 값을 하나씩 값을 비교하여 해당 숫자의 개수 증가시키는 반복문
		for (int i = 0; i < numSet.length; i++) {
			switch (numSet[i]) {
			case "0":
				nums[0]++;
				break;
			case "1":
				nums[1]++;
				break;
			case "2":
				nums[2]++;
				break;
			case "3":
				nums[3]++;
				break;
			case "4":
				nums[4]++;
				break;
			case "5":
				nums[5]++;
				break;
			case "6":
				nums[6]++;
				break;
			case "7":
				nums[7]++;
				break;
			case "8":
				nums[8]++;
				break;
			case "9":
				nums[9]++;
				break;
			default:
				break;
			}
		}

		// 0부터 나온 개수 출력
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}

	}

}
