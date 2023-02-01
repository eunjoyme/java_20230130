package main2;

import java.util.Date;

import cls.Book;
import cls.BookStore;

public class Main2 {

	public static void main(String[] args) {

		//서점이 생성됨. 책을 100권 보관할 수 있는 배열생성
		BookStore bookStore = new BookStore();
		bookStore.setPhone("051-707-7070");
		bookStore.setAddress("부산 남구");
		
		//추가하고자 하는 책을 생성
		Book book = new Book(100, "아기돼지", "김은정", 1230, 'B', new Date() );
				
	    //서점에 1권의 책 등록
		bookStore.insertBook(book);
		
		//문제1) 임의의 책을 2권 생성한 후 서점에 등록하기
		Book book2 = new Book(101, "빨간망토", "김지현", 1100, 'A', new Date() );
		Book book3 = new Book(102, "겨울왕국", "박성주", 1200, 'B', new Date() );
		
		bookStore.insertBook(book2);
		bookStore.insertBook(book3);
		
		bookStore.deleteBook();
		
		//현재까지 등록된 책 조회;
		bookStore.selectBook();
	}

}
