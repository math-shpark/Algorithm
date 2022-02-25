package level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Problem10814 {

	// 10814. 나이순 정렬
	public static void main(String[] args) throws NumberFormatException, IOException {

		// 입력 스트림 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 문자열 제작
		StringBuilder sb = new StringBuilder();

		// 사람 수
		int members = Integer.parseInt(br.readLine());
		// 사람 정보를 저장할 배열
		String[][] list = new String[members][2];

		// 배열에 사람 정보 저장
		for (int i = 0; i < members; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list[i][0] = st.nextToken();
			list[i][1] = st.nextToken();
		}

		// 배열 정렬
		Arrays.sort(list, new Comparator<String[]>() {
			public int compare(String[] s1, String[] s2) {
				return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
			}
		});

		// 결과 출력
		for (int i = 0; i < members; i++) {
			sb.append(list[i][0]).append(" ").append(list[i][1]).append('\n');
		}

		System.out.println(sb);

	}

}
