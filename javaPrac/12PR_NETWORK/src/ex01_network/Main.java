package ex01_network;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Main {

	public static void m1() {
		
		// URL
		// 1. 정형화된 자원의 경로. 웹 주소를 의미
		// 2. 구성
		// 프로토콜://  호스트     /서버경로?파라미터=값&파라미터=값&....          utf-8&쿼리= "환율"이 인코딩된 데이터
		// https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=%ED%99%98%EC%9C%A8
		//   1) 호스트 : 서버 주소(호스트 뒤에 :포트번호 가 붙을 수 있다. 생략가능
		//   2) 서버경로 : URL Mapping. 서버 경로에 따라 다른 내부 처리가 이루어짐. 개발자가 정함
		//   3) 파라미터 : 서버로 전송하는 데이터. 어떠한 기능을 수행하기 위해 보내줘야하는 데이터
	
		try {
			
			// URL 처리를 위한 URL클래스
			String apiURL = "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=환율";
			URL url = new URL(apiURL); // 예외처리 필수
			
			// URL 확인
			System.out.println(url.getProtocol()); // 객체url의 프로토콜 확인
			System.out.println(url.getHost());
			System.out.println(url.getQuery()); 
			
		} catch (MalformedURLException e) {
			System.out.println("API 주소 오류");
		}
		
	}

	
	public static void m2() {
		
		// HttpURLConnection 클래스 (접속하기)
		// 1.웹 접속을 담당하는 클래스
		// 2. URL클래스와 함께 사용 - URL클래스의 자식클래스
		// 3. URL클래스의 openConnection() 메소드를 호출해서 HttpURLConnection클래스 타입으로 저장
	    //    즉, 부모의 메소드를 호출하지만 실제 저장은 자신에게!
		
		try {
			
			// 접속
			String apiURL = "https://www.daum.net";
			URL url = new URL(apiURL);
			
			// 커넥션 오픈
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			
			System.out.println("응답코드 : " + con.getResponseCode());
			System.out.println("정상 : " + HttpURLConnection.HTTP_OK);
 			System.out.println("Not Found : " + HttpURLConnection.HTTP_NOT_FOUND);
			System.out.println("Internal Error : " + HttpURLConnection.HTTP_INTERNAL_ERROR);
			
			System.out.println("컨텐트 타입 : " + con.getContentType());
			System.out.println("요청 방식 : " + con.getRequestMethod());
			
			// 접속 해제
			con.disconnect(); 
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void m3() {
		
		// HttpURLConnection과 스트림
		// 스트림 관련 모든 메소드를 사용할 수 있다.
		
		try {
			
			String apiURL = "https://www.naver.com";
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			
			// 바이트 입력 스트림
			InputStream in = con.getInputStream(); // 바이트스트림
			
				// 각종 태그/문자로 구성된 텍스트 파일의 웹페이지 화면을 인풋스트림을 통해 자바로 읽어오는데
			 	// 인풋스트림은 바이트 기반이라 그대로받아오면 글자가 다 깨지니까
				// 문자 입력 스트림인 InputStreamReader로 읽어줘야 한다.
			
			// 문자 입력 스트림으로 변환
			InputStreamReader reader = new InputStreamReader(in); // inputstream으로읽어온걸 inputstreamReader로 읽어오기
			
			// 모두 읽어서 StringBuilder에 저장
			StringBuilder sb = new StringBuilder();
			char[] cbuf = new char[100];
			int readCnt = 0;
			
			while((readCnt = reader.read(cbuf)) != -1) {
				sb.append(cbuf, 0, readCnt);
			}
			
			// sb의 모든 내용을 d:\\storage\\네이버.html로 보내기
			File file = new File("d:\\storage", "naver.html");
			FileWriter fw = new FileWriter(file);
			
			fw.write(sb.toString());
			reader.close();
			fw.close();
			con.disconnect();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void m4() {
		
		// 인코딩 : UTF-8 방식으로 암호화
		// 디코딩 : UTF-8 방식으로 복호화(복원한단 뜻)
		// 원본 데이터 -> 인코딩 -> 전송 -> 디코딩(서버측) -> 원본 데이터
		
		// 파라미터=값&파라미터=값... >> 서버측으로 변수와 값들을 보낼 때 인코딩 해서 보내줘야 한다.
		
		try {
			
			// 원본 데이터
			String str = "한글 spanish 748393 @$!%^+";	// 공백은 +로 변환, 내가 입력한 +는 2B
			
			// 인코딩
			String encode = URLEncoder.encode(str, "UTF-8"); 
			System.out.println(encode);
			     // URLEncoder의 메소드 .encode(String s, String enc);
			
			// 디코딩
			String decode = URLDecoder.decode(encode, StandardCharsets.UTF_8);
			System.out.println(decode);  // ㄴ 인코딩 된 데이터를 디코딩 하는 거니까 string 자리에 encode
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	public static void main(String[] args) {
		m4();

	}

}
