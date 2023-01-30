package main;

//변수->조건문->반복문->배열->클래스(중요)

//주석문 설명 적는 것
//*여러줄*/
//폰트 크기 확대 ctrl+(더하기+)(빼기-)
//클래스명 첫번째 문자 대문자
//변수명 소문자
//메소드(함수)

public class Main1 {

	public static void main(String[] args) {
//		타입 변수명=초기값;
//		byte,short,int,long =>정수 ex)3,-1
//		char                =>문자 ex)'a' '1' 'N'
//		float,double        =>실수 ex)1.0, 1.34
//		boolean 참거짓        =>true, false
		
		int a=15;
		int b=16;
		
		System.out.println(a+b);//더하기
		System.out.println(a-b);//빼기
		System.out.println(a*b);//곱하기
		System.out.println(a/b);//나누기
		//나누기 (정수/정수=>정수),(정수/실수=>실수)
		System.out.println(a%b);//나머지
		
		//문제)각 자리수의 합을 구하시오.(100~999)
		int c=124;
		int c1=c%10;//4
		int c2=c/10%10;//2
		int c3=c/100;//1
		System.out.println(c1+c2+c3);

		//문제2) 1000~9999의 숫자를 뒤집어서 출력하시오.
		//ex)2451=>1542
		int d=2451;
		int d1=d%10;//1
		int d2=d/10%10;//5
		int d3=d/100%100;//4
		int d4=d/1000;//2
		
		int d5= d1*1000+ d2*100+ d3*10 +d4;
		System.out.println(d5);
	}
}
