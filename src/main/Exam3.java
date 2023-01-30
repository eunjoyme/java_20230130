package main;


public class Exam3 {

	public static void main(String[] args) {
		
		int i=0; 
		int j=0;
		int sum = 0; 
		int sum1=0;
		int sum2=0;
		
		//문제1) 숫자 5를 입력하면 아래 처럼 출력하시오.]
		//1 2 3 4 5 4 3 2 1 
		for(i=1; i<=5; i++){  // 1 2 3 4 5
			System.out.print(i + " ");	
		}
		
		for(j=4; j>=1; j--) {//4 3 2 1 
			System.out.print(j+ " ");
			}

		System.out.println();
		
		//문제2) 숫자 13을 입력하면 3의 배수의 합구하기
		//3 6 9 12 =>30
		
		for(i=0; i<=13; i++) {// 0 1 2 3 4 ...13
			if(i%3==0) {
				sum += i;
			}
		}
		System.out.println("합은= " + sum);
				

	//문제3) 숫자 10을 입력하면 홀수의 합 짝수의 합 각각 합구하기
			//3 6 9 12 =>30
	
	
	for (i=1; i<=10; i++) {
		if(i%2==0) {
			sum1=sum1+i;
	}
		else {
			sum2+=i;
		}
	}
	System.out.println(sum1);
	System.out.println(sum2);
		
	
	//문제4) 숫자 7을 입력하면 구구단 구하기
			//7*1=7
	//7*2=14
	//7*3=21
	for(i=1; i<=9; i++) {
		System.out.println("7 * "+ i + "=" + (7*i));
			
	}
	}
}


