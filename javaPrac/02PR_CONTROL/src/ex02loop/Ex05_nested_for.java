package ex02loop;

public class Ex05_nested_for {

	public static void main(String[] args) {
		
		
		// nested for 중복for문
		// 1일차 1교시
		// 1일차 2교시
		// ...
		// 1일차 5교시
		// 2일차 1교시
		// ...
		// 3일차 5교시
		// 1~3 for문, 1~5 for문 2중으로 중첩
		
		for(int day = 1; day <= 3; day++) {
			for(int h = 1; h <= 5; h++) {
				System.out.println(day + "일차 " + h + "교시");
			}
		}
		
		// 연습.
		// 전체 구구단.
		for(int n = 2; n<=9; n++) {
			for(int b = 1; b <= 9; b++) {
				System.out.print(n + "x" + b + "=" + (n*b) + "\t");
			}
			System.out.println();
		}
		
		for(int n = 2; n <= 5; n++) {
			for(int m = 1; m <= 9; m++) {
				System.out.println(n + "x" + m + "=" + (n*m) + "\t");
				if(n == 5 && m == 5) {
					break;
				}
			}
		}
		
		// 라벨을 이용한 풀이. 아무이름 붙이고 처음과 끝에.
		eunwoo: for(int n = 2; n <= 9; n++) {
				for(int m = 1; m <= 9; m++) {
					System.out.println(n + "x" + m + "=" + (n*m));
				if(n == 5 && m == 5) {
						break eunwoo;
				}
			}
		}
		// 2x1=2  3x1=3  ... 9x1=9      곱하기 1을 먼저 출력하라. 코드는 위에서 아래로 읽는거 X, 왼쪽에서 오른쪽으로.
		// 2x2=4  3x2=6  ... 9x2=18          
		for(int m= 1; m <= 9; m++) {
			for(int n = 2; n <= 9; n++) {
				System.out.print(n + "x" + m + "=" + (n*m) + "\t");
			}
			
				System.out.println();
		}

	}

}
