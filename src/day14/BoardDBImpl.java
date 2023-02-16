package day14;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;

import day8.Config;

public class BoardDBImpl implements BoardDB{

	MongoCollection<Document> boards = null;
	private MongoCollection<Document> seqColl = null;
	
	public BoardDBImpl() {
		boards = DBConn.getInstance()
				.getCollection(Config.BOARDCOL);
		seqColl= DBConn.getInstance()
				.getCollection(Config.RESEQUENCECOL);
	}

	//게시판 글쓰기
	@Override
	public int insertBoardOne(Board board) {
		try {
			Bson filter = Filters.eq("_id", "SEQ_BOARD_NO");
			Bson update = Updates.inc("idx", 1);
			
			Document doc = this.seqColl.findOneAndUpdate(filter, update);
			
			long brdnumber = doc.getLong("idx");
			
			Document doc1 = new Document();
			doc1.append("_id", brdnumber);
			doc1.append("title", board.getBrdTitle());
			doc1.append("content", board.getBrdContent());
			doc1.append("writer", board.getBrdWriter());
			doc1.append("hit", board.getBrdHit());
			doc1.append("regdate", board.getBrdDate());
			
			InsertOneResult result = this.boards.insertOne(doc1);
			System.out.println(result.toString());
			
			if(result.getInsertedId().asInt64()
					.getValue()==brdnumber){
				return 1;
			}
		return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	//게시판 조회(최신글 순으로 10개씩)
	@Override
	public List<Board> selectBoardList(int page) {
		try {
			//page 1 => 0
			//page 2 =>10
			//page 3 =>20
			List<Board> list = new ArrayList<Board>();
			
			Bson sort = Filters.eq("_id", -1);
			FindIterable<Document>docs 
			 = this.boards.find().sort(sort).skip(10*(page-1)).limit(10);
			for(Document doc : docs) {
				Board board = new Board();
				board.setBrdNo(doc.getLong("_id"));
				board.setBrdTitle(doc.getString("title"));
				board.setBrdContent(doc.getString("content"));
				board.setBrdWriter(doc.getString("writer"));
				board.setBrdHit(doc.getLong("hit"));
				board.setBrdDate(doc.getDate("regdate"));
			
				list.add(board);
			}
		return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//게시판 수정(제목, 내용만 변경)
	@Override
	public int updateBoardOne(Board board) {
		try {
			Bson filter = Filters.eq("_id", board.getBrdNo());
			
			Bson update1= Updates.set("title", board.getBrdTitle());
			Bson update2 = Updates.set("content", board.getBrdContent());
			
			Bson update = Updates.combine(update1, update2);
			UpdateResult result = this.boards.updateOne(filter, update);
			System.out.println(result.toString());
			return 1; 
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	//게시판 1개 조회
	@Override
	public Board selectBoardOne(long no) {
		try {
			Bson filter = Filters.eq("_id", no);
			Document doc = this.boards.find(filter).first();
//			System.out.println(doc.toString());
			
			Board board = new Board();
			board.setBrdNo(doc.getLong("_id"));
			board.setBrdTitle(doc.getString("title"));
			board.setBrdContent(doc.getString("content"));
			board.setBrdWriter(doc.getString("writer"));
			board.setBrdHit(doc.getLong("hit"));
			board.setBrdDate(doc.getDate("regdate"));
			
			return board;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//게시판 삭제
	@Override
	public int deletdBoardOne(long no) {
		try {
			Bson filter = Filters.eq("_id", no);
			DeleteResult result = this.boards.deleteOne(filter);
			System.out.println(result.toString());
			if(result.getDeletedCount()==1L) {
				return 1;
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	
	
}
