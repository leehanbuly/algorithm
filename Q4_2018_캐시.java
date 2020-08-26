import java.util.LinkedList;
import java.util.Queue;

public class Q4_2018_ĳ�� {
	public static void main(String[] args) {
		int answer = 0; // �� ����ð�
		// LRU, cache hit -> 1, cache miss-> 5
		int cacheSize = 3; // ĳ�� ũ��, 0~30
		// �����̸� �迭, �ִ� 100,000, ����,����, Ư������ ���� ������, ��ҹ��� ����x, �����̸� �ִ���� 20
		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA" };
		Queue<String> q = new LinkedList<>();
		
		if (cacheSize == 0) {
			answer = 5 * cities.length;
		}
		else {
			for (String city : cities) {
				
				String c = city.toLowerCase();
				
				if (q.contains(c)) {
					// ĳ�ÿ� ���ԵǾ� �־� cache hit�ΰ��
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
					// ���ԵǾ����� ���� ���
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
