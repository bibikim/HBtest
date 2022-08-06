package override02;

public class Square extends Rectangle {

	public Square(String type, double width) {
		super(type, width, width);
		
		
		// 슈퍼클래스인 Rectangle클래스의 getArea, info 그대로 가져다 사용할 수 있기 때문에
		// 오버라이드가 필요 없는 상황.
		// 정사각형은 너비높이가 같기 때문에 생성자에서 height만 지우고,
		// 슈퍼클래스의 height를 width로 바꿔줌
	}	
		
	}
	

