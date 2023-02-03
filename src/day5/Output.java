//1.mongodb  (nosqlbooster 다운)
//데이터베이스의 주소: 1.234.5.158 <= 도메인 ihongss.com
//포트번호 : 37017
//데이터베이스: db200 ex)db213
//아이디 : id200    ex)id213
//암호 : pw200     ex)pw213
//mongodb://아이디:암호@서버주소:포트번호/DB명

//-------------------------------------

package day5;

import java.util.ArrayList;

import cls.Book;
import day4.Member;

//출력을 담당하는 클래스
public class Output {
	
	//변수 x
	public static void printBookList( ArrayList<Book> list) {
		//0 1 2
		for(int i=0; i<list.size(); i++) {
			Book oneBook =  list.get(i);
			printBook(oneBook);
		}
	}
	
	 public static void printMember(Member member) {
		 System.out.println("===========가입정보===========");
		 System.out.println("아이디는 "+ member.getId());
		 System.out.println("암호는 "+ member.getPassword());
		 System.out.println("이름은 "+ member.getName());
		 System.out.println("연락처는 "+ member.getPhone());
		 System.out.println("권한은 "+ member.getRole());
		 System.out.println("가입일자는 "+ member.getRegdate());
		 System.out.println("============================");
		 
	 }
	 
	 public static void printBook(Book book) {
		 System.out.println("=============책정보=============");
		 System.out.println("책번호는 "+ book.getNo());
		 System.out.println("책제목은 "+ book.getTitle());
		 System.out.println("저자는 "+ book.getAuthor());
		 System.out.println("가격은 "+ book.getPrice());
		 System.out.println("분류는 "+ book.getCate());
		 System.out.println("등록일자는 "+ book.getDate());
		 System.out.println("==============================");
	 }
}