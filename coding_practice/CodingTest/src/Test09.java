
public class Test09 {

	// 프로그래머스 부족한 금액 계산하기
	class Solution {
		
		// 놀이기구를 이용횟수대로 가격에 횟수를 곱하면 이용료가 됨.
		// n번때 이용 시, price에 n번 곱한 값이 그 차수의 sum이 해당 차수 이용요금
	    public long solution(int price, int money, int count) {
	        long answer = -1;
	        long sum = 0;      // 금액 범위 생각하면 놀이기구 타는데에 드는 돈은 long타입이어야 함.
	        
	        // i를 각각의 타는 횟수라고 보고 count번 탈 때까지 for문 돌려서 
	        for(int i = 0; i <= count; i++) {
	        	// 합계에 누적해준다.   놀이기구 이용료 * 횟수
	        	sum += price * i;
	        }
	        
	        // count번 탔을 때 필요 이용료(sum)가 가지고 있는 돈(money)보다 액수가 크면(총 이용료보다 돈이 부족하면)
	        if(money < sum) {
	        	// sum에서 money만큼 뺀 값을 return 하는 것이 문제의 목표
	        	answer = sum - (long)money;
	        	return answer;
	        } else {
	        	// money가 부족하지 않으면 0을 반환
	        	return 0;
	        }

	    }
	}
	
}
