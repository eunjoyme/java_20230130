package day9;

import java.util.List;

//DB연동 설계
public interface ReplyDB {

	public short insertReply(Reply reply )throws Exception;
	public short updateReply(Reply reply )throws Exception;
	public short deleteReply(long no )throws Exception;
	public Reply selectReplyOne(long no );
	public List<Reply>selectReplyList(long boardNo);
	
	
}
