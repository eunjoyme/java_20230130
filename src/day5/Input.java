package day5;

import java.util.Date;
import java.util.Scanner;

import cls.Book;
import day4.Member;

//입력을 담당하는 클래스
public class Input {
	
	//변수 x
	
	public static Member inputData() {
		Scanner in = new Scanner(System.in);
		System.out.println("가입정보입력 => 아이디, 암호, 이름, 연락처, 권한");
		//String data =  new StrinG("입력한 값')
		//String의 메소드 중에서 split(), trim()
		String data = in.nextLine(); // a,b, 가나다, 010-0000-0000, C
		in.close();
		
		//문제),분할하고 각각의 데이터에 대해 앞뒤에 공백이 있으면 제거
		String[] str = data.split(",");
		Member member = null;  //아직 객체가 안만들어 졌음
		if(str.length==5 ) {  // 입력한 항목이 정확한지 개수로 확인함.
			member = new Member(str[0].trim(),
					str[0].trim(),str[2].trim(),
					str[3].trim(),str[4].trim(),
					new Date() );
		}
		return member;
	}
	
	
public static Book inputBookData() {
	Scanner in = new Scanner(System.in);
	System.out.println("가입정보입력 => 번호, 제목, 저자, 가격, 분류, 등록일자");
	String str = in.nextLine();
	//in.close();
	String[] data = str.split(",");
	Book book = null;  
	if(data.length==5 ) {  
		int no= Integer.parseInt(data[0].trim());
	    String title = data[1].trim();
	    String author = data[2].trim();
	    long price = Long.parseLong(data[3].trim());
	    char cate = data[4].trim().charAt(0);
		book = new Book(no, title, author, price ,cate ,new Date());
	}
	return book;
}


private static String str() {
	// TODO Auto-generated method stub
	return null;
}
}

