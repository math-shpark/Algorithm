package silver.level2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem14562 {

	private static class Game {
		int s, t, count;

		Game(int s, int t, int count) {
			this.s = s;
			this.t = t;
			this.count = count;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int c = scan.nextInt(); // test case;

		for (int test = 0; test < c; test++) {
			int s, t;
			s = scan.nextInt(); // S
			t = scan.nextInt(); // T

			int result = bfs(s, t); // bfs
			System.out.println(result); // print
		}
	}

	private static int bfs(int s, int t) {

		Queue<Game> bfsQue = new LinkedList<>();
		bfsQue.add(new Game(s, t, 0));
		int result = 0;

		while (!bfsQue.isEmpty()) {
			Game game = bfsQue.poll();

			if (game.s == game.t) {
				result = game.count;
				break;
			}

			if (game.s * 2 <= game.t + 3) {
				bfsQue.add(new Game(game.s * 2, game.t + 3, game.count + 1));
			}
			bfsQue.add(new Game(game.s + 1, game.t, game.count + 1));
		}

		return result;
	}

}
