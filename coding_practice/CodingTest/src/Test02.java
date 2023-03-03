public class Test02 {

	
	// 프로그래머스 편지
    public int solution(String message) {


        return message.length() * 2;
    }
    
    
    // String의 길이만 구해서 x2 해주면 되는 거..!
    // String 문자열의 길이 - length()                        <-> 참고: length는 배열의 길이
	public static void main(String[] args) {
		
		String memo = "핌둥 덕질하기 을매나 재밌게요!?";
		int n = memo.length();
		System.out.println(n);
		System.out.println(n*2);
		
	}
	

}
