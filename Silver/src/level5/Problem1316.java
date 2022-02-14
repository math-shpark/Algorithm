package level5;

import java.util.Scanner;

public class Problem1316 {

	// 1316. 그룹 단어 체커
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 단어 개수 입력
		int words = scan.nextInt();
		// 그룹 단어 개수 저장할 변수
		int count = 0;

		// 입력한 단어의 개수만큼 반복
		for (int i = 0; i < words; i++) {

			// 그룹단어인지 여부 저장 변수
			boolean isGroupWord = true;

			// 단어 입력
			String str = scan.next();
			// 해당 글자가 나왔는지 여부를 저장할 배열
			boolean[] alphabet = new boolean[26];

			// 첫 글자는 비교 대상이 없으므로 나온 적이 있다는 것을 입력
			alphabet[str.charAt(0) - 'a'] = true;

			// 해당 글자가 이전 글자와 다를 경우
			// 이전에 나왔는지 여부에 대한 배열 값이 false면 true로 바꾸고
			// 이미 나온 적이 있어서 true 상태면 그룹 단어가 아니므로 isGroupWord를 false로 변경
			for (int j = 1; j < str.length(); j++) {
				if (str.charAt(j) != str.charAt(j - 1)) {
					if (alphabet[str.charAt(j) - 'a'] == false) {
						alphabet[str.charAt(j) - 'a'] = true;
					} else {
						isGroupWord = false;
					}
				}
			}

			// 그룹 단어면 개수에 추가
			if (isGroupWord) {
				count++;
			}

		}

		// 결과 출력
		System.out.println(count);

		// Scanner 종료
		scan.close();

	}

}
