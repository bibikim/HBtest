package override02;

public class Rectangle extends Shape{

	private double width;
	private double height;
	
	public Rectangle(String type, double width, double height) {
		super(type);
		this.width = width;
		this.height = height;
	}
	
	@Override						// circle, shape과 넓이가 다르기 때문에 getArea메소드를 새로 다시 만든 것
	public double getArea() {
		return width * height;
	}
	
	@Override
	public void info() {
		super.info();
		System.out.println("너비 " + width + " 높이 " + height);
		System.out.println("넓이 " + getArea());
	}
	
}
