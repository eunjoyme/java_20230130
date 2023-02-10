package day10;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.InsertOneResult;

import day8.Config;

public class AddressDBImpl implements AddressDB{

	private MongoCollection<Document> addresses = null;
	private MongoCollection<Document> sequence = null;
	private MongoCollection<Document> members = null;
	
	public AddressDBImpl() {
		this.addresses = MongoClients.create(Config.URL)
				.getDatabase(Config.DBNAME).getCollection(Config.ADDRESSCOL);
		this.sequence = MongoClients.create(Config.URL)
				.getDatabase(Config.DBNAME).getCollection(Config.RESEQUENCECOL);
		this.members = MongoClients.create(Config.URL)
				.getDatabase(Config.DBNAME).getCollection(Config.MEMBERCOL);
	}

	@Override
	public int insertAddress(Address address) {
		try {
			//시퀀스를 이용하여 숫자 가져오기
			Document doc = this.sequence.findOneAndUpdate(
					Filters.eq("_id", "SEQ_ADDRESS_CODE"), Updates.inc("idx", 1));
			long code = (long)doc.get("idx");
			
			Document saveDoc = new Document()
			.append("_id", code)
			.append("address", address.getAddress())
			.append("postcode", address.getPostcode())
			.append("regdate", address.getRegdate())
			.append("memberid", address.getMemberid().getId());
			//*****회원정보 전체 추가하지 않음, 기본키인 아이디만 추가함.!!
			
			InsertOneResult result = this.addresses.insertOne(saveDoc);
			if(result.getInsertedId().asInt64().getValue() == code) {
				return 1;
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int insertAddressMap(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	//주소코드가 오면 주소정보를 전달하는 + 회원정보도 같이...
	@Override
	public Address selectAddressOne(long code) {
		try {
			Bson filter =Filters.eq("_id", code);
			Document doc = this.addresses.find(filter).first();
			
			//Document -> Address로 변환 메소드
			Address address = documentToAddress(doc);
			
			//member의 컬렉션에서 해당 아이디 가져와야 됨.
			Bson filter1 = Filters.eq("_id", doc.getString("memberid"));
			Document docMember = this.members.find(filter1).first();
			
			//Document -> Member로 바꾼후 넣기
			Member member = new Member();
			member.setId(docMember.getString("_id"));
			member.setPassword(docMember.getString("password"));
			member.setName(docMember.getString("name"));
			member.setPhone(docMember.getString("phone"));
			member.setRole(docMember.getString("role"));
			member.setAge(docMember.getInteger("age"));
			member.setRegdate(docMember.getDate("regdate"));
			address.setMemberid(member);
			return address;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	//1개 멤버
	@Override
	public List<Address> selectAddressList(Member member) {
		try {
		FindIterable<Document>docs = this.addresses.find(Filters.eq("memberid", member.getId()) );
		List<Address>list =new ArrayList<>();
		for(Document doc : docs) {
			list.add(documentToAddress(doc));
		}
		if(!list.isEmpty()) {
			return list;
		}
		return null;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}
}
	//Document -> Address 로 변경하느 메소드
	private Address documentToAddress(Document doc) {
		Address address = new Address();
		address.setCode(doc.getLong("_id"));
		address.setAddress(doc.getString("address"));
		address.setPostcode(doc.getString("postcode"));
		address.setRegdate(doc.getDate("regdate"));
		return address;
	}
	
	@Override
	public List<Map<String, Object>> selectAddressListMap(Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> selectAddressMapOne(long code) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
