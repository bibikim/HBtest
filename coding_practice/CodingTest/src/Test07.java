import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test07 {

    public int[] solution(int[] arr, int divisor) {
    	
        int[] answer = {};
        
        // arr을 divisor로 나누었을 때, 딱 나눠 떨어지는 값들을 담을 list 생성
        List<Integer> list = new ArrayList<Integer>();
        
        // 나누어 떨어지는 값들의 갯수를 저장할 변수
        int cnt = 0;
        
        // 배열 arr의 길이만큼 반복문
        for(int i = 0; i < arr.length; i++) {
        	
        	// arr 요소 중에 나누었을 때 나머지가 0인 요소가 있으면
            if(arr[i] % divisor == 0) {
            		// 해당 값을 list에 담고 카운팅한다
            		list.add(arr[i]);
            		cnt++;
            } 
        }
        
        // 나머지가 0인 요소가 없는 경우(cnt가 0일 때)
        if(cnt == 0) {
        	// 배열 answer의 길이는 1로 고정하고, 그 값을 -1로 고정한다.
        	answer = new int[1];
        	answer[0] = -1;
        } else {
        	// 아니면, 배열 answer의 길이를 list의 크기만큼 배열 선언
        	answer = new int[list.size()];
        	
        	// list의 길이만큼 반복문을 돌려서
        	for(int j= 0; j < list.size(); j++) {
        		// answer의 각 요소에 list에 담긴 값들을 순차적으로 저장
        		answer[j] = list.get(j);
        	}
        	
        	// 오름차순. 정렬은 제일 마지막!
        	Arrays.sort(answer);
        }
            
        	return answer;   
    }
    
    
    public static void main(String[] args) {
    	
    	Test07 sol = new Test07();
    	int[] array = {5, 25, 9, 12};
    	System.out.println( Arrays.toString(sol.solution(array, 5)) );
    	
    	// Arrays - java.util의 Arrays 클래스. 배열을 다루기 위한 다양한 메소드를 제공함
    	// sort() : 정렬, toString() ; 1차원 배열 출력, asList() : 배열을 리스트로 변환
    	
    }
	
}
