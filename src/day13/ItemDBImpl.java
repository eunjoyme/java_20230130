package day13;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;

import day8.Config;

public class ItemDBImpl implements ItemDB{

	private MongoCollection<Document> sequence = null;
	private MongoCollection<Document> items = null;
	
	public ItemDBImpl() {
		try {
			this.sequence = MongoClients.create(Config.URL)
					.getDatabase(Config.DBNAME).getCollection(Config.RESEQUENCECOL);
			this.items = MongoClients.create(Config.URL)
					.getDatabase(Config.DBNAME).getCollection(Config.ITEMCOL);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	//전체 조회(정렬기준 물품번호를 내림차순으로)
	@Override
	public List<Map<String, Object>> selectItemListMap(int n) {
		try {
			Bson sort = Filters.eq("_id", -1);
			FindIterable<Document> docs
			 = this.items.find().sort(sort).limit(n);
			
			List<Map<String, Object>>list = new ArrayList<>();
			for(Document doc : docs) {
				Map<String, Object>map = new HashMap<>();
				map.put("_id", doc.getLong("_id"));
				map.put("name", doc.getString("name"));
				map.put("cotent", doc.getString("content"));
				map.put("price", doc.getInteger("price"));
				map.put("quantity", doc.getInteger("quantity"));
				map.put("regdate", doc.getDate("regdate"));
				//doc를 map으로 변환하기
				list.add(map);
			}
			return list;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int insertItemMap(Map<String, Object> map) {
		try {
			Bson filter = Filters.eq("_id", "SEQ_ITEM_CODE");
			Bson update = Updates.inc("idx", 1);
			Document doc = this.sequence.findOneAndUpdate(filter, update);
			long itemCode = doc.getLong("idx");
			
			Document saveDoc = new Document();
			saveDoc.append("_id", itemCode);  //시퀀스에서 꺼낸값
			saveDoc.append("name", map.get("name"));
			saveDoc.append("content", map.get("content"));
			saveDoc.append("price", map.get("price"));
			saveDoc.append("quantity", map.get("quantity"));
			saveDoc.append("regdate", new Date()); //현재 시간
			
			InsertOneResult result = this.items.insertOne(saveDoc);
			if(result.getInsertedId().asInt64().getValue()==itemCode) {
				return 1;
			}
			return 0;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	//물품 1개 삭제
	@Override
	public int deleteItemOne(long no) {
		try {
			Bson filter= Filters.eq("_id", no);
			DeleteResult result = this.items.deleteOne(filter);
			System.out.println(result.toString());
			if(result.getDeletedCount() == 1L) {
				return 1;
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	//물품 n개 삭제
	@Override
	public int deleteItemMany(long[] no) {
		try {
			int cnt =0;
			//long[] no = {1,2,5,6};
			//조건 1개에 n개를 지움
			//조건 n개에 n개를 지움
			for(int i=0; i<no.length; i++ ) {
				Bson filter = Filters.eq("_id", no[i]);
				DeleteResult result = this.items.deleteOne(filter);
				cnt += result.getDeletedCount(); // cnt에 삭제시 1개씩 더하기
			}
			//삭제한 개수 == 배열의 개수
			if(cnt == no.length) {
				return 1;
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	//물품 수정하기
	@Override
	public int updateItemOne(Item item) {
		try {
			Bson filter= Filters.eq("_id", item.getNo());
			
			Bson update1 = Updates.set("name", item.getName());
			Bson update2 = Updates.set("content", item.getContent());
			Bson update3 = Updates.set("price", item.getPrice());
			Bson update4 = Updates.set("quantity", item.getQuantity());
			
			Bson update = Updates.combine(update1, update2, update3, update4);
			
			UpdateResult result = this.items.updateOne(filter, update);
			
			System.out.println(result.toString());
			if(result.getModifiedCount() == 1L) {
				return 1;
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	//List
	@Override
	public List<Item> selectItemList(int n) {
		try {
			List<Item>list = new ArrayList<Item>();
			FindIterable<Document>docs = this.items.find().limit(n);
			
			for(Document doc : docs) {
				Item item = new Item();
				item.setNo(doc.getLong("_id"));
				item.setName(doc.getString("name"));
				item.setContent(doc.getString("content"));
				item.setPrice(doc.getInteger("price"));
				item.setQuantity(doc.getInteger("quantity"));
				item.setRegdate(doc.getDate("regdate"));
				
				list.add(item);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
	//문제1) 가격대별 수량 구하기
	@Override
	public List<Item> selectItemListPrice(int n) {
		try {
			Bson sort = Filters.eq("price", -1);
			
			FindIterable<Document>docs = this.items.find().sort(sort).limit(n);
			List<Item>list = new ArrayList<Item>();
			
			int cnt[] = new int[4];
			for(Item i : list) {
				if(i.getPrice()>0 && i.getPrice()<=999) {
					cnt[0]++;
				}
				else if(i.getPrice()<=9999) {
					cnt[1]++;
				}
				else if(i.getPrice()<=99999) {
					cnt[2]++;
				}
				else if(i.getPrice()>=100000) {
					cnt[3]++;
				}
			}
			System.out.println("백원대 수량=> " + cnt[0]);
			System.out.println("천원대 수량=> " + cnt[1]);
			System.out.println("만원대 수량=> " + cnt[2]);
			System.out.println("십만원대 수량=> " + cnt[3]);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	//문제2) 시간대별 재고수량 합계(Date to String 으로 변환)
	@Override
	public List<Item> selectItemListDate() {
		try {
			
			List<Item>list = new ArrayList<Item>();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	//문제3) 재고수량이 1000이상인것만 3자리 콤마 추가 후 출력(int to String 으로 변환)
	@Override
	public List<Item> selectItemListQuantity(int quantity) {
		try {
			
			List<Item>list = new ArrayList<Item>();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

}
