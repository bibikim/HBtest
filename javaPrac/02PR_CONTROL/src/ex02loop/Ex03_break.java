package ex02loop;

public class Ex03_break {

	public static void main(String[] args) {
		
		// break문
		// switch문을 종료할 때 사용
		// for문, while문 종료할 때 사용
		
		// 모금 목표 : 200000원
		// 한번에 500원씩 모금
		int total = 0;
		int money = 7000;
		int serial = 0;
		int goal = 200000;
		
		while(true) {
			if(total >= goal) {
				break;
			}
				total += money;
				serial++;
				System.out.println(serial + "회 " + "모금액" + money + " 현재" + total);
		}
		
		
		
	}

}
