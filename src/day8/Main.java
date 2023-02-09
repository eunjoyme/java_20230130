package day8;

import day8.frame.BookInsertFrame;
import day8.frame.BookSelectListPageFrame;

public class Main {

	//화면을 실행시키는 역할
	public static void main(String[] args) {
		new BookInsertFrame();
//		new BookSelectListFrame();
		new BookSelectListPageFrame();
		
//		BookDBImpl obj = new BookDBImpl();
//		
//		for(int i=0; i<23; i++) {
//			Book book = new Book();
//			book.setTitle("제목" + i);
//			book.setAuthor("저자"+ i);
//			book.setPrice(1000 + i);
//			book.setCate('A');
//			bookDB.insert
//		}
		
		//수정
//		Book book = new Book();
//		book.setNo(107);
//		book.setTitle("바보");
//		book.setAuthor("이동준");
//		book.setPrice(200);
//		book.setCate('B');
//		System.out.println(obj.updateBook(book));
		
		//삭제
//		int ret = obj.deleteBook(104);
//		System.out.println(ret);
		
		//입력한 내용 출력
//		Book book = new Book();
//		book.setTitle("제목");
//		book.setAuthor("작가");
//		int ret = obj.insertBook(book);
//		System.out.println(ret);
		
		//반복문 사용해서 목록 출력
//		List<Book>list = obj.selectBookList();
//		
//		for(Book one : list) {
//			System.out.println(one.getNo() + "," + one.getTitle()
//			        + "," + one.getAuthor()+","+ one.getPrice()+","
//					+ one.getCate()+","+ one.getDate() );
	}
}


