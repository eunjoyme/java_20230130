package day14;

import java.util.Date;
import java.util.List;

public class Main2 {

	public static void main(String[] args) {
		
		BoardDB mDB = new BoardDBImpl();
		
		//게시판 등록
//		Board b = new Board();
//		b.setBrdNo(1);
//		b.setBrdTitle("어텐션");
//		b.setBrdContent("룩잇포어텐션");
//		b.setBrdWriter("뉴진스");
//		b.setBrdHit(17);
//		b.setBrdDate(new Date());
//		
//		int ret = mDB.insertBoardOne(b);
//		System.out.println(ret);
		
		//게시판 조회
		List<Board>list = mDB.selectBoardList(1);
		
		for(Board one : list) {
			System.out.println(one.getBrdNo() + ", " + one.getBrdTitle()
			        + ", " + one.getBrdContent()+", "+ one.getBrdWriter()+", "
					+ one.getBrdHit()+", "+ one.getBrdDate() );
		}
		
		//게시판 수정(제목, 내용만 변경)
//		Board b = new Board();
//		b.setBrdNo(17);
//		b.setBrdTitle("찰떡모찌");
//		b.setBrdContent("인기많음");
//		b.setBrdWriter("맛있찌");
//		b.setBrdHit(1000);
//		b.setBrdDate(new Date());
//			
//		int ret = mDB.updateBoardOne(b);
//		System.out.println(ret);
		
		//게시판 1개 조회
		Board obj = mDB.selectBoardOne(28);
		System.out.println(obj.toString() );

		//게시판 삭제
//		int rat = mDB.deletdBoardOne(22);
//		System.out.println(rat);
		
		}
	}

