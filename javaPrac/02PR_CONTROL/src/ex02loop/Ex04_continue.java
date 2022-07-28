package ex02loop;

public class Ex04_continue {

	public static void main(String[] args) {
		
		// continue문
		// 반복문의 시작 지점으로 이동
		// 실행에서 제외할 코드가 있는 경우에 사용
		
		// while() {
		//				a;
		//				b;
		//				continue;   ab만 실행
		//				c;
		//				d;
		// }
		int sum = 0;
		int n = 0;
		while(n < 100) {
			n++;
			if(n % 3 == 0) {		// 3의 배수는 continue에 걸려 연산되지 않고 
				continue;			// n++ 과정으로 올라가서 +1 처리된 후
			}						// 4, 7 등의 수로 연산이 되며 밑으로 내려와
				sum += n;			// sum값을 출력한다. 
		}
				System.out.println(sum);
			
		
		while(n < 100) {
			n++;
			if(n%3!=0) {			// != 다르다. n을 3으로 나눈 나머지가 0이 아니면
				sum += n;			// += n 연산을 수행한다.
			}						// continue를 쓰지 않는 코드
		}
				System.out.println(sum);
				
		
		

	}

}
