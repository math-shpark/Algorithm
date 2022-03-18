package d2;

import java.util.Scanner;

public class Problem1959 {

	// 1959. 두 개의 숫자열
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 테스트 케이스 개수 입력
		int testCase = scan.nextInt();
		// 테스트 케이스별 결과 저장 배열 생성
		int[] resultSet = new int[testCase];

		// 테스트 케이스별 최대 합을 구하는 반복문
		for (int test = 0; test < testCase; test++) {
			// N과 M 입력받아 저장
			int N = scan.nextInt();
			int M = scan.nextInt();

			// N과 M 수열 데이터를 저장할 변수 생성
			int[] dataN = new int[N];
			int[] dataM = new int[M];

			// N 수열 데이터 배열에 저장
			for (int i = 0; i < N; i++) {
				dataN[i] = scan.nextInt();
			}

			// M 수열 데이터 배열에 저장
			for (int i = 0; i < M; i++) {
				dataM[i] = scan.nextInt();
			}

			// 최대 합을 저장할 변수
			int maxSum = Integer.MIN_VALUE;

			// M과 N 중 더 큰 것과 작은 것 판단
			int big = Math.max(N, M);
			int small = Math.min(N, M);

			// 이동은 작은 수열 블록을 이동
			// 이동 가능 길이는 더 큰 것의 길이에서 더 작은 것의 길이를 뺀만큼까지 가능
			for (int move = 0; move <= big - small; move++) {
				// 데이터 총합 초기화
				int dataSum = 0;

				// M 수열이 더 긴 경우
				// N 수열을 이동시킨다
				if (M >= N) {
					dataSum = move(dataM, dataN, move);
				}

				// M 수열이 더 짧은 경우
				// M 수열을 이동시킨다
				if (M < N) {
					dataSum = move(dataN, dataM, move);
				}

				// 최대합이면 값을 저장
				if (maxSum < dataSum) {
					maxSum = dataSum;
				}
			}

			// 최대합을 결과 배열에 저장
			resultSet[test] = maxSum;
		}

		// 출력 양식에 맞춰 출력
		for (int i = 0; i < testCase; i++) {
			System.out.println("#" + (i + 1) + " " + resultSet[i]);
		}

		// Scanner 종료
		scan.close();

	}

	// 데이터 합을 구하는 메소드
	static int move(int[] big, int[] small, int move) {

		// 합을 저장할 변수
		int dataSum = 0;

		// 작은 수열을 이동하며 합을 계산하는 반복문
		for (int i = 0; i < small.length; i++) {
			dataSum += small[i] * big[i + move];
		}

		return dataSum;
	}

}
