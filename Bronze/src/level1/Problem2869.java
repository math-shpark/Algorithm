package level1;

import java.util.Scanner;

public class Problem2869 {

	// 2869. 달팽이는 올라가고 싶다
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);
		
		// 올라가는 높이
		int up = scan.nextInt();
		// 미끄러지는 높이
		int down = scan.nextInt();
		// 나무 막대기 길이
		int height = scan.nextInt();
		
		// 올라간 높이
		int sum = 0;
		// 올라간 기간
		int day = 1;
		
		// 정상에 올라갈 때까지 반복하는 반복문
		while(true) {
			
			// 낮에 올라간 높이 더하기
			sum += up;
			
			// 정상에 도달하지 못한 경우
			// 밤에 미끄러지는 만큼 차감
			// 일수 추가
			if(height > sum) {
				sum -= down;
				day++;
			} else {
				break; // 낮에 올라간 높이가 막대기 정상에 닿으면 차감없이 반복문 종료
			}
			
		}
		
		// 결과 출력
		System.out.println(day);
		
		// 끝내기
		scan.close();
		
	}

}
