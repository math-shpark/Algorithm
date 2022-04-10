package level5;

public class Problem9239 {

	// 9239. 스티브 잡숭
	public static void main(String[] args) throws Exception {
		int c;
		int n = 0, m = 0;

		while ((c = System.in.read()) > 30) {
			m *= 10;
			if (c == '.')
				m = 1;
			else
				n = n * 10 + c - 48;
		}

		if (m == 0)
			m = 1;

		long tp = 1, a, v, w;

		StringBuilder sb = new StringBuilder();

		for (; tp < 100_000_000; tp *= 10) {
			for (a = 1; a < 10; a++) {
				v = tp * a * n - a * m;
				w = 10 * m - n;
				if (w > 0 && v % w == 0 && v / w < tp && v / w >= 0)
					sb.append(a * tp + (v / w) + "\n");
			}
		}

		System.out.print(sb.length() > 0 ? sb : "No solution\n");
	}

}