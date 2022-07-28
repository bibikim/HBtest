package ex01branch;

public class Ex03_else_if {

	public static void main(String[] args) {
		// else if문
		// 조건이 여러 개인 경우 각 조건을 하나씩 처리한다
		// if(조건) {
		//				실행문
		// } else if(조건) {
		//				실행문
		// } else if(조건) {
		// 				실행문
		// } else {
		// }
		
		// 나이에 따른 결과 출력
		// 0 ~ 7   : 미취학아동
		// 8 ~ 13  : 초등학생
		// 14 ~ 16 : 중학생
		// 17 ~ 19 : 고등학생
		// 20 ~    : 성인
		
		
		int age = 28;
		
		if(age < 0 || age > 100) { 
			System.out.println("잘못된 나이");
		} else if(age <= 7) {
			System.out.println("미취학 아동");
		} else if(age <= 13) {
			System.out.println("초등학생");
		} else if(age <= 16) {
			System.out.println("중학생");
		} else if(age <= 19) {
			System.out.println("고등학생");
		} else if(age >= 20) {
			System.out.println("성인");
		}
		
			
		// 연습.
		// 월에 따른 계절 출력
		// 봄   : 3 ~ 5
		// 여름 : 6 ~ 8
		// 가을 : 9 ~ 11
		// 겨울 : 12 ~ 2
		// 잘못된 월
		
		int month = 9;
		
		if(month < 1 || month > 12) {
			System.out.println("잘못된 월");
		} else if(month == 12 || month <=2 ) {
			System.out.println("겨울");
		} else if(month <= 5) {
			System.out.println("봄");
		} else if(month <= 8) {
			System.out.println("여름");
		} else if(month <= 11) {
			System.out.println("가을");
		}
		
		
		// 나머지 연산을 활용한 modular 연산
		
		int mon = month % 12;
		if(month < 1 || month > 12) {
			System.out.println("잘못된 월");
		} else if(mon <= 2) {
			System.out.println("겨울");
		} else if(mon <= 5) {
			System.out.println("봄");
		} else if(mon <= 8) {
			System.out.println("여름");
		} else if(mon <= 11) {
			System.out.println("가을");
		}
		
		// 연습.
		// 점수에 따른 학점
		// score	grade
		// 100 ~ 90   A
		// 89 ~ 80    B
		// 79 ~ 70    C
		// 69 ~ 60    D
		// 59 ~ 0     F
		int score = 87;
		char grade;
		
		if(score < 0 || score > 100) {
			grade = 'X';
		} else if(score >=90) {
			grade = 'A';
		} else if(score >=80) {
			grade = 'B';
		} else if(score >=70) {
			grade = 'C';
		} else if(score >=60) {
			grade = 'D';
		} else {
			grade = 'F';
		}
		System.out.println("학점은 " + grade);
		
		// 연습.
		// 오직 일 수만 고려
		// 1일이 금요일이다.
		// n일 후 무슨 요일인지 출력하기.
		int day = 15;
		int n = 1;
		String weekName;
		day += n;
		
		if(day % 7 == 0) {
			weekName = "목";
		} else if(day % 7 == 1) {
			weekName = "금";
		} else if(day % 7 == 2) {
			weekName = "토";
		} else if(day % 7 == 3) {
			weekName = "일";
		} else if(day % 7 == 4) {
			weekName = "월";
		} else if(day % 7 == 5) {
			weekName = "화";
		} else {
			weekName = "수";
		}
		System.out.println(weekName + "요일");
		
		
	
		
		
		
		
		
		
		
		
	}
	


}		
		
		
		


