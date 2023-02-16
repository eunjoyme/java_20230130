package day14;

import java.util.Date;

import lombok.Data;

@Data
public class Member {

	String id;    //기본키 => 고유값
	String password;
	String name;
	String phone;
	String role;
	int age;
	Date regdate;
	
}
