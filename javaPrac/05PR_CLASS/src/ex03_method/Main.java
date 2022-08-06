package ex03_method;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calculator calculator = new Calculator();
		
		int answer = calculator.add(4, 8);
		System.out.println(answer);
		
		System.out.println(calculator.sub(3, 1));
		System.out.println(calculator.mul(8, 3));
		System.out.println(calculator.div(5, 2));
		
		
		
	}

}
