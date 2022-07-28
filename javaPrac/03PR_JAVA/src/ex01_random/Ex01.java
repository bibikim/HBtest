package ex01_random;

public class Ex01 {

	public static void main(String[] args) {
		
		// random number 난수
		// Random클래스, Math클래스를 주로 사용한다

		System.out.println(Math.random());
		
		// 0.0 <= Math.random() < 1.0
		// 0% <= Math.random() < 100%		같은 말
		
		// 1. 확률 처리
		// 10% 확률로 대박, 90% 확률로 쪽박 변환
		if(Math.random() < 0.1) {
			System.out.println("대박");
		} else {
			System.out.println("쪽박");
		}
		
		// 2. 사용할 난수 값 생성
		
		
		
		
	}

}
