import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DFS_BFS_네트워크 {
	static boolean[] visited;

	public static void main(String[] args) {
		int n = 3; // 1~200
		int[][] computers = { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } }; // computers[i][j] : 1이면 i와 j번 컴퓨터가 연결된 것
		int answer = 0; // 네트워크의 개수
		visited = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				bfs(i, n, computers);
				answer++;
			}
		}
		System.out.println(answer);
	}

	static void bfs(int i, int n, int[][] computers) {
		Queue<Integer> Q = new LinkedList<>();
		Q.add(i);
		visited[i] = true;
		while (!Q.isEmpty()) {
			int num = Q.poll();
			for (int j = 0; j < n; j++) {
				if (visited[j])
					continue;
				else if(computers[num][j] == 1){
					visited[j] = true;
					Q.add(j);
				}
			}
		}
	}
}
