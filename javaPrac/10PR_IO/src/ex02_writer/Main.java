package ex02_writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	
	public static void m1() {
		// Stream
		// 스트림까지 뚫어서 파일을 만드는 것. 스트림 FileWriter를 통해서 내용을 채울 수도, 읽어줄 수도 있다.
		// file 객체를 통해 file과 연결해서 입출력 stream 만들기
		
		// Writer
		// 문자 기반 출력 스트림의 최상위 추상클래스
		// 모든 문자 기반 출력 클래스는 Writer클래스를 상속받아 만들어진다
		// FileWriter, BufferedWriter,OutputStream, PrintWriter
		
		File dir = new File("d:\\space");
		
		if(dir.exists() == false)
			dir.mkdirs();
		
		File file = new File(dir, "fear.txt");
		
		FileWriter fw = null;
		
		try {
			
			// 출력 스트림(d:\\space\\fear.txt 파일과 연결되는 문자 출력 스트림 생성하기)
			// 출력 스트림이 생성되면 파일도 생성된다.
			// 따라서 굳이 file.createFile을 써주지 않아도 된다.
			fw = new FileWriter(file);
			
			// 내가 만든 FileWriter는 닫아줘야 한다. fw.close();	
		} catch (IOException e) {
			e.printStackTrace();
			// 스트림 생성도 항상 예외 처리가 필요하다. 
		} finally {	 	// 언제나 마지막에 한번 실행되는 블록
			try {		// fw를 꼭 한번은 닫아야 하기 때문에 finally블록에 넣어준다
				
				if(fw != null)
					fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 출력 스트림을 이용해서 파일을 생성하면 원래 있던건 삭제하고 새로 생성을 한다.
		// fw.close는 finally 블록 안에 넣어줘야 한다. 예외 발생시에 동작을 안 할 수 있는 상황에 대비해서.
		
		// FileWriter의 선언은 try블럭 밖에서 null값으로 하고 생성은 try블럭 안해서 한다.
		// 실무에서는 새로운 try블럭을 만들지 않고 그냥 첫 트라이블럭 안에서 해결하기도 함.
		// try{
		//        FileWriter fw = new FileWriter(file);
		//                fw.close();
		// } catch (IOException e) {
		//      e.printStackTrace();
		// }
		
	}
	
	public static void m2() {
		
		// try-catch-resources문
		// 1. resources는 자원을 의미. 여기서 자원은 Stream을 말한다.
		// 2. 스트림의 종료(close)를 자동으로 처리하는 try-catch문
		// 3. 형식
		//    try(Stream 생성) {
		//           코드코드코드
		//    } catch (IOException e) {
		//        e.printStackTrace();
		//    }                                완.
		// 기본 형식에서 finally 존재의 이유는 close() 때문이었기에!
		
		File file = new File("d:\\space", "fear.txt");
		
		// try 바로 옆에 FileWriter 스트림 생성을 해주면 finaylly와 close 안 해줘도 된다.
		try (FileWriter fw = new FileWriter(file)) {
			
			 
			 // 출력할 데이터
			 // 1. 한 글자 : int
			 // 2. 여러 글자 : char[], String >> CharSequence라고 함
			 int c = 'I';
			 char[] cbuf = {' ', 'a', 'm'};
			 String str = " Kazuha";
			 
			 // 출력스트림으로 보내기(출력)
			 fw.write(c);
			 fw.write(cbuf);
			 fw.write(str);
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
	
	public static void m3() {
		
		File file = new File("d:\\space", "less.txt");
		
		try(FileWriter fw = new FileWriter(file)){
			
			fw.write("Love Dive");
			fw.write("\n"); //줄 바꿈
			fw.write("지금 널 찾아가고 있어\n");
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public static void m4() {
		
		File file = new File("d:\\space", "fim.txt");
		
		try(FileWriter fw = new FileWriter(file)) {
			
			char[] cbuf = {'a', 'b', 'c', 'd', 'e', 'f'};
			String str = "abcdef";
			
			fw.write(cbuf, 0, 2);	// 인덱스 0부터 두 글자만 쓴다    a b
			fw.write(str, 2, 3);	// 인덱스 2부터 네 글자를 쓴다	  c d e
			// 출력된 글자는 abcde
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void m5() {
		
		// FileWriter는 속도가 느려서
		// 빠른 속도가 필요할 경우에는 Buffered Writer를 추가해서 함께 사용한다.
		
		File file = new File("d:\\space", "m5.txt");
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw); 
			// FileWriter를 빠르게 하는 것이기 때문에 () 안에 FileWriter의 참조변수 fw를 넣어준다
			
			bw.write("하울의 움직이는 성\n");
			bw.write("센과 치히로의 행방불명");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 버퍼 스트림을 닫아주면 메인스트림인 fw도 자동으로 닫히기 때문에 bw.close만 해주면 된다.
				if(bw != null) 
					bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	public static void main(String[] args) {
		m5();

	}

}
