package thread;

public class Process extends Thread{   // java.lang.Thread  메인과 별개의 실행 체계를 가짐~_~

	private String name;
	
	public Process(String name) {
		super();
		this.name = name;
	}
	
	@Override
	public void run() {
		
		try {
			Thread.sleep(3000);
			System.out.println(name + " 스레드 작업 실행");
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
