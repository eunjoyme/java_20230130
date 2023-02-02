package day4;

import java.util.Date;

public class MemberMain {

	public static void main(String[] args) {
		//1.객체 생성(값 세팅)
		//클래스명 소문자클래스명= new 생성자명();
		Member member = new Member( "id", "pw", "name", "010-0000-0000" ,
				"C", new Date() );
		//현재 클래스 가지고 있는 값을 확인
		System.out.println(member.toString() );
		
		//2.세팅된 이름값이 유효한지 확인하기
		boolean result = member.invalidName();
		System.out.println(result);
		
		int result1 = member.invalidPhone();
		System.out.println(result1);
		
		int result2= member.invalidRole();
		System.out.println(result2);
		
		boolean result3=member.invalidId();
		System.out.println(result3);
		
		String ret = member.changePhone();
		System.out.println(ret);
		
		//3.
		
	}

}
