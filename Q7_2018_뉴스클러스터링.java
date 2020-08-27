
import java.util.HashMap;

import java.util.Map;

public class Q7_2018_뉴스클러스터링 {

	public static void main(String[] args) {
		System.out.println(solution("FRANCE", "french"));
	}

	public static int solution(String str1, String str2) {
		int answer = 0;
		// str1, str2 : 2~1000
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		Map<String, Integer> map1 = new HashMap<>();
		Map<String, Integer> map2 = new HashMap<>();
		Map<String, Integer> intersec = new HashMap<>();
		Map<String, Integer> union = new HashMap<>();
		map1 = getSet(str1);
		map2 = getSet(str2);
		if (map1.size() == 0 && map2.size() == 0) {
			return 65536;
		}
		intersec = getIntersection(map1, map2);
		union = getUnion(map1, map2);

		int parent = 0;
		for (String str : union.keySet()) {
			parent += union.get(str);
		}

		int child = 0;
		for (String str : intersec.keySet()) {
			child += intersec.get(str);
		}
		if (child == 0) {
			answer = 0;
			return answer;
		}

		float answertmp = ((float) child / (float) parent);
		answer = (int) (answertmp * 65536.f);
		return answer;
	}

	public static Map<String, Integer> getSet(String string) {
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < string.length() - 1; i++) {
			char c2 = string.charAt(i + 1);
			if (c2 < 'a' || c2 > 'z') {
				i++;
				continue;
			}
			char c1 = string.charAt(i);
			if (c1 < 'a' || c1 > 'z') {
				continue;
			}

			String tmp = Character.toString(c1) + Character.toString(c2);

			if (map.containsKey(tmp)) {
				map.put(tmp, map.get(tmp) + 1);
			} else {
				map.put(tmp, 1);
			}
		}
		return map;
	}

	public static Map<String, Integer> getIntersection(Map<String, Integer> map1, Map<String, Integer> map2) {
		Map<String, Integer> intersection = new HashMap<>();

		for (String str1 : map1.keySet()) {
			for (String str2 : map2.keySet()) {
				if (str1.equals(str2)) {
					intersection.put(str1, Math.min(map1.get(str1), map2.get(str2)));
				}
			}
		}
		return intersection;
	}

	private static Map<String, Integer> getUnion(Map<String, Integer> map1, Map<String, Integer> map2) {
		Map<String, Integer> union = new HashMap<>();

		for (String str1 : map1.keySet()) {
			union.put(str1, map1.get(str1));
		}
		for (String str2 : map2.keySet()) {
			if (union.containsKey(str2)) {
				union.put(str2, Math.max(map1.get(str2), map2.get(str2)));
			} else {
				union.put(str2, map2.get(str2));
			}
		}
		return union;

	}
}
