package thread2;

public class WashRobot extends Robot implements Runnable {

	private String name;

	public WashRobot(String name) {
		super();
		this.name = name;
	}
	
	
	@Override
	public void run() {
		System.out.println(name + " 빨래중이어요");
		
	}
	
}
