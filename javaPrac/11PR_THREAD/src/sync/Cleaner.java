package sync;

public class Cleaner {

	public synchronized void kitchenCleaning() {
		System.out.println("부엌 청소");
		try {
			notify();
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void toiletCleaning() {
		System.out.println("화장실 청소");
		try {
			notify();
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void roomCleaning() {
		System.out.println("방 청소");
		try {
			notify();
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
