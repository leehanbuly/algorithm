import java.util.Arrays;
import java.util.Scanner;

public class Q2_2018_비밀지도 {
	public static void main(String[] args) {
		int n = 6;
		int[] arr1 = {46, 33, 33 ,22, 31, 50};
		int[] arr2 = {27 ,56, 19, 14, 14, 10};
		int[][] map1 = new int[n][n];
		int[][] map2 = new int[n][n];
		for(int i = 0; i < n; i++) {
			String line1 = Integer.toBinaryString(arr1[i]);
			if(line1.length() < n) {
				int length = line1.length();
				for(int j = 0; j < n-length; j++) {
					line1 = '0' + line1;
				}
			}
			String line2 = Integer.toBinaryString(arr2[i]);
			if(line2.length() < n) {
				int length = line2.length();
				for(int j = 0; j < n-length; j++) {
					line2 = '0' + line2;
				}
			}
			for(int j = 0; j < n; j++) {
				map1[i][j] = Integer.parseInt(Character.toString(line1.charAt(j)));
				map2[i][j] = Integer.parseInt(Character.toString(line2.charAt(j)));
			}
		}
		
		// 1: 벽 , 0 : 공백  ,    하나라도 벽인 부분 -> 벽 , 모두 공백인 부분 -> 공백
		String[] answer = new String[n];
		for(int i = 0; i < n; i++) {
			answer[i] = "";
			for(int j = 0; j < n; j++) {
				if(map1[i][j] == 0 && map2[i][j] == 0) {
					answer[i] += ' ';
				}else if(map1[i][j] == 1 || map2[i][j] == 1) {
					answer[i] += '#';
				}
			}
		}
		
	}
}
