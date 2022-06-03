package io;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Code214 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String[] arr = new String[10];

		for (int i = 0; i < 10; i++) {
			String str = scan.nextLine();
			arr[i] = str;
		}

		String keyword = scan.nextLine();
		List<String> list = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			String str = arr[i];
			if (str.contains(keyword))
				list.add(str);
		}

		Collections.sort(list);

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
