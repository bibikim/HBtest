package coffee;

public class Main {

	public static void main(String[] args) {
		
		Espresso espresso = new Espresso("콜롬비아", 20);
		espresso.info();
		
		Americano ameri = new Americano("콜롬비아", 180, "ice");
		ameri.info();
		

	}

}
