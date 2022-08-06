package ex05_method_car;

public class Car {
	
	int oil;
	int speed;
	
	public void addOil(int o) {   // 매개변수 int o
		oil += o;
		if(oil > 80) {		// 기름full용량 = 80
			oil = 80;		// 80보다 더 커지면 80으로 반환한다.
		}
	}
	
	public void pushAccel() {
		if(oil == 0) {
			return;		// 메소드 중지
		}
		if(speed == 120) {
			oil--;		// 최대속도 120에서는 기름이 사용되지 않는다.
			return;
		}
		speed += 25;   // 악셀 한번에 속도 25씩 증가, 기름은 1씩 사용
		if(speed > 120) {
			speed = 120;
		}
		oil--;
	}
	
	public void pushBrake() {
		if(speed == 0) {
			return;
		}
		speed -= 25;
		if(speed < 0) {
			speed = 0;
		}
	}
		
	public void panel() {
		System.out.println("기름" + oil);
		System.out.println("속도" + speed);
		
	}
		
		
		
	}
	
	
	
	
	
	


