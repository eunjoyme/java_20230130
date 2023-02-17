package day14;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		
		//DB객체 생성
		MemberDB mDB = new MemberDBImpl();
		
		//회원가입할 임의의 데이터 생성
		//아이디는 현재 DB에 없는 것만 가능
//		Member m = new Member();
//		m.setId("a1");
//		m.setPassword("a1");
//		m.setName("초코찌");
//		m.setPhone("010-1234-4321");
//		m.setRole("C");
//		m.setAge(6);
//		m.setRegdate(new Date());
//		
//		int ret = mDB.memberJoin(m);
//		System.out.println(ret);
		
		//로그인
//		Map<String, Object> map = new HashMap<>();
//		map.put("_id", "ccc3");
//		map.put("password", "ccc3");
//		Member member = mDB.memberLogin(map);
//		if(member == null) {
//			System.out.println("아이디 또는 암호가 틀립니다.");
//		}
//		else {
//			System.out.println(member.getName()+ "님 로그인 성공");
//		}
		
		//회원정보조회
		mDB.memberselectOne("ccc3");
		
		//회원정보변경
		Member m = new Member();
		m.setId("aaa2");
		m.setName("맛있찌");
		m.setPhone("010-1234-1121");
		m.setAge(8);
		int ret = mDB.memberUpdateOne(m);
		System.out.println(ret);
		
		//비밀번호 변경
		Map<String, Object>map = new HashMap<>();
		map.put("_id", "aaa1");
		map.put("password", "ccc3");
		Member member = mDB.memberLogin(map);
		if(member == null) {
			System.out.println("아이디 또는 암호가 틀립니다.");
		}
		else {
			System.out.println(member.getName()+ "님 로그인 성공");
		}
		member.setPassword("aaa1");
		int rit = mDB.memberUpdatePWOne(map);
		System.out.println(rit);
		
		
		
		
		//회원탈퇴
		int rat = mDB.memberDeletOne("aa1a");
		System.out.println(rat);
	}	
	
	
		//MongoClient db = MongoClients.create();
//		DBConn db = DBConn.getInsertance();
		
		// 확장자 java -> 컴파일 후 확장자 class -> 실행
		
		// 원시타입 (문제)바이트 타입 틀린것
		//boolean  8bit => (1byte)
		//short(2byte), int(4byte), long(8byte) 
		//float(4byte), double(8byte)
		//char(2byte)
		
		// 정수/정수 => 정수
		//정수/실수 => 실수
//		int a =14;
//		int b =20;
//		float c =6;
//		
//		결과는 a/b //(=>정수)
//		
//		//배열생성 (문제)배열 생성 방법이 아닌것은?
//		int[] a1 = new int[3];
//		int a2 [] = {0,0,0};
//		
//		//문자열의 비교 (== X 아니다)
//		equals
//		
//		//static 메소드
//		클래스명.
		
		//최대값, 최소값
		//인덱스값은 0부터
//	}

}
