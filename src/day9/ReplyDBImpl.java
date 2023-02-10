package day9;

import java.util.List;
import java.util.Vector;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;

import day8.Config;


public class ReplyDBImpl implements ReplyDB{

	private MongoCollection<Document>sequence = null;
	private MongoCollection<Document>replies = null;
	
	//DB접속 및 컬렉션 선택...
	public ReplyDBImpl() {
		try {
			MongoClient client = MongoClients.create(Config.URL);
			MongoDatabase db = client.getDatabase(Config.DBNAME);
			sequence = db.getCollection(Config.RESEQUENCECOL);
			replies = db.getCollection(Config.REPLYCOL);
		}
		catch (Exception e) {
			e.printStackTrace(); // 오류발생시 콘솔창에 표시됨.
		}
	}

	
	@Override
	public short insertReply(Reply reply) throws Exception {
		 Document doc = this.sequence.findOneAndUpdate(
				Filters.eq("_id", "SEQ_REPLY_NO"), 
				Updates.inc("idx", 2) );
		 //Document{{_id=SEA_REPLY_NO, idx= 201}} 
		System.out.println(doc.toString() );
		long idx = doc.getInteger("idx");
		
		Document doc1 = new Document();
		doc1.append("_id", idx);
		doc1.append("content", reply.getContent() );
		doc1.append("writer", reply.getWriter());
		doc1.append("regdate", reply.getRegdate());
		//전체적인 데이터를 추가하는 것이 아니라 기본키정보(게시글번호)만 DB에 추가함. 
		doc1.append("board", reply.getBoard().getBrdNo());
		
		//데이터베이스에 데이터가 정확하게 추가되면 반환값으로 답글번호를 반환
		InsertOneResult result = this.replies.insertOne(doc1);
		
		System.out.println(result.toString());
		if(result.getInsertedId().asInt64().getValue()== idx) {
			return 1;
		}
		return 0;
	}

	//수정하기
	@Override
	public short updateReply(Reply reply) throws Exception {
		try {
			Bson filter = Filters.eq("_id", reply.getNo() );
			
			Bson update1 = Updates.set("content", reply.getContent() );
			Bson update2 = Updates.set("writer", reply.getWriter() );
			
			UpdateResult result = this.replies.updateOne(filter, Updates.combine(update1, update2) );
			System.out.println(result.toString() );
			if(result.getModifiedCount() == 1L) {
				return 1;
			}
			return 0;
		}catch (Exception e) {
			return -1;
		}
	}

	//답글번호로 삭제하기(1개씩 지우기)
	@Override
	public short deleteReply(long no) throws Exception {
		try {
			Bson filter = Filters.eq("_id", no);
			DeleteResult result = this.replies.deleteOne(filter);
			System.out.println(result.toString() );
			if(result.getDeletedCount()== 1) {
				return 1;
			}
			return 0;
		}catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	//no는 원본게시글 번호가 아님, 답글번호
	@Override
	public Reply selectReplyOne(long replyNo) {
		try {
			//doc값이 null경우는 해당하는 답글이 없음.
			//doc값이 null아니면 해당하는 답글이 존재한다.
			Document doc = this.replies.find(Filters.eq("_id", replyNo)).first();
			if(doc != null) {  //Document -> Reply 타입으로 복사한 후 리턴
				Reply reply = new Reply();
				reply.setNo(doc.getLong("_id") );
				reply.setContent(doc.getString("content"));
				reply.setWriter(doc.getString("writer"));
				reply.setRegdate(doc.getDate("regdate"));
				
				Board board = new Board();
				board.setBrdNo(doc.getLong("board"));
				
				reply.setBoard(board);
				
				return reply;
			}
			return null;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	//문제) 원본게시글 번호를 전달하면 해당하는 모든 답글을 반환하기
	@Override
	public List<Reply> selectReplyList(long boardNo) {
		try { 
			Bson filter = Filters.eq("board", boardNo); //필터조건
			Bson sort   = Filters.eq("_id", -1);        //정렬조건
			FindIterable<Document>docs = this.replies.find(filter).sort(sort);
			//FindIterable<Document> => List<Reply>
			
			//인터페이스<> 객체명 = new 컬렉션클래스();
			List<Reply> list = new Vector<Reply>();
			for(Document doc : docs ) {
				Reply reply = new Reply();
				
				reply.setNo(doc.getLong("_id") );
				reply.setContent(doc.getString("content"));
				reply.setWriter(doc.getString("writer"));
				reply.setRegdate(doc.getDate("regdate"));
				reply.setBoard(null);

				list.add(reply);
		}
			if( !list.isEmpty() ) {
				return list;
			}
			return null;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
			
			
			
		}
	}
}
