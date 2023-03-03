import java.util.Arrays;

public class Test05 {

	// 프로그래머스 문자열 내림차순으로 배치하기
    public static String solution(String s) {
    	
    	
    	// String.toCharArray() => 문자열(string)을 한 글자씩 쪼개서 char 타입의 배열로 바꿔주는 메소드
    	char[] asc = s.toCharArray();
    	
    	// 오름차순 정렬(숫자-대문자-소문자-한글 순)
    	 Arrays.sort(asc);
    	
    	// 스트링빌더에 오름차순으로 정렬된 char타입의 asc를 sb에 담기 위해 Sting으로 형변환시켜 넣어 문자열을 더해준다
    	// StringBuilder 클래스에서 제공하는 reverse() 메소드를 사용하기 위함(string에서는 지원x)
    	StringBuilder sb = new StringBuilder(String.valueOf(asc));
        
        
    	// 내림차순 배치이므로 sb에 담긴 값을 reverse()로 정렬을 뒤집은 후에 sb를 문자열로 출력하기 위해 toString()
        return sb.reverse().toString();
    }
    
    public static void main(String[] args) {
    	
    	String str = "aAbcheG";
    	System.out.println(solution(str));
    	
    	// 코드실행하면 자꾸 Arrays애서 cannot find symbol 오류가 떴는데, 알고보니 import되는건 손수 써줘야 함.. 띠로리... 몰랐네..
    	
    }
	
}
