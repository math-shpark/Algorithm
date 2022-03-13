package level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem17219 {

	// 17219. 비밀번호 찾기
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 비밀번호를 저장할 홈페이지 개수
		int site = Integer.parseInt(st.nextToken());
		// 비밀번호를 찾을 홈페이지 개수
		int findSite = Integer.parseInt(st.nextToken());

		// 홈페이지별 비밀번호를 저장할 맵
		HashMap<String, String> passwordMap = new HashMap<>();

		// 홈페이지와 비밀번호를 저장하는 반복문
		for (int i = 0; i < site; i++) {
			st = new StringTokenizer(br.readLine());
			passwordMap.put(st.nextToken(), st.nextToken());
		}

		// 비밀번호를 찾아서 결과 문자열에 추가하는 반복문
		for (int i = 0; i < findSite; i++) {
			sb.append(passwordMap.get(br.readLine())).append('\n');
		}

		// 결과 출력
		System.out.println(sb);

	}

}
