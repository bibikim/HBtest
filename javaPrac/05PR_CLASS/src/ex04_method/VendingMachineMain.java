package ex04_method;

public class VendingMachineMain {

	public static void main(String[] args) {
		
		VendingMachine vm = new VendingMachine();
		
		// 커피 뽑기
		// 한 잔 1000원, 종류 1(아메) 2(라떼)
		String coffee1 = vm.getCoffee(4000, 1);
		String coffee2 = vm.getCoffee(2000, 2);
		
		System.out.println(coffee1);
		System.out.println(coffee2);
		

	}

}
