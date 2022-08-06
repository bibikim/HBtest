package ex05_method_car;

public class CarMain {

	public static void main(String[] args) {
		
		Car car = new Car();
		
		car.addOil(70);
		car.addOil(60);

		car.pushAccel();
		car.pushAccel();
		car.pushAccel();
		
		car.pushBrake();
		
		car.panel();
		
		System.out.println("기름 " + car.oil);
		System.out.println("속도 " + car.speed);
	}

}
