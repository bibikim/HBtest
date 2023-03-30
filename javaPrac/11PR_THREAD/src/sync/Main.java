package sync;

public class Main {

	public static void main(String[] args) {

		// 클리너 1개
		Cleaner cleaner = new Cleaner();
		
		// 로봇 3개(동일한 클리너를 가짐. 공유)
		RoomRobot robot1 = new RoomRobot(cleaner);
		ToiletRobot robot2 = new ToiletRobot(cleaner);
		KitchenRobot robot3 = new KitchenRobot(cleaner);
		
		// 청소 시작
		robot1.start();
		robot2.start();
		robot3.start();
		
	}

}
