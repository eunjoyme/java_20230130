package day10;

import java.util.Date;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		AddressDB aDB = new AddressDBImpl();

		//한개 
		Address address = aDB.selectAddressOne(10006);
		
		System.out.println(address.toString());
	}
}
		
		
		//멤버 정보
//		Member member = new Member();
//		member.setId("aaa1");
//		List<Address>list = aDB.selectAddressList(member);
//				if(address!= null) {
//					System.out.println("주소번호 => "+ address.getCode() );
//					System.out.println("주소 => "+ address.getAddress() );
//					System.out.println("우편번호 => "+ address.getPostcode() );
//					System.out.println("등록날짜 => "+ address.getRegdate() );
//					System.out.println("회원번호 => "+ address.getMemberid().getId() );
//					System.out.println("---------------------------------------");
//				}
//			}
//		}
		
		//정보 추가
//		Address address = new Address();
//		address.setAddress("개구리중사별");
//		address.setPostcode("9292");
//		address.setRegdate(new Date());
//		Member member =new Member();
//		address.setMemberid(member);
//		member.setId("ccc9");
//		
//		int ret = aDB.insertAddress(address);
//		System.out.println(ret);
//	}
//}

		//DB연결과 컬렉션 선택 된 상황
//		MemberDB mDB = new MemberDBImpl();
		
		//전체 출력
//		List<Map<String, Object>>list = mDB.selectMemberMapList();
//		for(Map<String, Object>map : list) {
//			System.out.println("아이디 => "+ map.get("_id"));
//			System.out.println("암호 => "+ map.get("password"));
//			System.out.println("이름=> "+ map.get("name"));
//			System.out.println("연락처 => "+ map.get("phone"));
//			System.out.println("권한 => "+ map.get("role"));
//			System.out.println("등록일 => "+ map.get("regdate"));
//			System.out.println("나이 => "+ map.get("age"));
//			System.out.println("----------------------------------");
//		}
		
		//해당 아이디 1개 값 출력
//		Map<String,Object>map = mDB.selectMemberMapOne("ccc1");
//		System.out.println("아이디 => "+ map.get("_id"));
//		System.out.println("암호 => "+ map.get("password"));
//		System.out.println("이름=> "+ map.get("name"));
//		System.out.println("연락처 => "+ map.get("phone"));
//		System.out.println("권한 => "+ map.get("role"));
//		System.out.println("등록일 => "+ map.get("regdate"));
//		System.out.println("나이 => "+ map.get("age"));
		
		//빈 map 객체를 생성
//		Map<String, Object>map = new HashMap<String, Object>();
//		map.put("_id", "ccc9");
//		map.put("password", "ccc9");
//		map.put("name", "케로로");
//		map.put("phone", "010");
//		map.put("role", "D");
//		map.put("regdate", new Date());
//		map.put("age", 80);
//		int ret = mDB.insertMemberMap(map);
//		System.out.println(ret);
		
		//배열과 다른점 : 순차적으로 데이터가 추가되지 않음.
		//키를 통해서 데이터 꺼냄
		//키는 고유해야함. 같은것은 존재할 수없음.
//		Map<String, Object> map = new HashMap<String,Object>();
//      map.put("id", "abc");
//      map.put("name", "가나다");
//      map.put("age",21);
//      map.put("name", "나다라"); 
//		수정이 일어나서 가장 하위에 작성된 값으로 바뀌게 되고 상위에 입력한 값은 없어짐.
//      ---------------------------------
//      String id = (String)map.get("id");//꺼낸 value가 object이기 때문에 형변환
//      String name = (String)map.get("name");
//      int age = (int)map.get("age");
//      
//      
//      
//   System.out.println(id);
//      System.out.println(name);
//      System.out.println(age);
