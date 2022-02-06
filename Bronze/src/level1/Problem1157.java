package level1;

import java.io.IOException;
import java.util.Scanner;

public class Problem1157 {

	// 1157. 단어 공부
	public static void main(String[] args) throws IOException {

		Scanner scan = new Scanner(System.in);

		// 영단어 26개 크기의 배열 생성
		int[] alphabet = new int[26];

		// 단어 입력
		String word = scan.next();

		// 유니코드 값을 배열에 저장
		// i번째 인덱스의 유니코드 값으로 대소문자 구분
		for (int i = 0; i < word.length(); i++) {

			if ('A' <= word.charAt(i) && word.charAt(i) <= 'Z') {
				alphabet[word.charAt(i) - 'A']++;
			} else {
				alphabet[word.charAt(i) - 'a']++;
			}
		}

		int max = -1; // 글자 반복 횟수 저장
		char out = 'a'; // 결과 출력할 유니코드

		for (int i = 0; i < 26; i++) {
			if (alphabet[i] > max) {
				max = alphabet[i];
				out = (char) (i + 65); // A의 유니코드 값 = 65
			} else if (alphabet[i] == max) {
				out = '?';
			}
		}

		// 결과 출력
		System.out.print(out);

		scan.close();

	}

}
