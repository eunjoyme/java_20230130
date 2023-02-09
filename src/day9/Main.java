package day9;

import java.util.Date;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		try {
//			BoardDAO boardDAO =new BoardDAOImpl();
//			List<Board>list = boardDAO.selectBoardList();
//			for(Board board : list) {
//				System.out.println("게시글번호 => " + board.getBrdNo() );
//				System.out.println("게시글제목 => " + board.getBrdTitle() );
//				System.out.println("게시글내용 => " + board.getBrdContent() );
//				System.out.println("게시글작성자 => " + board.getBrdWriter() );
//				System.out.println("게시글조회수 => " + board.getBrdHit() );
//				System.out.println("게시글날짜 => " + board.getBrdDate() );
//				System.out.println("답글개수 => " + board.getReplyCount() );
//				System.out.println("답글번호는 => " + board.getReplyNoList().toString() );
//				System.out.println("----------------------------------");
//			}
	
			//답글의 개수가 n개인 이상인 게시글 조회
			BoardDAO boardDAO =new BoardDAOImpl();
			List<Board>list = boardDAO.selectBoardReplyCount( 2 );
			for(Board board : list ) {
				System.out.println("게시글번호 => " + board.getBrdNo() );
				System.out.println("게시글제목 => " + board.getBrdTitle() );
				System.out.println("게시글내용 => " + board.getBrdContent() );
				System.out.println("게시글작성자 => " + board.getBrdWriter() );
				System.out.println("게시글조회수 => " + board.getBrdHit() );
				System.out.println("게시글날짜 => " + board.getBrdDate() );
				System.out.println("답글개수 => " + board.getReplyCount() );
				System.out.println("----------------------------------");
			}
			
			//1. 접속, 컬렉션 2개 객체 변수보관
//			ReplyDB replyDB = new ReplyDBImpl();
	
			//원본 게시글을 이용한 전체 답글 조회하기, 내부적으로 vetor, arraylist 알 필요 없음.
//			List<Reply>list = replyDB.selectReplyList( 2 );
//			if(list != null) {
//				for(Reply reply : list) {
//					if(reply != null) {
//						System.out.println("답글번호 => " + reply.getNo());
//						System.out.println("답글내용 => " + reply.getContent());
//						System.out.println("답글작성자 => " + reply.getWriter());
//						System.out.println("답글일자 => " + reply.getRegdate());
//						System.out.println("---------------------------------------------");
//					}
//				}
//			}
			
			
			//수정하기(변경내용)
//			Reply reply = new Reply();
//			reply.setNo(213);
//			reply.setContent("사랑해요");
//			reply.setWriter("뚱이");
//			System.out.println(replyDB.updateReply(reply));
			
			//삭제하기
//		    short ret = replyDB.deleteReply(217);
//		    System.out.println(ret);
			
			
			//답글 1개 가져오기
//			Reply reply = replyDB.selectReplyOne(219);
//			if(reply != null) {
//				System.out.println("답글번호 => " + reply.getNo());
//				System.out.println("답글내용 => " + reply.getContent());
//				System.out.println("답글작성자 => " + reply.getWriter());
//				System.out.println("답글일자 => " + reply.getRegdate());
//				System.out.println("원본게시글정보 => " + reply.getBoard().toString());
//			}
			
			
			//답글 쓰기 테스트 3. 답글 객체
//			Reply reply = new Reply();
//			reply.setContent("복싱배웠다 밤길 조심해");
//			reply.setWriter("공주");
//			reply.setRegdate(new Date() );
//			
//			Board board = new Board();
//			board.setBrdNo( 2L );
//			
//			reply.setBoard(board);
//			
//			//2. 추가하는 메소드
//			short ret = replyDB.insertReply(reply);
//			System.out.println(ret);
//			
//			
			} catch (Exception e) {
				e.printStackTrace(); 
			}
	}

}
