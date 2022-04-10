package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Problem1983 {

	// 1983. 조교의 성적 매기기
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 개수 입력
		int testCase = Integer.parseInt(br.readLine());

		// 입력한 테스트 케이스 개수만큼 반복
		for (int test = 1; test <= testCase; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			// 학생 수
			int stdNum = Integer.parseInt(st.nextToken());
			// 점수 조회 학생 번호
			int findStd = Integer.parseInt(st.nextToken());

			// 학생별 점수 저장 배열
			double[][] scoreArr = new double[stdNum][3];

			// 점수를 계산한 후 배열에 저장하는 반복문
			for (int std = 1; std <= stdNum; std++) {
				st = new StringTokenizer(br.readLine());

				// 점수 입력
				double mid = Double.parseDouble(st.nextToken());
				double fin = Double.parseDouble(st.nextToken());
				double hw = Double.parseDouble(st.nextToken());

				// 환산 점수 계산
				double score = mid * 0.35 + fin * 0.45 + hw * 0.2;

				// 배열에 학번과 점수 저장
				scoreArr[std - 1][0] = std;
				scoreArr[std - 1][1] = score;
			}

			// 총점 오름차순으로 정렬
			Arrays.sort(scoreArr, new Comparator<double[]>() {

				@Override
				public int compare(double[] o1, double[] o2) {
					return Double.compare(o2[1], o1[1]);
				}
			});

			// 학생별 학점 입력
			int grade = 1;
			int sameGrade = stdNum / 10;

			for (int i = 1; i <= stdNum; i++) {
				scoreArr[i - 1][2] = grade;

				if (i % sameGrade == 0) {
					grade++;
				}
			}

			// 학생의 학점 출력
			int resultGrade = 0;
			for (int i = 0; i < stdNum; i++) {
				if (scoreArr[i][0] == findStd) {
					resultGrade = (int) scoreArr[i][2];
					break;
				}
			}

			sb.append("#").append(test).append(" ");

			switch (resultGrade) {
			case 1:
				sb.append("A+").append('\n');
				break;
			case 2:
				sb.append("A0").append('\n');
				break;
			case 3:
				sb.append("A-").append('\n');
				break;
			case 4:
				sb.append("B+").append('\n');
				break;
			case 5:
				sb.append("B0").append('\n');
				break;
			case 6:
				sb.append("B-").append('\n');
				break;
			case 7:
				sb.append("C+").append('\n');
				break;
			case 8:
				sb.append("C0").append('\n');
				break;
			case 9:
				sb.append("C-").append('\n');
				break;
			case 10:
				sb.append("D0").append('\n');
				break;
			}

		}

		System.out.println(sb);

	}

}
