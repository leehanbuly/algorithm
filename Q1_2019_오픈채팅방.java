import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Q1_2019_오픈채팅방 {
	public static void main(String[] args) {
		String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };
		System.out.println(Arrays.toString(solution(record)));
	}

	static public String[] solution(String[] record) {
		String[] answer = {};

		Map<String, String> map = new HashMap<>();
		// Enter : 입장 , Leave : 퇴장, Change : 변경
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
				answer[index] = map.get(arr[1]) + "님이 들어왔습니다.";
				index++;
			} else if (arr[0].equals("Leave")) {
				answer[index] = map.get(arr[1]) + "님이 나갔습니다.";
				index++;
			} else
				continue;
		}

		return answer;
	}
}
