package day11;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONObject;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertManyResult;

import day8.Config;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RestTitanic {


	final String URL = "https://raw.githubusercontent.com/AISPUBLISHING/dsfs-python/master/titanic.json";
	private String data = null;
	private MongoCollection<Document>titanicCollection = null;
	
	public RestTitanic() {
		try {
			//rest 데이터 가져오기
			OkHttpClient client = new OkHttpClient();
			Request request = new Request.Builder().url(URL).get().build();
			Response response = client.newCall(request).execute();

			if(response.isSuccessful() == true) {
				this.data = response.body().string().toString();
				System.out.println("확인용 => "+ this.data);
			}	
			
			//데이터베이스 접속하기
			MongoClient dbClient = MongoClients.create(Config.URL);
			this.titanicCollection = dbClient.getDatabase(Config.DBNAME).getCollection(Config.TITANICCOL);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Titanic> parseData(){
		List<Titanic> list = new ArrayList<>();
		//[ {},{},{},{}....{} ]
		JSONArray jary = new JSONArray(this.data);
		for(int i=0; i<jary.length(); i++) {
			Titanic titanic = new Titanic();
			JSONObject jobj = jary.getJSONObject(i).getJSONObject("fields");
			
			titanic.setFare(jobj.getFloat("fare"));
			titanic.setName(jobj.getString("name"));
			
			// 데이터가 없을 경우 초기값 세팅
			titanic.setAge(0.0f);
			titanic.setCabin("_");
			titanic.setParch(0);
			titanic.setPclass(0);
			titanic.setSex("_");
			titanic.setSurvived("_");
			titanic.setEmbarked("_");
			titanic.setTicket("_");
			titanic.setPassengerid(0);
			titanic.setSibsp(0);
			
			//데이터가 있으면 데이터 변경.
			if(!jobj.isNull("embarked")) {
				titanic.setEmbarked(jobj.getString("embarked"));
			}
			if(!jobj.isNull("age")) {
				titanic.setAge(jobj.getFloat("age"));
			}
			if(!jobj.isNull("parch")) {
				titanic.setParch(jobj.getInt("parch"));
			}
			if(!jobj.isNull("cabin")) {
				titanic.setCabin(jobj.getString("cabin"));
			}
			if(!jobj.isNull("pclass")) {
				titanic.setPclass(jobj.getInt("pclass"));
			}
			if(!jobj.isNull("sex")) {
				titanic.setSex(jobj.getString("sex"));
			}
			if(!jobj.isNull("survived")) {
				titanic.setSurvived(jobj.getString("survived"));
			}
			if(!jobj.isNull("ticket")) {
				titanic.setTicket(jobj.getString("ticket"));
			}
			if(!jobj.isNull("passengerid")) {
				titanic.setPassengerid(jobj.getInt("passengerid"));
			}
			if(!jobj.isNull("sibsp")) {
				titanic.setSibsp(jobj.getInt("sibsp"));
			}
			
			list.add(titanic);
			
		}
		return list; //임시로 null리턴 변경해야 함!!!
	}
		
	public void saveMongoDB() {
		List<Titanic>list = this.parseData();
		
		//List<Titanic> => List<Document>
		List<Document> saveList = new ArrayList<Document>();
		for(Titanic tmp : list) {
			Document doc = new Document();
			doc.append("embarked", tmp.getEmbarked());
			doc.append("age", tmp.getAge());
			doc.append("parch", tmp.getParch());
			doc.append("cabin", tmp.getCabin());
			doc.append("pclass", tmp.getPclass());
			doc.append("sex", tmp.getSex());
			doc.append("survived", tmp.getSurvived());
			doc.append("ticket", tmp.getTicket());
			doc.append("passengerid", tmp.getPassengerid());
			doc.append("sibsp", tmp.getSibsp());
			doc.append("fare", tmp.getFare());
			doc.append("name", tmp.getName());
			doc.append("regdate", new Date());
			
			saveList.add(doc);
		}
		
		InsertManyResult result = this.titanicCollection.insertMany(saveList);
		System.out.println(result);
	}
}
