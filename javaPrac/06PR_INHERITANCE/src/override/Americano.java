package override;

public class Americano extends Espresso{
	
	private int water;
	
	@Override	// 슈퍼클래스인 Espresso의 메소드를 오버라이드
	public void taste() {
		System.out.println("사랑스러운 맛");
		
	}
}
