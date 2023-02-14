package day12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import day11.Titanic;
import day8.Config;

public class TitanicDBImpl implements TitanicDB{

	private MongoCollection<Document> titanic = null;
	private MongoCollection<Document> replies = null;

	//titanic 컬렉션 접속하기
	public TitanicDBImpl() {
		try {
			this.titanic  = MongoClients.create(Config.URL)
					.getDatabase(Config.DBNAME)
					.getCollection(Config.TITANICCOL);
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//1) 전체 조회하기
	@Override
	public List<Titanic> selectTitanicList() {
		try {
			Bson sort = Filters.eq("fare", 1);
			
			//원본 타입
			FindIterable<Document>docs = this.titanic.find().sort(sort);
			//FindIterable<Dcoument> => List<Titanic>
			
			//반환 타입
			List<Titanic>list = new ArrayList<>();
			
			//원본 타입 반복
			for(Document doc : docs) {
				//반환타입으로 복사
				Titanic titanic = new Titanic();
				titanic.setName(doc.getString("name"));
				titanic.setFare(doc.getDouble("fare").floatValue());
				titanic.setEmbarked(doc.getString("embarked"));
				titanic.setAge(doc.getDouble("age").floatValue());
				titanic.setParch(doc.getInteger("parch"));
				titanic.setCabin(doc.getString("cabin"));
				titanic.setPclass(doc.getInteger("pclass"));
				titanic.setSex(doc.getString("sex"));
				titanic.setSurvived(doc.getString("survived"));
				titanic.setTicket(doc.getString("ticket"));
				titanic.setPassengerid(doc.getInteger("passengerid"));
				titanic.setSibsp(doc.getInteger("sibsp"));
				
				//반환타입에 추가
				list.add(titanic);
			}
				//반환하기
				return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
}

	//2)Map을 이용하여 출력하기
	@Override
	public List<Map<String, Object>> selecTitanicListMap() {
		try {
			//Map<String, Object> == Titanic 타입과 같은 기능
			FindIterable<Document>docs = this.titanic.find().sort(Filters.eq("fare", 1));
			List<Map<String, Object>>list = new ArrayList<>();
			for(Document doc : docs) {
				list.add(documentToMap(doc));
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
	//Document => Map으로 바꿔주는 메소드
	private Map<String, Object> documentToMap(Document doc) {
		Map<String, Object>map = new HashMap<String, Object>();
		map.put("_id", doc.get("_id"));
		map.put("embarked", doc.get("embarked"));
		map.put("age", doc.get("age"));
		map.put("parch", doc.get("parch"));
		map.put("cabin", doc.get("cabin"));
		map.put("pclass", doc.get("pclass"));
		map.put("sex", doc.get("sex"));
		map.put("survived", doc.get("survived"));
		map.put("ticket", doc.get("ticket"));
		map.put("passengerid", doc.get("passengerid"));
		map.put("sibsp", doc.get("sibsp"));
		map.put("fare", doc.get("fare"));
		map.put("name", doc.get("name"));
		return map;
	}

	//3) 나이순으로 정렬한 후 n명 조회
	@Override
	public List<Titanic> selectTitanicAge(int n) {
		try {
			//891개를 가져와서 881개를 버림.
			Bson sort = Filters.eq("age", -1);
			
			//원본 타입 10개만 가져옴.
			FindIterable<Document>docs = this.titanic.find().sort(sort).limit(n);

			//반환 타입
			List<Titanic>list = new ArrayList<Titanic>();
			
			//원본 타입 반복
			for(Document doc : docs) {
				//반환 타입으로 복사
				Titanic titanic = new Titanic();
				
				titanic.setName(doc.getString("name"));
				titanic.setFare(doc.getDouble("fare").floatValue());
				titanic.setEmbarked(doc.getString("embarked"));
				titanic.setAge(doc.getDouble("age").floatValue());
				titanic.setParch(doc.getInteger("parch"));
				titanic.setCabin(doc.getString("cabin"));
				titanic.setPclass(doc.getInteger("pclass"));
				titanic.setSex(doc.getString("sex"));
				titanic.setSurvived(doc.getString("survived"));
				titanic.setTicket(doc.getString("ticket"));
				titanic.setPassengerid(doc.getInteger("passengerid"));
				titanic.setSibsp(doc.getInteger("sibsp"));
				
				list.add(titanic);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
