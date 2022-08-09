package ex01_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	
	public static void m1() {
		
		// 생성
		// 제너릭 기반. (타입 적어주는 방식)
		// 생성할 때 데이터타입을 결정한다.
		
		List<String> list = new ArrayList<String>();   // > import 해줘야함(인터페이스로)
		
		// 요소 추가
		// 개봉순서
		list.add("반도");
		list.add("D.P");
		list.add("꿈의 제인");
		list.add("모가디슈");
		list.add(0, "메기");	// 인덱스 지정. 메기부터 0,1,2,3 ... 
	
		System.out.println(list);
		
		// 요소 제거
		boolean result = list.remove("D.P");
		boolean result2 = list.remove("괴이");
		System.out.println(result);
		System.out.println(result2);		
		System.out.println(list);
	
		String removeArt = list.remove(0);
		System.out.println(removeArt);
		System.out.println(list);

		// 요소 수정
		list.set(1, "탈주");
		
		// 리스트 확인
		System.out.println(list);
		
	}
	
	public static void m2() {
		
		// 리스트 초기화
		// 배열을 리스트로 변환하는 것
		// 초기화로 만든 리스트에는 값을 바꿀 수 없다. 고정된 길이의 list를 가짐. 추가삭제 불가
		List<String> list = Arrays.asList("1반", "2반", "3반");
		
		// 리스트 길이
		int size = list.size();
		System.out.println(size);
		
		String element1 = list.get(0);
		String elemnet2 = list.get(1);
		
		System.out.print(element1 + " ");
		System.out.println(elemnet2);
		
		// for문 순회
		for(int i = 0, length = list.size(); i < length; i++) {
			System.out.println(list.get(i));
			// 길이를 list.size 메소드로 한번만 호출하고, length로 순회를 돌도록 해준다

		// 향상 for문
		// for(변수타입 변수이름 : 배열 이름) { }
		for(String element : list) {
			System.out.println(element);
		
			
			
			
		}
	
			
		}
		
	}
	
	public static void m3() {
		
		// 제너릭
		// 참조 타입만 사용 가능. 기본 타입이 필요한 경우 타입의 Wrapper Class 사용
		// 기본타입을 클래스화한 8개의 클래스.
		
		List<Integer> list = new ArrayList<Integer>();
		// int 안됨. 
		
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(list);
		
		// 비어있는 리스트인지?
		boolean result = list.isEmpty();
		System.out.println(result);
		
		// 특정 요소를 포함하고 있는지?
		if(list.contains(1)) {
			System.out.println("1을 포함한다");
		} else {
			System.out.println("1을 포함하고 있지 않다");
		}
		
		
		
		
	}

	public static void main(String[] args) {
		m3();

	}

}
