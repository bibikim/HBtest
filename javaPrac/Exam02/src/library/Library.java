package library;

import java.util.Scanner;

// 책 추가, 제거 검색, 조회

public class Library {

	// 
	private Scanner sc;
	private Book[] books;
	private int idx;
	
	public Library() {
		sc = new Scanner(System.in);
		books = new Book[100];
	}
	
	
	private void addBook() {
		if(idx == books.length) {
			System.out.println("책장이 꽉 찼습니다.");
			return;
		}
		System.out.println("### 책 등록 ###");
		System.out.println("제목 입력 >>> ");
		String title = sc.next();
		System.out.println("저자 입력 >>> ");
		String authoer = sc.next();
		Book book = new Book(idx + 1, title, authoer);
		books[idx++] = book;
		System.out.println("새 책이 등록 되었습니다.");
			
	}
	
	
	private void removeBook() {
		if(idx == 0) {
			System.out.println("등록된 책이 한 권도 없습니다.");
			return;
		}
		System.out.println("### 책 삭제 ###");
		System.out.println("삭제할 책의 번호 입력 >>> ");
		int bookNo = sc.nextInt();
		System.out.println("정말 삭제하시겠습니까?(y/n)");
		String yesNo = sc.next().substring(0, 1);
		sc.nextLine();
			if(yesNo.equalsIgnoreCase("y")) {
				for(int i = 0; i < idx; i++) {
					if(bookNo == books[i].getBookNo()) {
						System.arraycopy(books, i, books, i, idx - i - 1);
						books[--idx] = null;
					
				System.out.println("책 번호가 " + bookNo + "인 책을 삭제했습니다.");
				return;
				}
			}
			System.out.println("책 번호가 " + bookNo + "인 책은 없습니다.");	
		}
		
		
	}

	private void findBook() {
		if(idx == 0) {
			System.out.println("등록된 책이 한 권도 없습니다.");
			return;
		}
		System.out.println("### 책 조회 ###");
		System.out.println("조회할 책 제목 입력 >>>");
		String title = sc.next();
		for(int i = 0; i < idx; i++) {
			if(books[i].getTitle().equals(title)) {
			System.out.println(books[i]);
			return;
		}
		}
		System.out.println("제목이 " + title + "인 책은 없습니다.");
	}

	private void printAllBook() {
		if(idx==0) {
			System.out.println("등록된 책이 한 권도 없습니다.");
			return;
		} 
		System.out.println("### 전체 조회 ### ");
		for(int i = 0; i < idx; i++) {
			System.out.println(books[i]);
		}
		
		
	}
	
	
	
	
	public void manage() {
		
		while(true) {
			System.out.println("1.추가 2.삭제 3.조회 4.전체목록 0.프로그램 종료 >>> ");
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1: addBook(); break;
			case 2: removeBook(); break;
			case 3: findBook(); break;
			case 4: printAllBook(); break;
			case 0: System.out.println("프로그램을 종료합니다."); return;
			default : System.out.println("인식하지 못하는 명령입니다.");
			
			}
		}
		
		
	}
	
	
	
	
}
