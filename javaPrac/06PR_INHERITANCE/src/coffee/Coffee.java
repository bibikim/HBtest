package coffee;

public class Coffee {

	private String origin;	// 원두 종류

	public Coffee(String origin) {
		super();
		this.origin = origin;
	}
	
	
	public void info() {
		System.out.println(origin + " 원두");
	}
	
}
