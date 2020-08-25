import java.util.ArrayList;
import java.util.List;

public class Q3_2018_다트 {
	public static void main(String[] args) {
		// 총 3번
		// 각 기회당 0~10
		// S:점수^1 , D:점수^2 , T:점수^3 -> 점수마다 하나씩 존재
		// * : 해당 점수와 바로전 점수를 각 2배로, 처음에 * 나올 경우 첫번째 스타상의 점수만 2배, 중첩가능
		// # : 해당 점수 마이너스
		// *와 # 중첩시 점수 -2배
		// *와 #은 점수마다 둘 중 하나만 존재할 수 있으며, 존재하지 않을 수도 있음
		String dartResult = "1D2S#10S";
		int answer = 0;
		List<Integer> numlist = new ArrayList<>();
		int index = 0;
		int num = 0;
		for(int i = 0; i < dartResult.length(); i++) {
			char c = dartResult.charAt(i);
			if(c >= '0' && c <= '9') {
				if(i+1 < dartResult.length() && (dartResult.charAt(i+1) == 'S' || dartResult.charAt(i+1) == 'D' || dartResult.charAt(i+1) == 'T')) {
					if(num != 0) continue;
					num = Integer.parseInt(dartResult.substring(i,i+1));
				}else {
					num = Integer.parseInt(dartResult.substring(i, i+2));
				}
			}else{
				if(c == 'D') {
					num = (int)Math.pow(num, 2);
				} 
				else if (c == 'T') {
					num = (int) Math.pow(num, 3);
				} 
				else if (c == '#') {
					num = num * (-1);
				}
				else if (c == '*') {
					num = num * 2;					
					if (i != 2 && i != 3) {
						numlist.set(index-1, numlist.get(index-1) * 2);
					}
				}
				
				if(i+1 == dartResult.length() || (i+1 < dartResult.length() && dartResult.charAt(i+1) >= '0' && dartResult.charAt(i+1) <= '9')) {
					numlist.add(num);
					index++;
					num = 0;
				}
			}
		}
		
		System.out.println(answer);
		
	}
}
