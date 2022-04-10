package d1;

import java.util.Scanner;

public class Problem2068 {

	// 최대수 구하기
    public static void main(String[] args) {
 
        // Scanner 생성
        Scanner scan = new Scanner(System.in);
 
        // 테스트케이스 입력받아 저장
        int testCase = scan.nextInt();
 
        // 각 테스트 케이스별 최댓값을 저장할 배열 생성
        int[] maxArr = new int[testCase];
 
        // 초기 최댓값은 0
        // 입력받은 값과 현재 최댓값을 비교해 더 큰 값을 최댓값 변수에 저장한 후
        // 최종 최댓값을 최댓값 저장 배열에 입력
        for (int i = 0; i < testCase; i++) {
            int max = 0; // 초기 최댓값
 
            // 입력값과 현재 최댓값 비교
            for (int j = 0; j < 10; j++) {
                int num = scan.nextInt(); // 값 입력
 
                // 현재 최댓값보다 입력값이 크면 그 값으로 대체
                if (max < num) {
                    max = num;
                }
            }
 
            // 최댓값 저장 배열에 저장
            maxArr[i] = max;
        }
 
        // 출력 양식에 맞춰 테스트 케이스별 최댓값 출력
        for (int i = 0; i < testCase; i++) {
            System.out.println("#" + (i + 1) + " " + maxArr[i]);
        }
 
        // Scanner 종료
        scan.close();
 
    }
	
}
