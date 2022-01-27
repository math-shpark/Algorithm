package level1;

import java.util.Scanner;

public class Problem1546 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// 과목 수
		int subjectCount = scan.nextInt();

		// 점수 저장할 배열 생성
		int[] scores = new int[subjectCount];

		// 입력 값 배열에 저장
		for (int i = 0; i < scores.length; i++) {
			scores[i] = scan.nextInt();
		}

		// 최대 점수 저장할 변수
		double max = 0;

		// 최대 점수 구하는 반복문
		for (int i = 0; i < scores.length; i++) {
			if (scores[i] > max) {
				max = scores[i];
			}
		}

		// 새로운 점수를 저장할 변수
		double[] newScores = new double[subjectCount];

		// 새로운 점수를 입력하는 반복문
		for (int i = 0; i < newScores.length; i++) {
			newScores[i] = (scores[i] / max) * 100;
		}

		// 점수 합을 저장할 변수
		double sum = 0;

		// 새로운 점수가 저장된 배열의 데이터들을 더하는 반복문
		for (double score : newScores) {
			sum += score;
		}

		// 평균 계산
		double avg = sum / newScores.length;

		// 결과 출력
		System.out.println(avg);

		scan.close();

	}

}
