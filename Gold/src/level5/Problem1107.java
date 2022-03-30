package level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1107 {

	// 1107. 리모컨
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 이동하려는 채널
		int targetChannel = Integer.parseInt(br.readLine());
		// 고장난 버튼의 개수
		int brokenNum = Integer.parseInt(br.readLine());

		// 버튼의 고장 여부를 저장할 배열
		int[] brokenBtn = new int[10];

		// 고장난 버튼이 있으면 배열에 저장
		if (brokenNum > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < brokenNum; i++) {
				brokenBtn[Integer.parseInt(st.nextToken())] = 1;
			}
		}

		// 100번에서 원하는 채널로 이동하는 횟수를 초기값으로 설정
		int count = Math.abs(targetChannel - 100);

		// 0번부터 999999번 채널까지 돌면서 최소 횟수를 얻을 수 있는 채널을 찾음
		Outer: for (int channel = 0; channel < 1000000; channel++) {
			// 현재 채널을 문자열로 입력
			String name = String.valueOf(channel);
			// 현재 채널로 목표 채널에 갈 때 필요한 이동 횟수
			int temp = 0;

			// 현재 채널 숫자 중 고장난 버튼의 숫자가 있으면 건너뛰기
			for (int i = 0; i < name.length(); i++) {
				if (brokenBtn[name.charAt(i) - '0'] == 1) {
					continue Outer;
				}
			}

			// 고장난 버튼이 없으면
			// 현재 채널의 길이에
			temp += name.length();
			// +, - 버튼을 누를 횟수를 더해서 temp에 저장
			temp += Math.abs(targetChannel - channel);

			// 지금 채널로 구한 temp 값이 현재 저장된 count 값보다 작으면 변경
			if (temp < count) {
				count = temp;
			}
		}
		// 결과 출력
		System.out.println(count);

	}

}
