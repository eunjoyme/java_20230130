package day6;

import java.util.Date;

public class Main1 {

	public static void main(String[] args) {
		
		//1. 객체 생성
		//db서버에 접속하고 members collection 접속
		MemberDB mDB = new MemberDB();
//		int ret = mDB.deletMember("aaa");
//		System.out.println(ret);
		
		
		//mDB.printMembers();
		//mDB.printMembersName("가나다");
		//mDB.printMembersRole("C");
		//mDB.printMembersAge(13);
		
		Member member = new Member();
		member.setId("aaa1");
		member.setName("변경될 이름");
		member.setPhone("010-1234-1111");
		member.setAge(34);
		mDB.updateMember(member);
		
		//2. 회원가입하고 싶은 임시 데이터(아이디, 암호, 이름, 연락처, 나이, 권한, 현재시간)
		//Member member = new Member("aaa", "pw1", "이름", "010", 12, "C", new Date() );
		
		//3. DB에 추가하는 메소드 수행
//		int ret = mDB.insertMember(member);
//		System.out.println(ret);
		
		
		
		
		//클래스명 객체명 = new 생성자종료()
		//Exam1 exam1 = new Exam1( 10 );
		
		//메소드는 객체명을 통해 접근
		//exam1.printAge();
		
		//다시 나이정보를 변경
		//exam1.setAge(20);
		//exam1.setAge(40);
		//exam1.setAge(60);
	}

}
