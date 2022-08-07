package upcasting;

public class SnackMain {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Snack mysnack;
		
		mysnack = new Stick();
		mysnack = new Pie();
		
		mysnack.뜯다();
		mysnack.덜어내다();
		// mysnack.뽀개먹다();
		
		mysnack.잘라먹다();
		
	}

}
