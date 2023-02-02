package day4;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString

public class Member {
	private String id=null;
	private String password=null;
	private String name= null;
	private String phone=null;
	private String role=null; // 이것은 권한 고객(C) 또는 판매자(S)만 가능
	private Date regdate=null;
	
	
	
	
	
	//getter,setter,toString 생성하기 lombok사용하기
	
	//이름의 길이가 유효한지 확인하는 메소드 만들기
	public boolean invalidName() {
		if(this.name.length()>=2 && this.name.length()<=4) { 
		//2~4자 사이만 true를 그 이외에는 false를 반환하기
			return true;//메소드의 종료가 됨.
	    }
		return false;
	}
	
	//휴대폰 번호 길이가 정확한지 확인하는 메소드 만들기
	public int invalidPhone() {
		if(this.phone.length()==13) {
			return 1;
		}
		return 0;
	}
	
	//권한 정보가 C와 S로만 되어 있는지 확인하는 메소드
	public int invalidRole() {
		if(this.role.equals("C") || this.role.equals("S")) {
			return 1;
		}
		return 0;
	}
	//id는 길이가 30자 이내만 가능한지 확인하는 메소드
	public boolean invalidId() {
		if(this.id.length()<=30) {
			return true;
			}
		return false;
	}
	
	//연락처 정보가 000-0000-0000인데 00000000000으로 반환하는 메소드(split 사용하기)
	public String changePhone() {
		//000-0000-0000 =>
		//ret[0] =>000
		//ret[1] =>0000
		//ret[2] =>0000
		//ret.length =>3
		String[] ret = this.phone.split("-");
		System.out.println(ret.length);
		System.out.println(ret[0]);
		System.out.println(ret[1]);
		System.out.println(ret[2]);
		
		return (ret[0]+ ret[1]+ ret[2] );
	}

	
	
	public Member() {
		super();
	}

	public Member(String id, String password, String name, String phone, String role, Date regdate) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.role = role;
		this.regdate = regdate;
	}
}
