public class test03 {

	// 프로그래머스 7의 개수
    public static int solution(int[] array) {
        int answer = 0;

        /*
		        int[] sample = {10, 20, 30, 40, 50};
		        String str = Arrays.toString(sample);
		        System.out.println(str);   // str = [10, 20, 30, 40, 50]   -> for문 돌리지 않고 그대로 뽑기 때문에 []안에 나열
        */
        
        
        // int[] array = {7, 10, 19, 27, 37, 67, 77};
        // int[] array 배열의 길이만큼 for문 돌려서
        for(int i = 0; i < array.length; i++) {
        	// array의 각 요소를 String으로 변환해서 a로 지정
            String a = Integer.toString(array[i]);   // System.out.println(a);   a = 7 / 10 / 19 / 27 / 37  ... array[i]이기 때문에 각 요소를 따로따로 보여줌
            
            // a를 공백("")기준으로 String 배열 b로 변환
            String[] b = a.split("");  // ex) b = [7, 10, 19, 27, 37, 67, 77];
            						   // ref) a.split();을 해버리면 기준 없이 그대로 출력하기 때문에 공백 기준("")을 꼭 넣어주어야 한다
            
            // Stringp[] b 배열의 길이만큼 for문 돌려서
            for(int j = 0; j < b.length; j++) {
            	// b의 요소 중에 문자열 7을 포함하는 요소가 있다면
                if(b[j].contains("7")) {
                	// answer에 누적 +
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
    	
    	int[] array = {7, 10, 19, 27, 37, 67, 77};
    	System.out.println(solution(array));
    	
    }
    
}
