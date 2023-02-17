package day15;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String [] args) {
		
		//1. 객체 생성
		BookStore bookStore = new BookStore();
		
		//1.5 준비물
		Book book = new Book();
		book.setCode(2);
		book.setTitle("프로젝트에이");
		book.setAuthor("김자바");
		book.setPrice(15000);
		book.setRegdate(new Date());
		
		//2.호출하기
		int n = bookStore.addBook(book);
		System.out.println(n);
		
		System.out.println("----------------------");
		 
		//3.첵제목이 포함된 것 검색 
		List<Book> list = bookStore.searchBook("프로젝트에이");
		for(Book one : list) {
			System.out.println(one.getCode());
			System.out.println(one.getTitle());
			System.out.println(one.getAuthor());
			System.out.println(one.getPrice());
			System.out.println(one.getRegdate());
		}
		
		System.out.println("----------------------");
		
		//가격보다 큰것만 검색
		List<Book>list1 = bookStore.searchBookPrice(10000);
		for(Book one : list1) {
			System.out.println(one.getCode());
			System.out.println(one.getTitle());
			System.out.println(one.getAuthor());
			System.out.println(one.getPrice());
			System.out.println(one.getRegdate());
		}
		
//		Print print = new Print();
//		
//		//3권 정도 임의의 값으로 추가한후 실행하기
//		List<Book>list = new ArrayList<>();
//		for(int i=0; i<3; i++) {
//			Book book = new Book();
//			book.setCode(i+1);
//			book.setTitle("aaa");
//			book.setPrice(1200);
//			book.setAuthor("저자");
//			list.add(book);
//		}
//		print.printBook(list);
		
		//전체 책과 필터하는 가격 조건 전달 받으면 가격보다 큰 책만 반환
		
		
		
		//가격에서 일의 자리가 0인것만 조회
		
		
		
		//문제1)구구단
//		print.gugudan(3);
		
		//문제2)n개의 정수형이 오면 합을 구해서 반환하는 메소드 구현
//		List<Long>list = new ArrayList<>();
//		list.add(1L);
//		list.add(2L);
//		list.add(3L);
//		long t = print.sum(list);
//		System.out.println(t);
		
		//문제3) n개의 실수형이 전달되면 합과 평균을 구해서 반환하는 메소드 구현
//		List<Double>list1 = new ArrayList<>();
//		list1.add(1.2d);
//		list1.add(2.2d);
//		Map<String, Object> map = print.sumAvg(list1);
//		System.out.println(map.get("sum111"));
//		System.out.println(map.get("avg222"));
		
	}
}
