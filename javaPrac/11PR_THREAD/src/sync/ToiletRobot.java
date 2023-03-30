package sync;

public class ToiletRobot extends Thread {

	private Cleaner cleaner;

	public ToiletRobot(Cleaner cleaner) {
		super();
		this.cleaner = cleaner;
	}
	
	@Override
	public void run() {
		super.run();
		for(int i = 0; i < 3; i++) {
			cleaner.toiletCleaning();
		}
	}
	
}
