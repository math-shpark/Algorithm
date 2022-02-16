package level3;

import java.util.Scanner;

public class Problem2805 {

	// 2805. 나무 자르기
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// 나무 개수 입력
		int treeNum = scan.nextInt();

		// 원하는 높이 입력
		int height = scan.nextInt();

		// 나무 높이를 저장할 배열
		int[] tree = new int[treeNum];

		// 범위 최솟값
		int min = 0;
		// 범위 최댓값
		int max = 0;

		// 입력 값을 배열에 대입하는 반복문
		for (int i = 0; i < treeNum; i++) {
			tree[i] = scan.nextInt();

			// 최댓값 계산
			if (max < tree[i]) {
				max = tree[i];
			}

		}

		while (min < max) {

			// 중간 위치 설정
			int mid = (min + max) / 2;
			// 자른 나무 길이 더한 값을 저장할 변수
			long sum = 0;

			// 중간 지점을 기준으로 잘리는 길이 더하는 반복문
			for (int treeHeight : tree) {

				// 중간 지점보다 높은 나무만 더함
				if (treeHeight - mid > 0) {
					sum += (treeHeight - mid);
				}

			}

			// 자른 나무 길이가 부족한 경우 자른 위치를 더 낮춰야 함
			// 중간 값을 계산할 범위를 낮춤
			if (sum < height) {
				max = mid;
			} else {
				min = mid + 1; // 자른 나무 길이가 충분한 경우 자른 높이를 더 높여야 함
			}
		}

		System.out.println(min - 1);

		scan.close();

	}

}
