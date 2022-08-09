package upcasting;

public class Bus extends Car{

	@Override
	public void pay() {
		
	}
	
	@Override
	public void bell() {
		
	}
	
	
	
	public static void main(String[] args) {
		
		Car car = new Bus();
		
		car.run();
		car.stop();
		car.pay();
		car.bell();
		// bus.bell(); 호출불가
		 
		// bus. <- 업캐스팅 된 서브클래스 객체는 슈퍼클래스의 메소드만 호출 가능하다.
		// Bus클래스의 생성자를 호출해서 Bus의 객체를 만들고 이를 Car클래스의 객체로 변환
		
		
		
	}
	
}
