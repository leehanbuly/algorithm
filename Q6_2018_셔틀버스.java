import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class Q6_2018_셔틀버스 {
	public static void main(String[] args) throws ParseException {
		//09:00 부터
		// n회 t분 간격
		// 최대 m명 승객 탑승
		// 제일 늦은 도착 시각 구해야함
		// 같은 시각에 도착한 크루 중 가장 뒤에 존재
		// 모든 크루는 23:59에 집에 돌아감
		String[] timetable = {"09:10", "09:09", "08:00"};
		System.out.println(solution(2,10,2,timetable));
	}
	public static String solution(int n, int t, int m, String[] timetable) throws ParseException {
        String answer = "";
        // 0 < timetable <= 2000
        // 0 < n <= 10
        // 0 < t <= 60
        // 0 < m <= 40
        SimpleDateFormat hour = new SimpleDateFormat("HH:mm");
        Date[] times = new Date[timetable.length];
        for(int i = 0; i < timetable.length; i++) {
        	times[i] = hour.parse(timetable[i]);
        }
        
        Arrays.sort(times, new Comparator<Date>() {
        	@Override
        	public int compare(Date lhs, Date rhs) {
        		return (int)(lhs.getTime() - rhs.getTime());
        	}
        });
        
        Date start = hour.parse("09:00");
        Queue<Date> Q = new LinkedList<>();
        for(int i = 0; i < times.length; i++) {
        	Q.add(times[i]);
        }
        
        
        int currentcycle = 0;
        int currentnum = 0;
        while(!Q.isEmpty()) {
        	if(currentcycle < n-1) {
        		if(currentnum < m && Q.peek().getTime() <= start.getTime()) {
        				Q.poll();
        				currentnum++;
        		}
        		else {
        			currentcycle++;
        			start.setMinutes(start.getMinutes()+t);
        			currentnum = 0;
        			continue;
        		}
        	}
        	else if(currentcycle == n-1) {
        		if(currentnum == m-1) {
        			Date end = Q.poll();
        			if(end.getTime() > start.getTime()) {
        				answer = getAnswer(start);
        				break;
        			}
        			else{
        				end.setMinutes(end.getMinutes()-1);
        				answer = getAnswer(end);;
        				break;
        			}
        		}
        		else {
        			if(Q.peek().getTime() <= start.getTime()) {
        				Q.poll();
        				currentnum++;
        			}
        			else {
        				answer = getAnswer(start);
        				break;
        			}
        		}
        	}
        }
        if(answer.equals("")) {
        	answer = getAnswer(start);
        }
        return answer;
    }
	
	public static String getAnswer(Date date) {
		String result = "";
		int hours = date.getHours();
    	int min = date.getMinutes();
    	if(hours < 10) result = '0' + Integer.toString(hours);
    	else result = Integer.toString(hours);
    	result += ':';
    	if(min < 10) result += '0';
    	result += Integer.toString(min);
		return result;
	}
}
