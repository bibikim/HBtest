
public class test04 {

	// 프로그래머스 나머지가 1이 되는 수 찾기
	public static int solution(int n) {
		
		// n을 x로 나눈 나머지가 1이 되도록 하는 가장 작은 자연수 x를 return 하도록 solution 함수를 완성. n은 3 이상의 숫자!
		// 10을 3으로 나눈 나머지가 1이고, 3보다 작은 자연수 중에서 문제의 조건을 만족하는 수가 없으므로, 3을 return 해야 함.
		int answer = 0;
		
		// 일단 n을 나눌 자연수 x가 0과 1인 경우엔 나머지가 1이 나올 수 없으므로 이를 배제한 후에 x를 for문 돌리기
		// 또한, n이 3 이상의 수이므로 x를 2로 두고 반복문 시작
		for(int x = 2; x < n; x++) {
			// 나머지가 1이면 x를 return 후 break
			if(n % x == 1) {
				answer = x;
				break;  // break를 넣지 않으면, 10을 넣었을 때 기대하는 결과값 3이 나오지 않음.
						// 10을 9로 나눠도 나머지가 1이 되기 때문에 계속 반복문을 돌리면서 10보다 작은 수 9까지 가서 계산하고 9를 return.
						// 가장 작은 자연수를 구해야 하므로 처음 돌려서 나오는 가장 첫 숫자가 return값이 되어야 함. 
						// 따라서 if문을 충족하는 순간 break를 걸어 기대하는 값이 나오도록 해준다!
			}
		}
		
		return answer;
	}
	

	
	public static void main(String[] args) {
		
		int n = 10;

		System.out.println(solution(n));
		
	}
}
