public class Test08 {

	// 프로그래머스 삼총사
    public int solution(int[] number) {
        int answer = 0;
        
        // 학생들이 가진 각자의 정수 번호 number, 셋이 합쳐 0이 되면 카운트(삼총사)
        // 따라서 int타입의 배열인 number를 가지고 for문 돌리기
        for(int i = 0; i < number.length; i++) {
        	// j = i+1 하는 이유는, i 학생은 제외한 나머지 학생들 중 하나를 뽑는 것이기 때문에
            for(int j = i+1; j < number.length; j++) {
                for (int k = j+1; k < number.length; k++) {
                   if( number[i] + number[j] + number[k] == 0 ) {
                       answer++;
                   }
                }
            }
        }
        
        return answer;
    }
	
    // 의문점.............. 
    // number.length에 첫번째 for문은 -2, 두번째는 -1을 해주는 풀이법도 봤는데.. 이건 왜 그런걸가.. 이유를 못 찾음...ㅠㅡㅠ
    
    
    public static void main(String[] args) {
    	
    	Test08 sol8 = new Test08();
    	int[] num = {-1, -2, 0, 1, 2, 4};

    	System.out.println(sol8.solution(num));
    }
    
}
