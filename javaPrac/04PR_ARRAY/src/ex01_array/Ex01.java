package ex01_array;

public class Ex01 {

	public static void main(String[] args) {
		

		// 배열로 로또 번호 랜덤 생성하기
		
		int[] lotto = new int[45];
		
		for(int i = 0; i < lotto.length; i++) 
			lotto[i] = i + 1;

		int temp = 0; 	// 임시 변수
		int j = 0;		// [i] 값과 서로 바꿀 [j]
		
		for(int i = 0; i < 150; i++) 
			j = (int)(Math.random() * 45);	 	// 배열의 범위(0~44) 임의의 값 얻기
			temp = lotto[0];
			lotto[0] = lotto[j];
			lotto[j] = temp;
			
	
		for(int i = 0; i < 6; i++) 
			System.out.println(lotto[i] + " ");
		
		
		
		
		
	}

}
