package day14;

import java.util.Map;

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

public class MemberDBImpl implements MemberDB{

	MongoCollection<Document> members =null;
	
	public MemberDBImpl() {
		members = DBConn.getInstance()
				.getCollection(Config.MEMBERCOL);
	}
	
	//회원가입
	@Override
	public int memberJoin(Member member) {
		try {
			//Member => Document => insertOne()
			Document doc =new Document();
			
			doc.append("_id", member.getId());
			doc.append("password", member.getPassword());
			doc.append("name", member.getName());
			doc.append("phone", member.getPhone());
			doc.append("role", member.getRole());
			doc.append("age", member.getAge());
			doc.append("regdate", member.getRegdate());
			
			InsertOneResult result = this.members.insertOne(doc);
			System.out.println(result.toString());
			
			//result값에 따라 return 1 또는 0으로
			if(result.getInsertedId().asString()
					.getValue().equals(member.getId())) {
				return 1;
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	//로그인
	//1. 아이디를 이용해서 정보를 가져옴. 아이디와 암호가 일치하는 확인후에 반환
	//2. 아이디, 암호를 and필터를 이용해서 조회
	@Override
	public Member memberLogin(Map<String, Object> map) {
		try {
			Bson filter = Filters.eq("_id", map.get("_id"));
			Document doc = this.members.find(filter).first();
			Member member = new Member();
			member.setId(doc.getString("_id"));
			member.setPassword(doc.getString("password"));
			member.setName(doc.getString("name"));
			member.setPhone(doc.getString("phone"));
			member.setRole(doc.getString("role"));
			member.setAge(doc.getInteger("age"));
			member.setRegdate(doc.getDate("regdate"));
			
			return member;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
//	로그인 2번째 방법
//	public Member memberLogin(Map<String, Object> map) {
//		try {
//			String id = (String)map.get("_id");
//			String pw = (String)map.get("password");
//			
//			Bson filter = Filters.eq("_id", id);
//			Document doc = this.members.find(filter).first();
//			
//			if(doc.getString("_id").equals(id)
//				&& doc.getString("password").equals(pw)){
//				Member member = new Member();
//				member.setId(doc.getString("_id"));
//				member.setPassword(doc.getString("password"));
//				member.setName(doc.getString("name"));
//				member.setPhone(doc.getString("phone"));
//				member.setRole(doc.getString("role"));
//				member.setAge(doc.getInteger("age"));
//
//				return member;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}

	//회원정보조회
	@Override
	public Member memberselectOne(String id) {
		try {
			Bson filter = Filters.eq("_id", id);
			Document doc = this.members.find(filter).first();
			System.out.println(doc.toString());

			Member member = new Member();
			member.setId(doc.getString("_id"));
			member.setPassword(doc.getString("password"));
			member.setName(doc.getString("name"));
			member.setPhone(doc.getString("phone"));
			member.setRole(doc.getString("role"));
			member.setAge(doc.getInteger("age"));
			member.setRegdate(doc.getDate("regdate"));
			
			return member;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//회원정보변경
	@Override
	public int memberUpdateOne(Member member) {
		try {
			Bson filter =Filters.eq("_id", member.getId());
			
			Bson update1 =Updates.set("name", member.getName());
			Bson update2 =Updates.set("phone", member.getPhone());
			Bson update3 =Updates.set("age", member.getAge());
			
			Bson update = Updates.combine(update3, update1, update2);
			UpdateResult result = this.members.updateOne(filter, update);
			System.out.println(result.toString());
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	//비밀번호 변경
	@Override
	public int memberUpdatePWOne(Map<String, Object> map) {
		try {
			String id = (String)map.get("_id"); //현재 아이디
			//String pw = (String)map.get("password"); //현재 비번
			String pw1 = (String)map.get("password1"); //바꿀 비번

			//Filters.and( )
			Member member = this.memberLogin(map);
			if(member!=null) { //로그인 성공
				Bson filter = Filters.eq("_id", id);
				Bson update = Updates.set("password", pw1);
				UpdateResult ret = this.members.updateOne(filter, update);
				
				if(ret.getModifiedCount() == 1L) {
					return 1;
				}
			}
			return 0;
		}
		catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	//회원탈퇴
	@Override
	public int memberDeletOne(String id) {
		try {
			Bson filter = Filters.eq("_id", id);
			DeleteResult result = this.members.deleteOne(filter);
			System.out.println(result.toString() );
			if(result.getDeletedCount()==1L) {
				return 1; //일치하는게 있어서 1개를 지움
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	
	
}
