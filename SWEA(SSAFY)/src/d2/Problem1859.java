package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1859 {

	// 1859. 백만 장자 프로젝트
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 입력 스트림 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 테스트 케이스 개수 입력
        int testCase = Integer.parseInt(br.readLine());
 
        // 입력한 개수만큼 반복
        for (int test = 1; test <= testCase; test++) {
            // 자연수 개수 입력
            int N = Integer.parseInt(br.readLine());
            // 주어진 자연수 읽기
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 가격 정보 배열 생성
            int[] price = new int[N];
            // 이득을 저장할 변수
            long benefit = 0;
 
            // 배열에 정보 저장
            for (int i = 0; i < N; i++) {
                price[i] = Integer.parseInt(st.nextToken());
            } // 저장 종료
 
            // 미래에 지금보다 가격이 더 높은지 알아야 하므로
            // 뒤에서부터 가격을 탐색하며 물품을 구매
            // 뒤에서부터 최대 가격을 업데이트하며 0번 인덱스까지 도달
 
            // 현재 최대값을 저장할 변수
            int tempMax = price[N - 1];
 
            // 탐색 시작
            for (int i = N - 1; i >= 0; i--) {
                // 미래 값이 더 크거나 같으면 물품을 사고
                // 차익을 취함
                if (price[i] <= tempMax) {
                    benefit += tempMax - price[i];
                }
                // 지금 값이 더 크면 최대 가격을 업데이트 함
                else {
                    tempMax = price[i];
                }
            } // 탐색 종료
 
            // 결과 출력
            // StringBuilder 생성
            StringBuilder sb = new StringBuilder();
            // 출력 양식에 맞춤
            sb.append("#").append(test).append(" ").append(benefit);
            // 출력
            System.out.println(sb);
        } // 테스트 케이스 반복 종료
    }
	
}
