import java.util.Arrays;

public class Q2_2019_실패율 {
	public static void main(String[] args) {
		int N = 5;
		int[] stages = { 2, 1, 2, 6, 2, 4, 3, 3 };
		System.out.println(Arrays.toString(solution(N, stages)));
	}

	static public int[] solution(int N, int[] stages) {
		int[] answer = {};
		// 실패율 = 스테이지에 도달했으나 아직 클리어하지 못한 플레이어 수 / 스테이지에 도달한 플레이어 수
		// 1 <= N <= 500
		// 1 <= stages <= 200,000
		// 1 <= stages[i] <= N+1
		int[] stage = new int[N + 2];
		for (int i = 0; i < stages.length; i++) {
			stage[stages[i]]++;
		}

		float[] fail = new float[N + 1];
		int num = 0;
		for (int i = 1; i < stage.length - 1; i++) {
			if (num == stages.length) {
				fail[i] = 0;
				continue;
			}
			fail[i] = (float) stage[i] / (float) (stages.length - num);
			num += stage[i];
		}
		boolean[] visited = new boolean[N + 1];			
		answer = new int[N];
		for (int j = 0; j < answer.length; j++) {
			float max = 0;
			int maxindex = 0;
			for (int i = fail.length-1; i >= 1; i--) {
				if (!visited[i] && fail[i] >= max) {
					max = fail[i];
					maxindex = i;
				}
			}
			answer[j] = maxindex;
			visited[maxindex] = true;
		}

		return answer;
	}
}
