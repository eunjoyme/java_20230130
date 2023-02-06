package day6;

import java.nio.file.DirectoryStream.Filter;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;

//기능용 클래스
// 몽고 DB연동

public class MemberDB {
	
	private MongoCollection<Document> collection = null;

	// 변수X
	
	//생성자
	public MemberDB() {
		//공통변수가 아니기 때문에 생성자 내부에서만 사용가능한 변수 생성
		//final을 붙이면 생성시 값으로 프로그램이 끝날때 까지 유지됨. 이유는 바꿀수 없기 때문
		//mongodb://아이디:암호@서버주소:포트번호/디비명
		final String url ="mongodb://id224:pw224@1.234.5.158:37017/db224";
		
		//static 클래스를 통해서 접속이 가능함.
		MongoClient client = MongoClients.create(url);
		MongoDatabase db = client.getDatabase("db224");
		this.collection = db.getCollection("members");
	}
	
	//회원탈퇴 및 삭제
	public int deletMember(String id) {
		try {
			Bson filter = Filters.eq("_id", id);
			DeleteResult result = this.collection.deleteOne(filter);
			System.out.println(result.toString() );
			if(result.getDeletedCount()==1L) {
				return 1; //일치하는게 있어서 1개를 지움
			}
			return 0; //일치하는게 없어서 못지움
		}
		catch(Exception e ) {
			e.printStackTrace();
			return -1;
		}
	}
	
	// 회원정보 수정
	public int updateMember(Member member) {
		try {
			//변경하고자 하는 항목의 조건
			Bson filter = Filters.eq("_id", member.getId() );
			
			//변경할 항목들 이름, 연락처, 나이
			Bson update1 = Updates.set("name", member.getName() );
			Bson update2 = Updates.set("phone", member.getPhone() );
			Bson update3 = Updates.set("age", member.getAge() );
			
			// updateOne(조건,변경값) => 변경값이 하나의 Bson만 가능.. combine
			Bson update = Updates.combine(update1 , update2 , update3 );
			
			UpdateResult result = this.collection.updateOne(filter, update);
			System.out.println(result.toString() );
			return 1;
		}
		catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	//문제1) 고객, 판매자만 조회하는 필터
	public void printMembersRole(String role) {
		Bson filter = Filters.eq("role", role);
		printAction(filter);
	}
	
	//문제2) 나이가 n이상인 것만 필터
	//크거나 같다 gte
	//크다      gt
	//작거나 같다 lte
	//작다      lt
	//같다      eq
	public void printMembersAge(int n) {
		Bson filter = Filters.gte("age", n);
		printAction(filter);
	}
	
	//문제3) 이름이 "가나다"인만 조회
	public void printMembersName(String searchName) {
		//키(필드)가 name인것중에서 searchName과 정확하게 일치하는 필터
		Bson filter = Filters.eq("name", searchName);
		printAction(filter);
		}
	
	private void printAction(Bson filter) {
		MongoCursor<Document>list = this.collection.find(filter).iterator();
		while(list.hasNext()) {
			Document doc = list.next();
			System.out.println("아이디 => " + doc.getString("_id") );
			System.out.println("암호 => " + doc.getString("password"));
			System.out.println("나이 =>" + doc.getInteger("age"));
			System.out.println("전화번호 => " + doc.getString("phone"));
			System.out.println("권한 => "+ doc.getString("role"));
			System.out.println("-----------------------------------");
		}
	}
	
	//전체 회원 조회 메소드
	public void printMembers() {
		MongoCursor<Document> list = this.collection.find().cursor();
		//1000 => 500개만 출력 (x)
		//반복자 (처음부터 끝까지 전체다 반복할 거라고 가정
		
		//가져올 데이터가 있나요?
		while(list.hasNext()) {
			// 그러면 1개 가져갈께요.
			Document doc = list.next();
			System.out.println("아이디 => " + doc.getString("_id") );
			System.out.println("암호 => " + doc.getString("password"));
			System.out.println("나이 =>" + doc.getInteger("age"));
			System.out.println("전화번호 => " + doc.getString("phone"));
			System.out.println("권한 => "+ doc.getString("role"));
			System.out.println("-----------------------------------");
		}
	}
	
	//회원가입 메소드
	public int insertMember( Member member ) {
		try {
			//정상동작
			Document doc = new Document();
			//키가 반드시 _id기본키로 봄.
			doc.append("_id", member.getId() );
			doc.append("password", member.getPassword() );
			doc.append("name", member.getName() );
			doc.append("phone", member.getPhone() );
			doc.append("role", member.getRole() );
			doc.append("age", member.getAge() );
			doc.append("regdate", member.getRegdate() );
			
			InsertOneResult result= this.collection.insertOne(doc);
			System.out.println(result.toString() );
			return 1;
		}
		catch(Exception e) {
			//정상동작중에서 오류가 발생시 이쪽으로 수행됨.
			//Exception클래스의 e변수에 오류의 정보(오류 메세지)가 전송되게 됨.
			e.printStackTrace(); //오류메세지 전체적으로 출력해줌. 개발자를 위한 기능
			return -1;
		}
	}
}
