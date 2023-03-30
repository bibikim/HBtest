package sync;

public class RoomRobot extends Thread {

	private Cleaner cleaner;

	public RoomRobot(Cleaner cleaner) {
		super();
		this.cleaner = cleaner;
	}
	
	@Override
	public void run() {
		super.run();
		for(int i = 0; i < 3; i++) {
			cleaner.roomCleaning();
		}
	}
}
