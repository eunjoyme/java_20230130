package main;

import java.util.Scanner;

public class Main4 {

	public static void main(String[] args) {
		java.util.Scanner sc = new Scanner (System.in);
		System.out.print("첫번째 숫자입력?");
		int a = sc.nextInt();
		//=  => 값을 넣음
	    //== =>같으냐?
		//!= =>같지않느냐?
		if (a%5==0) {
			System.out.println("입력한 값은 5의 배수");
		}
		else {
			System.out.println("입력한 값은 5의 배수 아님");
		}
		
		//100~90 A
		//89~80 B
		//79~70 C
		//나머지 D
		if (90<= a && a<=100) {
			System.out.println("A");
		}
		else if(80<=a && a<=89) {
			System.out.println("B");
		}
		else if(70<=a && a<=79) {
			System.out.println("C");
		}
		else {
			System.out.println("D");
		}	
		
		//입력받은 숫자 a가 짝수 인지 홀수 인지 확인
		//입력받은 숫자가 3,5, 3 5 인지 확인
		//ex) 15 => 3 5
		//ex) 5  => 5
		System.out.print("두번째 숫자입력?");
		int a1 = sc.nextInt();
		//=  => 값을 넣음
	    //== =>같으냐?
		//!= =>같지않느냐?
		if (a1%2==1) {
			System.out.println("입력한 값은 홀수");
		}
		else {
			System.out.println("입력한 값은 짝수");
		}
		
		if (a1==0) {
			System.out.println("A");
		}
		
		else {
			System.out.println("B");
		}	
		
		System.out.print("세번째 숫자입력?");
		int a2 = sc.nextInt();
	
		if (a2%3==0) {
			System.out.println("입력한 값은 3,5의 배수");
		}
		else {
			System.out.println("입력한 값은 5의 배수");
		}
		
		if (a2==0) {
			System.out.println("3, 5");
		}
		else {
			System.out.println("5");	
		}	
	}

}
