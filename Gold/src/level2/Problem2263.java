package level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2263 {

	static int n;
	static int[] in, post, pre;
	static int idx;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		in = new int[n];
		post = new int[n];
		pre = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			in[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			post[i] = Integer.parseInt(st.nextToken());

		makePre(0, n - 1, 0, n - 1);

		for (int n : pre)
			System.out.print(n + " ");

	}

	public static void makePre(int is, int ie, int ps, int pe) {

		if (is <= ie && ps <= pe) {

			pre[idx++] = post[pe];

			int pos = is;
			for (int i = is; i <= ie; i++) {
				if (in[i] == post[pe]) {
					pos = i;
					break;
				}
			}

			makePre(is, pos - 1, ps, ps + pos - is - 1);
			makePre(pos + 1, ie, ps + pos - is, pe - 1);
		}
	}

}
