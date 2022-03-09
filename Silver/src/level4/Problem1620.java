package level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem1620 {

	// 1620. 나는야 포켓몬 마스터 이다솜
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 이름 개수
		int N = Integer.parseInt(st.nextToken());
		// 맞출 문제 개수
		int M = Integer.parseInt(st.nextToken());

		// 포켓몬 이름의 번호를 저장할 맵
		HashMap<String, Integer> indexList = new HashMap<>();
		// 해당 번호에 포켓몬 이름을 저장할 배열
		String[] nameList = new String[N + 1];

		// 맵과 배열에 이름과 번호를 저장하는 반복문
		for (int i = 1; i < N + 1; i++) {
			String name = br.readLine();
			indexList.put(name, i);
			nameList[i] = name;
		}

		// 문제를 맞추는 반복문
		for (int i = 0; i < M; i++) {
			// 문제 내용을 입력받아서
			String search = br.readLine();
			try {
				// 정수로 변환가능하면 index로 저장해서
				int index = Integer.parseInt(search);
				// 해당 index의 데이터를 출력하고
				sb.append(nameList[index]).append('\n');
			} catch (NumberFormatException e) {
				// 숫자 변환이 불가하면 이름이 입력받은 것이므로
				// 해당 이름의 인덱스를 출력
				sb.append(indexList.get(search)).append('\n');
			}
		}

		// 결과 출력
		System.out.println(sb);

	}

}
