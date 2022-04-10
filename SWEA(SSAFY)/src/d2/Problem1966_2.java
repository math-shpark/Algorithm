package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1966_2 {

	// 퀵 정렬 Hoare
	private static void quickSort(int[] arr) {

		sort(arr, 0, arr.length - 1);

	}

	// 분할
	private static void sort(int[] arr, int left, int right) {

		if (left < right) {
			int pivot = partition(arr, left, right);
			sort(arr, left, pivot - 1);
			sort(arr, pivot + 1, right);
		}

	}

	// 정렬
	private static int partition(int[] arr, int left, int right) {

		// 입력한 부분 배열의 가장 좌측 인덱스를 pivot으로 설정
		int pivot = arr[left];

		// 좌측부터 출발할 인덱스
		int L = left + 1;
		// 우측부터 출발할 인덱스
		int R = right;

		// 교차하기 전까지 반복
		while (L <= R) {
			// 좌측부터 출발한 인덱스 위치의 값이
			// 기준값보다 작거나 같으면
			// 기준값은 그 값보단 오른쪽에 위치해야 하므로
			while (L <= R && arr[L] <= pivot) {
				// 비교 대상 인덱스를 오른쪽으로 1칸 이동
				L++;
			}

			// 우측부터 출발한 인덱스 위치의 값이
			// 기준값보다 크면
			// 기준값은 그 값보단 왼쪽에 위치해야 하므로
			while (arr[R] > pivot) {
				// 비교 대상 인덱스를 왼쪽으로 1칸 이동
				R--;
			}

			// 좌측부터 출발해 찾은 기준점이 가야 할 위치와
			// 우측부터 출발해 찾은 기준점이 가야 할 위치 사이에 데이터가 존재하면
			// 좌측부터 출발해 찾은 위치의 데이터는 기준점보다 우측에 위치해야 하고
			// 우측부터 출발해 찾은 위치의 데이터는 기준점보다 좌측에 있어야 하므로
			// 각 위치의 데이터를 swap 한다.
			if (L < R) {
				int temp = arr[L];
				arr[L] = arr[R];
				arr[R] = temp;
			}

			// 만일 위의 if 문에서 걸려서 swap이 이루어졌으면
			// 현재 L 인덱스 위치에는 기준값보다 작거나 같은 값이
			// R 인덱스 위치에는 기준값보다 큰 값이 들어가 있는 상태이므로
			// 위에서 진행한 L과 R 값의 이동을 다시 진행한다.

			// 만일 위의 if 문에서 걸리지 않았으면
			// 현재 L 인덱스 위치에는 기준값보다 큰 값이
			// R 인덱스 위치에는 기준값보다 작거나 같은 값이 들어가 있고
			// L과 R이 교차되어 있는 상태로 while 문이 종료된다.
		}

		// 기준점이 들어갈 자리는 R 인덱스로 가야하므로 swap 한다.
		int temp = arr[left];
		arr[left] = arr[R];
		arr[R] = temp;

		return R;
	}

	// 정렬 테스트
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int testCase = Integer.parseInt(br.readLine());

		for (int test = 1; test <= testCase; test++) {
			int N = Integer.parseInt(br.readLine());

			int[] arr = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			quickSort(arr);

			sb.append("#").append(test).append(" ");

			for (int num : arr) {
				sb.append(num).append(" ");
			}
			sb.append('\n');
		}

		System.out.println(sb);

	}

}
