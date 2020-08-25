import java.util.ArrayList;
import java.util.List;

public class Q3_2018_��Ʈ {
	public static void main(String[] args) {
		// �� 3��
		// �� ��ȸ�� 0~10
		// S:����^1 , D:����^2 , T:����^3 -> �������� �ϳ��� ����
		// * : �ش� ������ �ٷ��� ������ �� 2���, ó���� * ���� ��� ù��° ��Ÿ���� ������ 2��, ��ø����
		// # : �ش� ���� ���̳ʽ�
		// *�� # ��ø�� ���� -2��
		// *�� #�� �������� �� �� �ϳ��� ������ �� ������, �������� ���� ���� ����
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
