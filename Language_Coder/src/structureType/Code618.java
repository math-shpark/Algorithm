package structureType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Code618 {

	private static class Person {
		String name;
		int height;
		double weight;

		Person(String name, int height, double weight) {
			this.name = name;
			this.height = height;
			this.weight = weight;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		Person[] arr = new Person[5];

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			Person person = new Person(st.nextToken(), Integer.parseInt(st.nextToken()),
					Double.parseDouble(st.nextToken()));
			arr[i] = person;
		}

		// 이름 순
		Arrays.sort(arr, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.name.compareTo(o2.name);
			}
		});
		System.out.println("name");
		print(arr);
		System.out.println();

		// 무게순
		Arrays.sort(arr, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o2.weight - o1.weight > 0 ? 1 : -1;
			}
		});
		System.out.println("weight");
		print(arr);

	}

	private static void print(Person[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%s %d %.1f\n", arr[i].name, arr[i].height, arr[i].weight);
		}
	}

}
