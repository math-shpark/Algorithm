package level2;

import java.util.Scanner;

public class Problem13300 {

	// 13300. 방배정
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 학생 수 입력
		int student = scan.nextInt();
		// 최대 수용 가능 인원 입력
		int maxMember = scan.nextInt();
		// 학년별 여학생 수를 저장할 배열
		int[] women = new int[6];
		// 학년별 남학생 수를 저장할 배열
		int[] men = new int[6];

		// 학년별 학생 수를 성별에 맞춰 배열에 저장하는 반복문
		for (int i = 0; i < student; i++) {
			int sex = scan.nextInt();
			int grade = scan.nextInt() - 1;

			if (sex == 0) {
				women[grade]++;
			} else {
				men[grade]++;
			}
		}

		// 필요한 방의 개수를 저장할 변수
		int room = 0;

		// 여학생 방 배정에 필요한 방의 개수를 구하는 반복문
		// 최대 수용 인원으로 나누어 떨어지지 않으면 방 1개만 추가하면 됨
		for (int i = 0; i < 6; i++) {
			if (women[i] % maxMember == 0) {
				room += women[i] / maxMember;
			} else {
				room += women[i] / maxMember + 1;
			}
		}

		// 남학생 방 배정에 필요한 방의 개수를 구하는 반복문
		for (int i = 0; i < 6; i++) {
			if (men[i] % maxMember == 0) {
				room += men[i] / maxMember;
			} else {
				room += men[i] / maxMember + 1;
			}
		}

		// 결과 출력
		System.out.println(room);

		// Scanner 종료
		scan.close();

	}

}
