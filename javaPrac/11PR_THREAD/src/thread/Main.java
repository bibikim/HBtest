package thread;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("main 스따뜨");
		// main은 시작하라고 알려주기만 하는거!
		
		Process process1 = new Process("연산");
		process1.start();
		
		Process process2 = new Process("제어");
		process2.start();
		
		System.out.println("main 종료");
	}
	
}
