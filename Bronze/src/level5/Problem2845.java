package level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2845 {

	// 2845. 파티가 끝나고 난 뒤
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st1 = new StringTokenizer(br.readLine());

		int person = Integer.parseInt(st1.nextToken());
		int space = Integer.parseInt(st1.nextToken());
		long total = person * space;

		StringTokenizer st2 = new StringTokenizer(br.readLine());

		for (int i = 0; i < 5; i++) {
			int news = Integer.parseInt(st2.nextToken());
			sb.append(news - total).append(" ");
		}

		System.out.println(sb);

	}

}
