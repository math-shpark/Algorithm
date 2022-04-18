package level1;

public class Problem72410 {

	// 72410. 신규 아이디 추천
	public static void main(String[] args) {

		String new_id = "abcdefghijklmn.p";

		String answer = solution(new_id);

		System.out.println(answer);

	}

	private static String solution(String new_id) {
		String answer = "";

		// 1. 모두 소문자로
		String change = new_id.toLowerCase();

		// 2. 맞지 않는 문자 모두 제거
		change = change.replaceAll("[^-_.a-z0-9]", "");

		// 3. 마침표 연속 2개는 1개로 치환
		change = change.replaceAll("[.]{2,}", ".");

		// 4. 마침표가 처음이나 마지막에 있으면 제거
		change = change.replaceAll("^[.]|[.]$", "");

		// 5. 빈 아이디면 a 대입
		if (change.equals(""))
			change += "a";

		// 6. 16자 이상이면 앞의 15자리로만 구성
		if (change.length() >= 16) {
			change = change.substring(0, 15);
			// 제거한 후 마지막이 .이면 제거
			change = change.replaceAll("[.]$", "");
		}

		// 7. 길이가 2자 이하면 마지막 글자 채우기
		if (change.length() <= 2)
			while (change.length() != 3)
				change += change.charAt(change.length() - 1);

		answer = change;
		return answer;
	}

}
