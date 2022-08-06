package override;

public class Espresso extends Coffee {

	@Override		// 슈퍼클래스인 Coffee의 메소드를 오버라이드
	public void taste() {				// 똑같은 반환타입(void), 메소드(taste). 매개변수는 X
		System.out.println("쓴 맛");
	}
	
	
}
