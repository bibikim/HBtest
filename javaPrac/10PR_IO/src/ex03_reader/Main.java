package ex03_reader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	
	public static void m1() {
		
		File file = new File("d:\\space", "less.txt");
		FileReader fr = null;
		try {
			
			// FileReder 클래스 생성
			// File 객체에 등록된 파일이 없으면 FileNotFoundException 발생
			fr = new FileReader(file);
			
			// FileReader 입력 데이터
			// 1. 한 글자 : int
			// 2. 여러 글자 : char[]
			
			int c;
			
			// read()메소드
			// 1. 읽은 문자를 반환하는 메소드
			// 2. 모두 읽어서 읽을 문자가 없으면 -1을 반환. 즉 다 읽으면 -1을 반환
			
			// String str에 읽은 파일 내용 저장
			StringBuilder sb = new StringBuilder();
			while(true) {
				c = fr.read();
				if(c == -1) {
					break;		// 그만하겠다
				}
				sb.append((char)c);
				// c는 int 타입이니까 char타입으로 캐스팅
			}
			String str = sb.toString();		
			System.out.println(str);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fr != null)
					fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void p1() {
		
		File file = new File("d:\\space", "less.txt");
		FileReader fr = null;
		
		try {
			
			fr = new FileReader(file);
			int c;
			StringBuilder sb = new StringBuilder();
			
			while((c = fr.read()) != -1) {
				sb.append((char)c);
			}
			
			String str = sb.toString();
			System.out.println(str);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fr != null);
					fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void m2() {
		
		File file = new File("d:\\space", "m5.txt");
		FileReader fr = null;
		
		try {
			
			fr = new FileReader(file);
			
			// 5글자씩 읽어와 저장할 배열
			char[] cbuf = new char[5];		// 배열의 길이만큼 글자를 읽어온다.
			
			// read(char[]) 메소드 : read메소드에 char배열이 들어가는 메소드
			// 1. 읽은 글자는 cf 배열에 저장
			// 2. 실제로 읽은 글자 수를 반환
			// 3. 읽은 글자가 없으면 -1을 반환
			
			while(true) {
				
				int readCnt = fr.read(cbuf); 	// readCnt는 읽은 갯수
				// cbuf(읽어주는 글자) = 하울의 성   5글자
				// 배열의 길이로 반복문을 돌렸을 때에 생길 잘못된 출력을 막기 위해
				// 배열의 길이만큼 readCnt를 지정한다
				
				if(readCnt == -1) {
					break;
				}
				for(int i = 0; i < readCnt; i++) {	// 읽은 글자 수 readCnt만큼 반복
					System.out.print(cbuf[i]);
				}
				
			}	
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fr != null);
					fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
			
	} 
		
	
	

	public static void main(String[] args) {
		m2();
	}

}
