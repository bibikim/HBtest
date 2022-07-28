package ex02loop;

public class Ex01_for {

	public static void main(String[] args) {
		// for문
		// 연속된 숫자를 생성할 때 주로 사용. 
		// 배열과 함께 자주 사용
		// for(초기문; 조건문; 증감문(++ or --)) {
		//			실행문
		// }
		
		// 1 ~ 10 초기문으로 1을 변수에 저장
		for(int n = 1; n <= 10; n++) {
			System.out.print(n + " ");
		}
		
		System.out.println();
		
		// 연습.
		// 10 ~ 1
		for(int n = 10; n >= 1; n--) {
			System.out.print(n + " ");
		}
		
		System.out.println();
		
		// 연습.
		// 구구단 7단 출력. (1 ~ 9)
		for(int e = 1; e <= 9; e++) {
			System.out.println("7x" + e + "= " + (7*e));
		}
		
		// 연습.
		// 1 ~ 100 사이의 모든 3의 배수만 출력하기
		
		for(int t = 1; t <= 100; t++) {
			if(t % 3 == 0) {
				System.out.print(t + " ");
			}
		}
			
		System.out.println();
		
		// 연습.
		// 1 ~ 100 모든 정수 더하기 (5050)
		int total = 0;
		for(int n = 1; n <= 100; n++) {
			total += n;
		}
			System.out.println(total);

		// 연습.
		// begin ~ end 사이의 모든 정수 더하기
		// begin과 end 중 누가 큰 지 모르는 상황
		// begin을 end보다 항상 작은 값으로 바꾼 뒤 begin ~ end 모두 더하기
		// begin이 end보다 크다면 begin과 end를 교환. (임시 변수 temp을 이용)
		int begin = 100;  
		int end = 1;
		if(begin > end) {
			int temp;
			temp = begin;
			begin = end;
			end = temp;
		}
		int ttal = 0;
		for(int n = begin; n <= end; n++) {
			ttal += n;
		}
			System.out.println(ttal);
	
		// 연습.
		// 평점(1~5)에 따른 별(★) 출력하기
		 int p = 5;
		 String star = "";
		 for(int n = 1; n <= p; n++) {
			 star += "★";
		 }
		 System.out.println(star);
			
			
			
	}

}
