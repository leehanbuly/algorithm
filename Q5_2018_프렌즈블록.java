import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q5_2018_«¡∑ª¡Ó∫Ì∑œ {
	static class Point {
		int y;
		int x;

		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static boolean[][] visited;
	static boolean flag;
	static int[] dr = { 0, 1, 1 };
	static int[] dc = { 1, 0, 1 };

	public static void main(String[] args) {
		// m,n : 2~30
		int m = 8;
		int n = 2;
		String[] board = { "FF", "AA", "CC", "AA", "AA", "CC", "DD", "FF" };
		int answer = 0;

		char[][] map = new char[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = board[i].charAt(j);
			}
		}
		while (true) {
			flag = false;
			visited = new boolean[m][n];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j] && map[i][j] != ' ') {
						bfs(new Point(i, j), map);
					}
				}
			}

			if (!flag)
				break;

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (visited[i][j]) {
						map[i][j] = ' ';
						answer++;
					}
				}
			}

			for (int j = 0; j < n; j++) {
				for (int i = m - 1; i >= 0; i--) {
					if (map[i][j] == ' ') {
						int r = i;
						while (r > 0 && map[r][j] == ' ') {
							r--;
						}
						map[i][j] = map[r][j];
						map[r][j] = ' ';
					}
				}
			}
		}
		System.out.println(answer);
	}

	static void bfs(Point p, char[][] map) {
		Queue<Point> q = new LinkedList<>();
		q.add(p);
		Queue<Point> tmp = new LinkedList<>();
		while (!q.isEmpty()) {
			Point coord = q.poll();
			for (int d = 0; d < 3; d++) {
				int nr = coord.y + dr[d];
				int nc = coord.x + dc[d];
				if (nr >= map.length || nc >= map[0].length || map[nr][nc] != map[coord.y][coord.x]) {
					break;
				}
				tmp.add(new Point(nr, nc));
			}
			if (tmp.size() == 3) {
				flag = true;
				visited[coord.y][coord.x] = true;
				while (!tmp.isEmpty()) {
					Point t = tmp.poll();
					if (!visited[t.y][t.x]) {
						q.add(t);
					}
					visited[t.y][t.x] = true;
				}
			}
			tmp.clear();
		}
	}
}
