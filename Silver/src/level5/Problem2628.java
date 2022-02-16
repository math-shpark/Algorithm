package level5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Problem2628 {

	// 2628. 종이자르기
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// 종이 가로 사이즈
		int hSize = scan.nextInt();
		// 종이 세로 사이즈
		int vSize = scan.nextInt();
		// 자를 횟수
		int sliceNum = scan.nextInt();
		// 자르는 곳의 위치를 저장할 리스트(가로)
		List<Integer> hCutList = new ArrayList<>();
		// 자르는 곳의 위치를 저장할 리스트(세로)
		List<Integer> vCutList = new ArrayList<>();

		// 자르는 곳의 위치를 저장하는 반복문
		for (int i = 0; i < sliceNum; i++) {
			int direction = scan.nextInt();
			int point = scan.nextInt();

			// 방향에 맞춰 따로 저장
			if (direction == 0) {
				hCutList.add(point);
			} else {
				vCutList.add(point);
			}
		}

		// 자르는 곳의 위치 순서가 무작위이므로
		// 저장한 위치 정보를 오름차순으로 정렬
		hCutList.sort(Comparator.naturalOrder());
		vCutList.sort(Comparator.naturalOrder());

		// 자르고 난 후 사각형들의 가로 길이를 저장할 리스트
		List<Integer> hSideLength = new ArrayList<>();
		// 자르고 난 후 사각형들의 세로 길이를 저장할 리스트
		List<Integer> vSideLength = new ArrayList<>();

		// 잘린 사각형들의 변의 길이를 저장하는 메소드
		hSideLength = sideLength(vCutList, hSideLength, hSize);
		vSideLength = sideLength(hCutList, vSideLength, vSize);

		// 변의 길이를 내림차순으로 정렬
		hSideLength.sort(Comparator.reverseOrder());
		vSideLength.sort(Comparator.reverseOrder());

		int hLength = 0;
		int vLength = 0;

		// 잘리지 않는 경우도 있음
		// 잘리지 않는 경우 변 전체 길이를 갖도록 설정
		if (hSideLength.size() == 0) {
			hLength = hSize;
		} else {
			hLength = hSideLength.get(0);
		}

		if (vSideLength.size() == 0) {
			vLength = vSize;
		} else {
			vLength = vSideLength.get(0);
		}

		// 결과 출력
		System.out.println(hLength * vLength);

		scan.close();

	}

	// 잘린 사각형의 변의 길이를 리스트에 추가하는 메소드
	public static List<Integer> sideLength(List<Integer> cutList, List<Integer> lengthList, int range) {

		for (int i = 0; i < cutList.size(); i++) {
			if (i == 0) {
				// 한 번만 자를 경우
				if (i == cutList.size() - 1) {
					lengthList.add(cutList.get(0));
					lengthList.add(range - cutList.get(0));
				} // 나머지 경우
				else {
					lengthList.add(cutList.get(0));
				}

			} else {
				lengthList.add(cutList.get(i) - cutList.get(i - 1));

				// 마지막 절취선은 벽과의 거리도 사각형의 변이 되므로
				// 해당 길이도 리스트에 추가해야 함
				if (i == cutList.size() - 1) {
					lengthList.add(range - cutList.get(cutList.size() - 1));
				}
			}
		}

		return lengthList;
	}

}
