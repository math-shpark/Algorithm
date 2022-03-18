package d3;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Problem7272 {

	// 7272. 안경이 없어!
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 테스트 케이스 개수 입력
		int testCase = scan.nextInt();

		// 구멍이 없는 문자열
		String noHole = "CEFGHIJKLMNSTUVWXYZ";
		// 구멍이 1개 있는 문자열
		String oneHole = "ADOPQR";

		// 구멍이 없는 문자들을 배열에 저장
		char[] noHoleArr = noHole.toCharArray();
		// 구멍이 하나 있는 문자들을 배열에 저장
		char[] oneHoleArr = oneHole.toCharArray();

		// 배열에 있는 문자들을 저장할 Set
		Set<Character> noHoleSet = new HashSet<>();
		Set<Character> oneHoleSet = new HashSet<>();

		// 배열에 있는 문자들을 Set에 저장
		for (int i = 0; i < noHoleArr.length; i++) {
			noHoleSet.add(noHoleArr[i]);
		}

		// 배열에 있는 문자들을 Set에 저장
		for (int i = 0; i < oneHoleArr.length; i++) {
			oneHoleSet.add(oneHoleArr[i]);
		}

		// 입력한 개수만큼 반복
		for (int test = 1; test <= testCase; test++) {

			// 같은지 여부를 저장할 변수
			boolean isSame = true;

			// 문자열 2개 입력
			String str1 = scan.next();
			String str2 = scan.next();

			// 길이가 다르면 다름
			if (str1.length() != str2.length()) {
				isSame = false;
			} else {
				// 길이가 같은 경우
				for (int i = 0; i < str1.length(); i++) {
					// 앞 문자열에서 B가 나온 자리에 뒤 문자열에서 B가 안나오는 경우
					if (str1.charAt(i) == 'B' && str2.charAt(i) != 'B') {
						isSame = false;
						break;
					} else if ((noHoleSet.contains(str1.charAt(i)) && !noHoleSet.contains(str2.charAt(i)))
							|| (oneHoleSet.contains(str1.charAt(i)) && !oneHoleSet.contains(str2.charAt(i)))) {
						// 동일한 자리에서 문자의 구멍의 개수가 다른 경우
						isSame = false;
						break;
					}
				}
			}

			// 동일 여부에 따라 결과 출력
			if (isSame) {
				System.out.println("#" + test + " SAME");
			} else {
				System.out.println("#" + test + " DIFF");
			}

		}

		// Scanner 종료
		scan.close();

	}

}
