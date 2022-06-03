package structureType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Code199 {

	private static class Person implements Comparable<Person> {
		String name;
		int score1, score2, score3, total;

		Person(String name, int score1, int score2, int score3) {
			this.name = name;
			this.score1 = score1;
			this.score2 = score2;
			this.score3 = score3;
			this.total = score1 + score2 + score3;
		}

		@Override
		public int compareTo(Person o) {
			return o.total - this.total;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Person> que = new PriorityQueue<>();
		StringTokenizer st;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			Person person = new Person(st.nextToken(), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			que.add(person);
		}

		for (int i = 0; i < n; i++) {
			Person person = que.poll();
			System.out.printf("%s %d %d %d %d\n", person.name, person.score1, person.score2, person.score3,
					person.total);
		}

	}

}
