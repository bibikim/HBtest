import java.util.Scanner;

public class Test01 {

	// 백준 피보나치 수 5 ( n번째 피보나치 수 구하기 )
	public static int solution(int n) {
		
		// n은 n번째 항
		// result는 n번째 항의 값
		
		int result = 0;
		
		if(n == 1) {
			result = 1;
		} else if(n == 2) {
			result = 1;
		} else if(n >= 3) {
			result = solution(n - 2) + solution(n - 1);
		}
		
		return result;
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("입력 >> ");
		int n = sc.nextInt();
		System.out.println(solution(n));
	}
	
}
