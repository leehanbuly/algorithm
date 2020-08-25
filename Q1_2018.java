import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class Q1_2018 {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);

		String[] lines = {"2016-09-15 20:59:57.421 0.351s",
				"2016-09-15 20:59:58.233 1.181s",
				"2016-09-15 20:59:58.299 0.8s",
				"2016-09-15 20:59:58.688 1.041s",
				"2016-09-15 20:59:59.591 1.412s",
				"2016-09-15 21:00:00.464 1.466s",
				"2016-09-15 21:00:00.741 1.581s",
				"2016-09-15 21:00:00.748 2.31s",
				"2016-09-15 21:00:00.966 0.381s",
				"2016-09-15 21:00:02.066 2.62s"};
		// S : YYYY-MM-DD hh:mm:ss.sss, 응답 완료 시간
		// T : 0.3f (s), 0.001 ~ 3.000, 처리 시간
		int answer = 1;
		SimpleDateFormat[] times = new SimpleDateFormat[lines.length];
		
		String[][] arr = new String[lines.length][];
		Date[][] date = new Date[lines.length][2];
		for (int i = 0; i < lines.length; i++) {
			arr[i] = lines[i].split(" ");

			SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			String from = arr[i][0] + " " + arr[i][1];
			Date to = transFormat.parse(from);
			date[i][1] = to;
			Double mil = Double.parseDouble(arr[i][2].split("s")[0]);
			int milsec = (int)Math.round((mil - 0.001f) * 1000);
			Date to2 = transFormat.parse(from);
			to2.setTime(to.getTime()-milsec);
			date[i][0] = to2;
		}
		
		for(int i = 0; i < lines.length; i++) {
			int count = 0;
			long end2 = date[i][1].getTime() + 1000;
			for(int j = i; j < lines.length; j++) {
				if(date[j][0].getTime() < end2) {
					count++;
				}else {
					break;
				}
				answer = Math.max(answer, count);
			}
		}
		
		Arrays.sort(date, new Comparator<Date[]>() {
			@Override
			public int compare(Date[] lhs, Date[] rhs) {
				if(lhs[0].getTime() == rhs[0].getTime())
					return (int)(lhs[1].getTime() - rhs[1].getTime());
				else 
					return (int)(lhs[0].getTime() - rhs[0].getTime());
			}
		});
		
		
		for(int i = 0; i < lines.length; i++) {
			int count = 0;
			long end1 = date[i][0].getTime() + 1000;
			for(int j = i; j < lines.length; j++) {
				if(date[j][0].getTime() < end1) {
					count++;
				}else {
					break;
				}
				answer = Math.max(answer, count);
			}
		}

		
		System.out.println(answer);
		
	}
}
