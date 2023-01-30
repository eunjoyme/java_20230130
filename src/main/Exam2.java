package main;

public class Exam2 {

	public static void main(String[] args) {
		int i=0; //반복문 임시 변수
		int j=0;
		
		for(i=1; i<=5; i++) {  // 1 2 3 4 5
			for(j=1; j<=i; j++) { //1 12 123 1234 12345
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(i=1; i<=5; i++) { //1 2 3 4 5 
			for(j=1; j<=(6-i); j++) { // 12345 1234 123 12 1
				System.out.print("*");
			}
			System.out.println();
		}

		for(i=1; i<=5; i++) { //1 2 3 4 5 
			for(j=1; j<=(2*i-1); j++) { // 1 123 12345 1234567 123456789
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
