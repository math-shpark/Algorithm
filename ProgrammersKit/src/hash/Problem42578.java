package hash;

import java.util.HashMap;
import java.util.Set;

public class Problem42578 {

	// 42578. 위장
	public static void main(String[] args) {
		String[][] clothes = { { "yellowhat", "headgear" }, { "bluesunglasses", "eyewear" },
				{ "green_turban", "headgear" } };

		int answer = solution(clothes);

		System.out.println(answer);
	}

	private static int solution(String[][] clothes) {
		int answer = 1;
		HashMap<String, Integer> clothMap = new HashMap<>(); // 카테고리별 옷 저장

		for (int r = 0; r < clothes.length; r++) {
			String category = clothes[r][1];

			if (clothMap.containsKey(category))
				clothMap.put(category, clothMap.get(category) + 1);
			else
				clothMap.put(category, 1);
		}

		Set<String> keySet = clothMap.keySet();

		for (String category : keySet) {
			answer *= clothMap.get(category) + 1;
		}
		return answer - 1;
	}

}
