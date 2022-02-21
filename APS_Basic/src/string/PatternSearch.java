package string;

public class PatternSearch {

	public static void main(String[] args) {
		char[] text = { 'T', 'h', 'e', 's', 'e', 'a', 'r', 'e', 'b', 'o', 'o', 'k', 's' };
		char[] pattern = { 'a', 'r', 'e' };
//		char[] pattern = { 'i', 's' };

		int i = 0;
		int j = 0;
		int result = -2;

		while (j < pattern.length && i < text.length) {
			if (text[i] != pattern[j]) {
				i = i - j;
				j = -1;
			}

			i++;
			j++;
		}

		if (j == pattern.length) {
			result = i - j;
		} else {
			result = -1;
		}

		System.out.println(result);
	}

}
