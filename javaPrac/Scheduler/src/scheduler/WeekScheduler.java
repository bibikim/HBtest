package scheduler;

import java.util.Scanner;

public class WeekScheduler {

	private int nthWeek;
	private Day[] week;
	private String[] dayNames = {"일", "월", "화", "수", "목", "금", "토"};
	private Scanner sc;
	
	public WeekScheduler(int nthWeek) {
		this.nthWeek = nthWeek;
		week = new Day[7];
		sc = new Scanner(System.in);
		
	}
	
	private void makeSchedule() {
		System.out.println("*** 등록 ***");
		System.out.println("요일 입력 >>> ");
		String dayName = sc.next().substring(0, 1);
		sc.nextLine();
		
		
	}
	
	
	
	private void deleteSchedule() {
		
	}
	

	private void changeSchedule() {
		
	}
	
	private void seeWeekSchedule() {
		
	}
	
	
	
	
	public void manage() {
		while(true) {
			System.out.println("1.등록 2.삭제 3.변경 4.조회 0.프로그램 종료");
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1: makeSchedule(); break;
			case 2: deleteSchedule(); break;
			case 3: changeSchedule(); break;
			case 4: seeWeekSchedule(); break;
			case 0: System.out.println("스케줄러를 종료합니다."); return;
			default : System.out.println("존재하지 않는 명령입니다.");
			}
			
		}
		
		
	}
}
