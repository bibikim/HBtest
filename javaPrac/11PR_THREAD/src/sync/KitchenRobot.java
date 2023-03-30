package sync;

public class KitchenRobot extends Thread {

	private Cleaner cleaner;
	
	public KitchenRobot(Cleaner cleaner) {
		super();
		this.cleaner = cleaner;
	}
	
	@Override
	public void run() {
		super.run();
		for(int i = 0; i < 3; i++) {
			cleaner.kitchenCleaning();
		}
	}
	
	
}
