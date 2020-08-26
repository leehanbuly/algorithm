import java.util.LinkedList;
import java.util.Queue;

public class Q4_2018_캐시 {
	public static void main(String[] args) {
		int answer = 0; // 총 실행시간
		// LRU, cache hit -> 1, cache miss-> 5
		int cacheSize = 3; // 캐시 크기, 0~30
		// 도시이름 배열, 최대 100,000, 공백,숫자, 특수문자 없는 영문자, 대소문자 구분x, 도시이름 최대길이 20
		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA" };
		Queue<String> q = new LinkedList<>();
		
		if (cacheSize == 0) {
			answer = 5 * cities.length;
		}
		else {
			for (String city : cities) {
				
				String c = city.toLowerCase();
				
				if (q.contains(c)) {
					// 캐시에 포함되어 있어 cache hit인경우
					int size = q.size();
					for(int i = 0; i < size; i++) {
						if(q.peek().equals(c)) {
							q.poll();
						}
						else {
							q.add(q.poll());
						}
					}
					q.add(c);
					answer += 1;
				} else {
					// 포함되어있지 않은 경우
					if(q.size() >= cacheSize) {
						q.poll();
						q.add(c);
					}
					else {
						q.add(c);
					}
					answer += 5;
				}
			}
		}
		System.out.println(answer);

	}
}
