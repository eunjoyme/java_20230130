package day6;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
//**일반적으로 Member타입으로 사용하는 클래스는 getter/setter/toString 생성자
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	private String id=null;
	private String password=null;
	private String name= null;
	private String phone=null;
	private int age =0; // 나이
	private String role=null; // 이것은 권한 고객(C) 또는 판매자(S)만 가능
	private Date regdate=null;
	
}
