package list1;

public class GreedyAlgorithm {

	public static void main(String[] args) {

//		int[] arr = { 4, 4, 3, 4, 4, 5 };
//		int[] arr = { 0, 5, 4, 0, 6, 0 };
//		int[] arr = { 1, 0, 1, 1, 2, 3 };
		int[] arr = { 0, 1, 2, 6, 7, 8 };

		// 입력한 숫자의 최대값을 저장할 변수
		int maxVal = 0;
		// Baby-Gin인지 여부를 저장할 변수
		boolean isBabyGin = false;

		// 입력한 숫자의 최대값을 찾는 반복문
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > maxVal) {
				maxVal = arr[i];
			}
		}

		// 입력한 숫자의 최댓값의 1만큼을 더한 크기의 배열 생성(0을 포함하기 때문)
		// 입력한 숫자의 입력 횟수를 저장할 배열
		int[] count = new int[maxVal + 1];

		// 입력한 숫자가 몇 번 나왔는지 배열에 저장하는 반복문
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}

		// 6개의 숫자가 모두 run인지 여부를 저장할 변수
		int isAllRun = 0;

		// run을 찾아 해당 데이터를 삭제
		for (int i = 0; i < count.length - 2; i++) {
			if (count[i] != 0 && count[i + 1] != 0 && count[i + 2] != 0) {
				count[i]--;
				count[i + 1]--;
				count[i + 2]--;

				isAllRun++;
			}
		}

		// run이 2개여도 baby-gin이므로 참 반환
		if (isAllRun == 2) {
			isBabyGin = true;
		}

		// 남은 숫자로 triplet이 되는지 여부를 찾는 반복문
		for (int i = 0; i < count.length; i++) {
			if (count[i] == 3) {
				isBabyGin = true;
			}
		}

		// 결과 출력
		System.out.println(isBabyGin);

	}

}
