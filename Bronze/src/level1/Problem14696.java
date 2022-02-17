package level1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Problem14696 {

	// 14696. 딱지놀이
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 라운드 수 입력
		int rounds = scan.nextInt();

		// 각 라운드별 계산
		for (int round = 1; round <= rounds; round++) {
			// a 학생이 내밀 그림의 수
			int A = scan.nextInt();
			// a 학생이 내민 그림 정보를 저장할 배열
			Integer[] pictureA = new Integer[A];

			// a 학생이 내민 그림 정보를 배열에 저장
			for (int i = 0; i < A; i++) {
				pictureA[i] = scan.nextInt();
			}

			// b 학생이 내밀 그림의 수
			int B = scan.nextInt();
			// b 학생이 내밀 그림의 정보를 저장할 배열
			Integer[] pictureB = new Integer[B];

			// b 학생이 내민 그림 정보를 배열에 저장
			for (int i = 0; i < B; i++) {
				pictureB[i] = scan.nextInt();
			}

			// 배열로 내림차순으로 정렬한 후
			Arrays.sort(pictureA, Collections.reverseOrder());
			Arrays.sort(pictureB, Collections.reverseOrder());

			// 더 짧은 배열의 길이만큼 반복하면서
			int range = Math.min(pictureA.length, pictureB.length);

			// 각 자리에서 더 큰 수를 가진 학생이 이기는 경기
			for (int i = 0; i < range; i++) {
				if (pictureA[i] < pictureB[i]) {
					System.out.println("B");
					break;
				} else if (pictureA[i] > pictureB[i]) {
					System.out.println("A");
					break;
				} else if (i == range - 1) {
					// 만일 짧은 배열의 원소가 긴 배열의 원소와 모두 같으면
					// 더 긴 쪽이 이기고
					// 길이가 같은 상황이었으면 무승부
					if (pictureA.length < pictureB.length) {
						System.out.println("B");
						break;
					} else if (pictureA.length > pictureB.length) {
						System.out.println("A");
						break;
					} else {
						System.out.println("D");
						break;
					}
				} else {
					continue;
				}
			}
		}

		// Scanner 종료
		scan.close();

	}

}
