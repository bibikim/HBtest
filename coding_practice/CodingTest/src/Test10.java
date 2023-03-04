
public class Test10 {

    public int solution(String s) {
        int answer = 0;
        
        // one부터 nine까지를 String 배열에 담아주면 편하다
        // 왜냐면~ 인덱스가 곧 숫자놀이의 숫자가 되고, 영문과 일치하게 돌아가니간~
        String[] number = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        // 그리고 number의 길이만큼 for문을 돌려서
        for(int i = 0; i < number.length; i++) {
            
        	// replaceAll() 사용하려면, 두 매개변수가 모두 문자열이어야 하니까!
        	// 앞에가 변환하고자 하는 대상, 뒤에가 변환할 문자~
        	// s로 들어온 입력값에 number[i]를 해당 인덱스 i(String으로 바꾼(toString))로 replace 해준다
        	s = s.replaceAll(number[i], Integer.toString(i));
        
        }
        
        // 반환타입이 int니까 replaceAll된 s값은 다시 int타입으로 파싱
        answer = Integer.parseInt(s);
        
        return answer;
    }
	
    public static void main(String[] args) {
    	
    	Test10 sol10 = new Test10();
    	
    	String s = "2zerotwo30four1five";
    	
    	System.out.println(sol10.solution(s));
    }
    
}
