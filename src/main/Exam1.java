package main;

import java.util.Scanner;

public class Exam1 {

	public static void main(String[] args) {
		//문제2) 숫자 1개 입력 10
		//         1 2 3 4 5 6 7 8 9 10
		//출력결과 => 0 0 1 0 0 1 0 0 1 0
		Scanner scanner= new Scanner(System.in);
		int num = scanner.nextInt(); //키보드로 숫자 입력정수(13)
		scanner.close();
		
		int i=0;//반복문용 임시변수
		
		for(i=1; i<=num; i++) {
			if(i%3==0) {
				System.out.print("1 ");
			}
			else {
				System.out.print("0 ");
			}
		}
		
	
	}

}
