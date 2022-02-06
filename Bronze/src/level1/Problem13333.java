package level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem13333 {

	// 13333. Q-인덱스
	public static void main(String[] args) throws NumberFormatException, IOException {

		// 입력 스트림 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 책의 개수 입력받아 저장
		int books = Integer.parseInt(br.readLine());
		// 참조 횟수를 저장할 리스트 생성
		List<Integer> refList = new ArrayList<>();
		// 입력한 참조 횟수 읽기
		String ref = br.readLine();
		// 입력한 값을 나누어 배열에 저장
		String[] refNums = ref.split(" ");

		// 배열에 저장한 문자열 타입을 정수형으로 변환하여 리스트에 저장
		for (int i = 0; i < books; i++) {
			refList.add(Integer.parseInt(refNums[i]));
		}

		// 오름차순으로 정렬
		refList.sort(Comparator.naturalOrder());

		// q인덱스를 저장할 변수 선언
		int qIndex = 0;

		// 반복문 종료 키워드
		boolean isQIndex = false;
		
		// 제일 낮은 참조 횟수가 책의 개수보다 크거나 같으면
		// 책의 개수가 q인덱스이므로 책의 개수 출력 후 메소드 종료
		if (refList.get(0) >= books) {
			System.out.println(books);
			return;
		}

		// 0부터 q인덱스를 찾을 때까지 1씩 늘려가며 반복
		while (!isQIndex) {

			for (int i = 0; i < books; i++) {

				if (refList.get(i) >= qIndex) {
					if ((books - i) >= qIndex && refList.get(books - qIndex - 1) <= qIndex) {
						isQIndex = true;
						break;
					} else {
						qIndex++;
						break;
					}
				}

			}

		}

		// q인덱스 출력
		System.out.println(qIndex);

	}

}
