package ex02loop;

public class Ex02_while {

	public static void main(String[] args) {
		
		// while문
		// 특정 실행문을 반복할  때 사용
		// 특정 반복 횟수가 정해지지 않은 경우에 사용.
		// while(조건문) {
		//					실행문
		// }
		
		int balance = 458900;
		int money = 400;
		
		while(balance >= money) {
				System.out.println("잔액 " + balance + "인출금 " + money);
				balance -= money;
		}
		System.out.println(balance);
		
		
		

	}

}
