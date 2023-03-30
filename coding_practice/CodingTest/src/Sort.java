import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> list = new ArrayList<Integer>();
		
		list.add(1);
		list.add(8);
		list.add(4);
		list.add(7);
		list.add(2);
		
		System.out.println("정렬 전 : " + list);
		
		Collections.sort(list);
		System.out.println("정렬 후 : " + list);
		
		Collections.reverse(list);
		System.out.println("리버스 정렬 : " + list);
		
	}

}
