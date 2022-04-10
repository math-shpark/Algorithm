package exercise;

import java.util.Arrays;

public class MergeSort {

	// 병합 정렬 실행
	// 매개변수 : 정렬할 배열
	public static void mergeSort(int[] arr) {
		// 분할 메서드 실행
		sort(arr, 0, arr.length - 1);
	}

	// 분할
	// 매개변수 : 정렬할 배열, 분할된 상태의 가장 왼쪽 인덱스, 분할된 상태의 가장 오른쪽 인덱스
	private static void sort(int[] arr, int left, int right) {
		// 분할할 수 있으면
		if (left < right) {
			// 중간점
			int mid = (left + right) / 2;
			// 좌측 분할
			sort(arr, left, mid);
			// 우측 분할
			sort(arr, mid + 1, right);
			// 병합 메서드 실행
			merge(arr, left, mid, right);
		}
	}

	// 병합
	private static void merge(int[] arr, int left, int mid, int right) {
		// 부분 배열(값을 정렬해서 저장할 배열)
		int[] sortedArr = new int[right - left + 1];

		// 좌측 배열의 맨 앞 인덱스
		int L = left;
		// 우측 배열의 맨 앞 인덱스
		int R = mid + 1;
		// 부분 배열에 값이 들어갈 위치
		int idx = 0;

		// 오름차순 기준으로 병합
		while (L <= mid && R <= right) {
			// 좌측 배열의 맨 앞 데이터가 더 작거나 같은 경우(안정 정렬)
			if (arr[L] <= arr[R]) {
				// 정렬된 배열에 해당 값을 넣고
				// 정렬된 배열에 데이터가 들어갈 인덱스와
				// 좌측 배열의 맨 앞 데이터를 가리키는 인덱스를
				// 1씩 늘린다.
				sortedArr[idx++] = arr[L++];
			} else {
				// 우측 배열의 맨 앞 데이터가 더 작은 경우
				// 정렬된 배열에 해당 값을 넣고
				// 정렬된 배열에 데이터가 들어갈 인덱스와
				// 우측 배열의 맨 앞 데이터를 가리키는 인덱스를
				// 1씩 늘린다.
				sortedArr[idx++] = arr[R++];
			}
		}

		// 한 쪽 배열의 데이터가 이미 다 들어가서
		// 비교가 종료된 경우
		// 좌측 배열의 데이터가 남아 있는 경우
		while (L <= mid) {
			// 좌측 배열에 남아있는 데이터들을 이어서 넣는다.
			sortedArr[idx++] = arr[L++];
		}

		// 우측 배열의 데이터가 남아 있는 경우
		while (R <= right) {
			// 우측 배열에 남아있는 데이터들을 이어서 넣는다.
			sortedArr[idx++] = arr[R++];
		}

		// 정렬된 부분 배열을 해당 위치에 넣는다.
		for (int i = left; i <= right; i++) {
			arr[i] = sortedArr[i - left];
		}
	}

	// 정렬 테스트
	public static void main(String[] args) {

		// 정렬할 배열
		int[] arr = { 69, 10, 30, 2, 16, 8, 31, 22 };

		// 병합 정렬 메서드 실행
		mergeSort(arr);

		// 정렬 결과 출력
		System.out.println(Arrays.toString(arr));

	}

}
