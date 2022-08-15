package ex02_writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONWriter {

	public static void m1() {
		
		// JSON
		// 1. JavaScript Object Notation
		// 2. 자바스크립트 객체 표기법
		// 3. 객체 : { }    하나의 데이터
		// 4. 배열 : [ ]    여러 개의 데이터
		
		// JSON-Java(JSON in Java) 라이브러리
		// 1. 객체: JSONObject 클래스 (MAP 기반으로 만들어져 사용법이 MAP과 비슷) 잘 다뤄야 한다!!
		// 2. 배열: JSONArray 클래스 (List 기반이라 arrayList와 사용법 비슷)
		// 패키지들이 org.json이라 import가 필요
		
		JSONObject obj = new JSONObject();
		obj.put("name", "김채원");
		obj.put("group", "르세라핌");
		obj.put("age", "24");
		obj.put("woman", true);
		obj.put("height", 163.5);
		
		System.out.println(obj.toString());  // obj를 텍스트로 바꿔주라
		// map기반이므로 마찬가지로 값을 추출하는데에 순서가 없음	
	}
	
	public static void m2() {
		
		JSONObject obj1 = new JSONObject();
		obj1.put("name", "안유진");
		obj1.put("age", 20);
		obj1.put("group", "IVE");
		
		JSONObject obj2 = new JSONObject();
		obj2.put("name", "장원영");
		obj2.put("age", 19);
		obj2.put("group", "IVE");

		
		// 객체가 2개 -> 배열에 집어 넣기
		JSONArray arr = new JSONArray();
		arr.put(obj1);
		arr.put(obj2);
		
		System.out.println(arr.toString());
		
	}
	
	public static void m3() {
		
		String str = "{\"woman\":true,\"name\":\"김채원\",\"age\":\"24\",\"group\":\"르세라핌\",\"height\":163.5}";
		
		JSONObject obj = new JSONObject(str);
		// str은 {}로 묶여있는 객체이므로 배열이 아닌 obj
		
		// 각 property 값을 집어 넣어서 데이터 가져오기
		//메소드가 타입과 결부되어 있다. getString, getInt, get Double...
		boolean woman = obj.getBoolean("woman");
		String name = obj.getString("name");
		int age = obj.getInt("age");
		String group = obj.getString("group");
		double height = obj.getDouble("height");
		
		// 타입의 변수를 통해 데이터 뽑아보기
		System.out.println(woman);
		System.out.println(name);
		System.out.println(age);
		System.out.println(group);
		System.out.println(height);
		
	}
	
	public static void m4() {
		
		// 배열로 된 데이터를 잘 읽어내는지 확인하기
		String str ="[{\"name\":\"안유진\",\"age\":20,\"group\":\"IVE\"},{\"name\":\"장원영\",\"age\":19,\"group\":\"IVE\"}]";
		
		JSONArray arr = new JSONArray(str);
		// 2개의 객체가 들어있으니 읽어내기 위해 for문
		System.out.println(arr.toString());
		
		// 일반 for문
		for(int i = 0, length = arr.length(); i < length; i++) {
			//System.out.println(arr.getJSONObject(i));
			
			JSONObject obj = arr.getJSONObject(i);
			String name = obj.getString("name");
			int age = obj.getInt("age");
			String group = obj.getString("group");
			System.out.println(name + "," + age + "," + group);
			
		}
		
		// 향상 for문
		for(Object idol : arr) {
			// 향상for문은 Object로 받아오는거라 JSONObject랑 타입이 맞지 않아 오류가 생긴다.
			// 따라서 JSONobject가 아닌 Objcect로 바꾸고 JSONobject를 for문 안에서 따로 선언한 후 Object를 제이슨으로 캐스팅한다.
			JSONObject obj = (JSONObject) idol;
			// idol을 JsonObject로 cast
			// 왜냐하면 읽은 값이 json배열에 들어가 있는 것이니 JsonObject로 캐스팅
			
			
			String name = obj.getString("name");
			int age = obj.getInt("age");
			String group = obj.getString("group");
			System.out.println(name + "," + age + "," + group);
			
		}
	}
	
	public static void m5() {
		
		List<String> header = Arrays.asList("제품번호","제품명","가격");  // 스트링 배열의 list
		List<String> product1 = Arrays.asList("10","감자깡","1500");
		List<String> product2 = Arrays.asList("11","포카칩","1800");
		List<String> product3 = Arrays.asList("12","자가비","2900");
		
		List<List<String>> list = Arrays.asList(product1, product2, product3);
		
		// list를 json String으로 만들어서
		// d:\\space\\snack.json 파일에 write()하기
		
		// list는 JSONArray에 대응. 먼저 list를 JSONArray로 만들자
		JSONArray arr = new JSONArray();
		
		for(List<String> line : list) {
			JSONObject obj = new JSONObject();	// line 하나를 JsonObject로 바꿔주기
			obj.put("number", line.get(0));
			obj.put("name", line.get(1));
			obj.put("price", line.get(2));
			// 배열에 obj 넣기
			arr.put(obj);
			System.out.println(arr.toString());
			
		}
		
		File file = new File("d:\\space", "snack.json");
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			bw.write(arr.toString());		
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bw != null);
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	public static void m6() {
		
		File file = new File("d:\\space", "product.json");
		
		if(file.exists() == false) {
			file.mkdirs();
		} else {
			file.delete();
		}
		
		
	}
	
	public static void main(String[] args) {
		m6();

	}

}
