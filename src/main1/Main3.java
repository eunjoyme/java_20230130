package main1;

//문자열
public class Main3 {
	public static void main(String[] args) {
		
		//import 안함, 
		//클래스명 객체명 = new 클래스명(준비물);
		String str= new String("hello world");
		String str1 = "hello world";
	
		//ret[0] = hello
		//ret[1] = world
		String[] ret= str.split(" "); //원하는 기준 문자로 분할하기
		System.out.println(ret[0]);
		System.out.println(ret[1]);
		
		System.out.println(str);
		System.out.println(str1);
		
		//String 클래스의 기능중에서 substring을 사용한 경우
		System.out.println(str.substring(0, 3)); // hel
		
	}

}
