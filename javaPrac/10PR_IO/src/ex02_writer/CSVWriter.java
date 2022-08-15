package ex02_writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CSVWriter {
	
	
	public static void main(String[] args) {
		
		// CSV
		// 1. Comma Separate Values
		// 2. 콤마로 분리된 값들
		// 3. 확장자가 .csv인 파일
		// 다량의 데이터를 받아볼 때 주로 쓴다.
		
		// d:\space\product.csv
		// 제품번호, 제품명, 가격\n
		// 10,감자깡,1500\n
		// 11,포카칩,1800\n
		// 12,자가비,2900\n
		
		List<String> header = Arrays.asList("제품번호","제품명","가격");  // 스트링 배열의 list
		List<String> product1 = Arrays.asList("10","감자깡","1500");
		List<String> product2 = Arrays.asList("11","포카칩","1800");
		List<String> product3 = Arrays.asList("12","자가비","2900");
		
		List<List<String>> list = Arrays.asList(header, product1, product2, product3);
		// List를 List에 또 넣은 것.
		// 1차원 배열 4개가 여러 개 있는 형태
		
		File file = new File("d:\\space", "snack.csv");
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			for(int i = 0, length = list.size(); i < length; i++) {
				List<String> line = list.get(i);  // arrayList에서 i값을 확인 할때는 get(i). 
				// line = [10,감자깡,1500] 데이터를 3개씨 갖고 있는 한 줄 한 줄.
				for(int j = 0, size = line.size(); j < size; j++) {
					// 배열이 2개니까 이중for문~
					if(j == size -1)      // 배열의 마지막 요소(size - 1)라면 
						bw.write(line.get(j) + "\n");// 데이터요소값 보여주고 줄바꿈 하겠다
					else
						bw.write(line.get(j) + ","); 	
					// get(j)는 line의 3개의 데이터 각각 하나씩을 말함.
				}
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bw != null);
				bw.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
	}

}
