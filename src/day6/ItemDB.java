package day6;

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

public class ItemDB {
	private MongoCollection<Document> collection = null;

	//db연결하고 컬렉션을 items로 
	public ItemDB() {
		final String url ="mongodb://id224:pw224@1.234.5.158:37017/db224";
		MongoClient client = MongoClients.create(url);
		MongoDatabase db = client.getDatabase("db224");
		this.collection = db.getCollection("items2");

		
	}
	
	//물품등록
	public int insertItem(Item item ) {
		try {
			Document doc = new Document();
			doc.append("_id",item.getCode());
			doc.append("name", item.getName());
			doc.append("content", item.getContent());
			doc.append("price", item.getPrice());
			doc.append("quantity", item.getQuantity());
			doc.append("regdate", item.getRegdate());
			
			InsertOneResult result=this.collection.insertOne(doc);
			System.out.println(result.toString() );
			return 1;
	}
		catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
}
	//전체 물품 출력
	public void printItems() {
		//MongoCollection<Document> => ArrayList<Document>
		//size를 알수 없음.            => size 알 수 있음
		MongoCursor<Document> list = this.collection.find().cursor();
		while(list.hasNext()) { // 꺼낼 것이 있나요?
			Document doc = list.next();  // 꺼내기 (전체 개수 1개 줄어들었음)
			System.out.println("물품코드 =>"+ doc.getLong("_id"));
			System.out.println("물품명 =>"+ doc.getString("name"));
			System.out.println("물품설명 =>"+ doc.getString("content"));
			System.out.println("물품가격 =>"+ doc.getInteger("price"));
			System.out.println("수량 =>"+ doc.getInteger("quantity"));
			System.out.println("등록일 =>"+ doc.getDate("regdate"));
			System.out.println("-----------------------------------");
		}
	}
	

	//삭제
	public int deleteItem(int code){
		try {
			Bson filter = Filters.eq("_id", code);
			DeleteResult result= this.collection.deleteOne(filter);
			System.out.println(result.toString() );
			if(result.getDeletedCount()==1L) {
				return 1;
			}
			return 0;
		}
		catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	//물품코드를 이용한 수정
	//물품명, 물품내용,가격, 수량 변경가능
	public int updateItem(Item item) {
			Bson filter = Filters.eq("_id", item.getCode());
			
			Bson a= Updates.set("name", item.getName());
			Bson b= Updates.set("content", item.getContent());
			Bson c= Updates.set("price", item.getPrice());
			Bson d= Updates.set("quantity", item.getQuantity());
			
			UpdateResult a1=this.collection.updateOne(filter, Updates.combine(a,b,c,d));
			if(a1.getModifiedCount()==1L) {
			return 1;
		}
		return 0;
	}
}
