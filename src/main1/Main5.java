package main1;

import java.util.Date;

import cls.Board;

public class Main5 {
	public static void main(String[] args) {
	//1.객체 생성	
	Board brd = new Board();

	//2.객체를 기반으로 메소드를 사용해서 적절한 일을 수행
	brd.setBrdNo(1L);
	brd.setBrdTitle("제목");
	brd.setBrdContent("내용");
	brd.setBrdWriter("작성자");
	brd.setBrdHit(1345L);
	//Date date = new Date(); 생략함 
	brd.setBrdDate(new Date() );
			
    //3.toString 을 호출해서 현재의 값을 출력	
	System.out.println(brd.toString() );
 }
}