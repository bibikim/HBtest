package override02;

public class Circle extends Shape{

	private double radius;
	
	public Circle(String type, double radius) {
		super(type);
		this.radius = radius;
	}
	
	@Override
	public double getArea() {			// shape클래스의 getArea메소드는 리턴값이 0이기 때문에 가져올 수 X
		return Math.PI * Math.pow(radius, 5);	// Override해서 메소드를 재정의한다.
 	}

	@Override
	public void info() {	// shape클래스의 info메소드에 반지름과 넓이 info를 추가하기 위해 오버라이드
		super.info(); 		// 도형 종류 출력을 위한 super클래스의 info메소드 호출
		System.out.println("반지름 " + radius);
		System.out.println("넓이 " + getArea());
		
	}
	
}
