package override02;

public class Shape {

	private String type;
	
	public Shape(String type) {
		this.type = type;
	}
	
	public double getArea() {
		return 0;
	}
	
	public void info() {
		System.out.println("도형 종류 " + type);
	}
	
	
}
