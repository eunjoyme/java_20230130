package day11;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RestTitanic {


	final String URL = "https://raw.githubusercontent.com/AISPUBLISHING/dsfs-python/master/titanic.json";
	private String data = null;
	
	public RestTitanic() {
		try {
			OkHttpClient client = new OkHttpClient();
			Request request = new Request.Builder().url(URL).get().build();
			Response response = client.newCall(request).execute();

			if(response.isSuccessful() == true) {
				this.data = response.body().string().toString();
				System.out.println("확인용 => "+ this.data);
			}	
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
			titanic.setPassengerId(0);
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
				String tmp = jobj.getString("survived");
			}
			if(!jobj.isNull("ticket")) {
				titanic.setTicket(jobj.getString("ticket"));
			}
			if(!jobj.isNull("passengerId")) {
				titanic.setPassengerId(jobj.getInt("passengerId"));
			}
			if(!jobj.isNull("sibsp")) {
				titanic.setSibsp(jobj.getInt("sibsp"));
			}
			
			list.add(titanic);
			
//			if( !jobj.isNull("survived")) {
//				String tmp = jobj.getString("survived");
//				if(tmp.equals("yes")) {
//					titanic.setSurvived("1");
//				}
//			}
//			else(tmp)
//			
//			titanic.setAge(0.0f);
//			
//			if(jobj.isNull("age")) {
//				System.out.println("나이정보 없음, 기본값 0으로 초기화");
//			}
//			else {
//				System.out.println(jobj.getFloat("age"));
//			}
//			
//			if(jobj.isNull("cabin")) {
//				System.out.println("객실번호 없음, 기본값 0으로 초기화");
//			}
//			else {
//				System.out.println(jobj.getString("cabin"));
//			}
//			
//			if(jobj.isNull("embarked")) {
//				System.out.println("탑승한 곳(항구) 정보없음, 기본값 0으로 초기화");
//			}
//			else {
//				System.out.println(jobj.getString("embarked"));
//			}
//			System.out.println("------------------------------");
		}
		return list; //임시로 null리턴 변경해야 함!!!
	}
		
	public void saveMongoDB() {
		
	}
}
