
public class Test11 {

		// 프로그래머스 내적(스칼라 곱)
	    public int solution(int[] a, int[] b) {
	        
	    	int answer = 0;
	        
	    	// 배열 a, b를 반복문 돌리기 -> a와 b 두 배열의 길이가 동일하며 각각의 인덱스끼리 곱하는 것이므로
	    	// 굳이 다중for문 할 필요 없이 a로만 돌리고 b에도 [i] 붙여주면 똑같다잉
	        for(int i=0; i < a.length; i++) {
	        	
	        	// a[i]*b[i]끼리 곱하고 더한 것이 원하는 값. 따라서 +=로 누적시켜주면 된다
	            answer += a[i]*b[i];
	        }
	        
	        return answer;
	    }
	
	
	    
	    
	    public static void main(String[] args) {
	    	
	    	Test11 sol11 = new Test11();
	    	
	    	int[] a = {-2, -1, 2};
	    	int[] b = {-1, 0, 2};
	    	
	    	System.out.println(sol11.solution(a, b));
	    	
	    }
	    
}
