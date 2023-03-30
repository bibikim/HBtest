package thread2;

public class Main {

	public static void main(String[] args) {
		
		Runnable robot1 = new WashRobot("로봇 a");
		Thread thread1 = new Thread(robot1);
		
		WashRobot robot2 = new WashRobot("로봇 b");
		Thread thread2 = new Thread(robot2);
		
		Thread thread3 = new Thread(new WashRobot("로봇 c"));
		
		thread1.start();
		thread2.start();
		thread3.start();

	}

}
