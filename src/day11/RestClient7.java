package day11;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mongodb.client.FindIterable;

import cls.Member;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RestClient7 {

	final String URL = "http://1.234.5.158:23000/json/exam7.json";
	private String data = null;
	
	public RestClient7() {
		try {
			OkHttpClient client = new OkHttpClient();
			Request request = new Request.Builder().url(URL).get().build();
			Response response = client.newCall(request).execute();

			if(response.isSuccessful() == true) {
				this.data = response.body().string().toString();
				System.out.println(this.data);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void parseData() {
		JSONObject jobj = new JSONObject(this.data);
		
		String ret = jobj.getString("ret");// 데이터의 성공유무
		String ret1 = new String("y");     // 실제 데이터
		
		JSONArray jary = jobj.getJSONArray("data"); // [{0}, {1}, {2}, {3}, {4} ]
		
		if(ret.equals(ret1)) {
			// {0} {1} {2} {3} {4}
			for(int i=0; i<jary.length(); i++) {
				JSONObject jobj1= jary.getJSONObject(i);
				
				System.out.println(jobj1.getString("id"));
				System.out.println(jobj1.getString("name"));
				System.out.println(jobj1.getInt("age"));
				System.out.println(jobj1.getFloat("height"));
				System.out.println(jobj1.getFloat("weight"));
				System.out.println("--------------------------");
			}
		}
	}

	public List<Member1> parseData1() {
		try {
			//1. 리턴할 빈 객체를 생성
			List<Member1>list = new ArrayList<Member1>();
			
			System.out.println(this.data);
			JSONObject jobj = new JSONObject(this.data);
			String ret = jobj.getString("ret");// y 데이터의 성공유무
			JSONArray jary = jobj.getJSONArray("data"); // [{0}, {1}, {2}, {3}, {4} ]
			
			for (int i=0; i<jary.length(); i++) {
				//JSONObject => Member1로 복사하기, jobj1 => m1로 복사
				JSONObject jobj1 = jary.getJSONObject(i);
				
				Member1 member1 = new Member1();
				member1.setId(jobj1.getString("id"));
				member1.setName(jobj1.getString("name"));
				member1.setAge(jobj1.getInt("age"));
				member1.setHeight(jobj1.getFloat("height"));
				member1.setWeight(jobj1.getFloat("weight"));
				
				list.add(member1);
			}
					return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
