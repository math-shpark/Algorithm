package level3;

import java.util.Scanner;

public class Problem1244 {

	// 1244. 스위치 켜고 끄기
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 스위치 개수
		int switchNum = scan.nextInt();
		// 스위치 상태 저장 배열
		int[] status = new int[switchNum];

		// 스위치 상태를 배열에 저장
		for (int i = 0; i < switchNum; i++) {
			status[i] = scan.nextInt();
		}

		// 학생 수 입력
		int stdNum = scan.nextInt();

		// 학생 정보에 따른 스위치 상태 변경 반복문
		for (int i = 0; i < stdNum; i++) {
			// 성별
			int gender = scan.nextInt();
			// 학생에게 줄 숫자
			int num = scan.nextInt();

			if (gender == 1) {
				for (int j = 0; j < status.length; j++) {
					if ((j + 1) % num == 0) {
						status[j] = status[j] == 0 ? 1 : 0;
					}
				}
			} else {
				status[num - 1] = status[num - 1] == 0 ? 1 : 0;
				for (int j = 0; j < switchNum / 2; j++) {
					// 범위 밖이면 반복문 종료
					if (num - 1 + j >= switchNum || num - 1 - j < 0) {
						break;
					}
					// 대칭이면 스위치 전환
					if (status[num - 1 - j] == status[num - 1 + j]) {
						status[num - 1 - j] = status[num - 1 - j] == 0 ? 1 : 0;
						status[num - 1 + j] = status[num - 1 + j] == 0 ? 1 : 0;
					} else {
						break; // 대칭이 아니고 범위 내면 반복문 종료
					}
				}
			}
		}

		// 결과 출력
		for (int i = 0; i < switchNum; i++) {
			System.out.print(status[i] + " ");

			// 한 줄에 20개만 출력하도록 줄바꿈
			if ((i + 1) % 20 == 0) {
				System.out.println();
			}
		}

		// Scanner 종료
		scan.close();

	}

}
