package level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Problem1181 {

	// 1181. 단어 정렬
	public static void main(String[] args) throws NumberFormatException, IOException {

		// 입력스트림 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 단어의 개수 입력
		int words = Integer.parseInt(br.readLine());

		// 입력받은 개수 크기의 배열 생성
		String[] list = new String[words];

		// 단어를 배열에 저장
		for (int i = 0; i < words; i++) {
			list[i] = br.readLine();
		}

		// 정렬하는 구문
		Arrays.sort(list, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				// 길이가 같으면
				if (s1.length() == s2.length()) {
					// 사전순으로 정렬하고
					return s1.compareTo(s2);
				} else {
					// 길이가 다르면 길이가 짧은 순으로 정렬
					// 양수가 반환되면 자리가 바뀌므로
					// 길이가 짧은 단어가 앞으로 오게 됨
					return s1.length() - s2.length();
				}
			}
		});

		// 결과를 출력하는 반복문
		for (int i = 0; i < words; i++) {
			// 만일 다음 단어와 같으면 해당 단어는 출력을 건너뜀
			if (i < words - 1 && list[i].equals(list[i + 1])) {
				continue;
			}

			System.out.println(list[i]);
		}

	}

}
