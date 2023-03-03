
public class Test06 {

	// 프로그래머스 서울에서 김서방 찾기
	public static String solution(String[] seoul) {
		
		String answer ="";
		
		// seoul이라는 String 배열 안에서 Kim씨가 있는 위치(index)를 찾는 것이므로 반복문 돌려서
		for(int i = 0; i < seoul.length; i++) {
			// 만약 서울 안의 요소들 중 Kim과 동일한 요소가 있다면,
			// 문자열 비교이므로 '=='가 아닌 'equals()' 사용하기
			if(seoul[i].equals("Kim")) {
				// i(index[i])에 있다고 출력!
				answer = "김서방은 " + i + "에 있다.";
				// break;   // Kim이 2개 이상이고 가장 가까운(작은 배열의 위치에 있는) Kim을 찾을 경우 break 달아주기..~
			}
		}
		
		return answer;
	}
	
	
	public static void main(String[] args) {
		
		String[] first = {"Lee", "Choi", "Joo", "Kim", "Lim", "Yu", "Min"};
		
		System.out.println(solution(first));
	}
	
}
