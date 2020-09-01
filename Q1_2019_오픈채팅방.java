import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Q1_2019_����ä�ù� {
	public static void main(String[] args) {
		String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };
		System.out.println(Arrays.toString(solution(record)));
	}

	static public String[] solution(String[] record) {
		String[] answer = {};

		Map<String, String> map = new HashMap<>();
		// Enter : ���� , Leave : ����, Change : ����
		int count = 0;
		for (int i = 0; i < record.length; i++) {
			String[] arr = record[i].split(" ");
			if (!arr[0].equals("Leave")) {
				map.put(arr[1], arr[2]);
			}
			if (arr[0].equals("Enter") || arr[0].equals("Leave")) {
				count++;
			}
		}

		answer = new String[count];
		int index = 0;
		for (int i = 0; i < record.length; i++) {
			String[] arr = record[i].split(" ");
			System.out.println(Arrays.toString(arr));
			if (arr[0].equals("Enter")) {
				answer[index] = map.get(arr[1]) + "���� ���Խ��ϴ�.";
				index++;
			} else if (arr[0].equals("Leave")) {
				answer[index] = map.get(arr[1]) + "���� �������ϴ�.";
				index++;
			} else
				continue;
		}

		return answer;
	}
}
