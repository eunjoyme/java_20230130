package main;

//ctrl+shift+alt
import java.util.Scanner;

public class Main5 {

	public static void main(String[] args) {
		//클래스명 객체명=new 클래스명 (준비물);
		Scanner scanner= new Scanner(System.in);
		float a1= scanner.nextFloat();
		float a2= scanner.nextFloat();
		float a3= scanner.nextFloat();
		
		float avg = (a1+a2+a3)/ 3.0f;
		if(avg>=90) {
			System.out.println("A");
		}
		else if(avg>=80) {
			System.out.println("B");
		}
		else {
			System.out.println("C");
		}
		
		//scanner 닫기(마지막에 한번만)
		scanner.close();
	}

}
