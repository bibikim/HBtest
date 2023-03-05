import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test12 {
	
	// 프로그래머스 두 개 뽑아서 더하기
    public int[] solution(int[] numbers) {
        int[] answer = {};
        
        // int배열에서 두 개의 수를 뽑아 더해서 만든 모든 수를 담을 Set.
        // 처음엔 List에 해봤으나, 중복값 제외를 위해 HashSet을 선언해서 담음
        Set<Integer> set = new HashSet<Integer>();
        
        // int배열의 길이만큼 for문을 돌려 첫번째 수 뽑기
        for(int i=0; i < numbers.length; i++) {
           // int배열의 길이만큼 또 for문 돌려 두번째 수까지 뽑고
            for(int j= i+1; j < numbers.length; j++) {
            	// 바깥 for문에서 나온 인덱스 값과 안쪽 for문에서 뽑은 인덱스의 값 더한 값들을 Set에 담아주기
                set.add(numbers[i] + numbers[j]);
            } 
        }
        
        // Set를 List로 변환한다. 정렬하기 위해!
        List<Integer> list = new ArrayList<Integer>(set);
        System.out.println("정렬 전 " + list);
        
        // List를 Collections.sort() 이용하여 오름차순으로 정렬.
        Collections.sort(list);		
        		// └▶ HashSet 대신 TreeSet 쓰면 정렬 필요 없음. TreeSet 자체가 오름차순 정렬해줌
        
        /*
         	- 오름차순
         	Collections.sort(list);
        	- 내림차순
        	Collections.sort(list, Collections.reverseOrder());
        	
        	- TreeSet 내림차순
        	Set<Integer> set = new TreeSet<Integer>(Collections.reverseOrder());
        */
        
        System.out.println("정렬 후 " + list);
        
        	// -> 한 가지 의문점... Collections.sort 하기 전이나 후나 기댓값이
        	//    오름차순으로 나옴.... 왤까....  
        	//    그런데 또 프로그래머스에선 C.sort() 없이 제출하면 테스트 통과가 안 됨
        	//	  뭐노
        
        // 고로 answer의 길이는 이제 list에 담긴 요소의 갯수만큼이 된다. 배열의 길이를 지정해주고
        answer = new int[list.size()];
        // for문 돌려서 List 출력하자
        for(int k = 0; k < list.size(); k++) {
        	// list에 있는 값들을 int배열 answer에 넣어주기
        	answer[k] = list.get(k);
        }
        
        return answer;
    }


    public static void main(String[] args) {
    	
    	Test12 sol12 = new Test12();
    	
    	int[] ans = {2, 5, 6, 1, 3};
    	
    	int[] arr = sol12.solution(ans);
    	System.out.println(Arrays.toString(arr));
    	
    	// or 
    	/*
    	   for(int i = 0; i < arr.length; i++) {
    			System.out.print(arr[i] + ", ");
    	}
    	*/
    	
    }


}
