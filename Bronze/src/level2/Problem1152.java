package level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1152 {

	// 1152. 단어의 개수
	public static void main(String[] args) throws IOException {

		// 입력 스트림 호출
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력 문장 받기
		String str = br.readLine();

		// 공백만 입력한 경우 0을 출력하고 메소드 종료
		if (str.equals(" ")) {
			System.out.println(0);
			return;
		}

		// 입력 문장을 공백 기준으로 나누어서 배열에 저장
		String[] arr = str.split(" ");

		// 공백으로 시작하면 null이 아닌 공란이 0번 인덱스에 저장됨
		// 공백으로 시작하면 공백만 저장된 칸이 하나 더 있어 길이에서 1을 빼줘야 함
		if (arr[0].equals("")) {
			System.out.println(arr.length - 1);
		} else {
			System.out.println(arr.length);
		}

		// 종료
		br.close();

	}
}