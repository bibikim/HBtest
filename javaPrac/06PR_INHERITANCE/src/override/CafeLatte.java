package override;

public class CafeLatte extends Espresso{

	private int milk;
	
	@Override
	public void taste() {
		System.out.println("고소한 맛");
	}
	
}
