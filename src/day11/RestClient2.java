package day11;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RestClient2 {

	final String URL = "http://1.234.5.158:23000/json/exam2.json";
	private String data = null;
	
	//데이터를 받아와서 문자열 변수에 보관
	public RestClient2() {
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
//		JSONArray == ArrayList
	    JSONArray jary = new JSONArray(this.data);
		for(int i=0; i<jary.length(); i++) { //2번 반복함.
			JSONObject jobj = jary.getJSONObject(i);
			String tmp1 = jobj.getString("ret");
			int tmp2 = jobj.getInt("data");
			
			//콘솔에 확인하기
			System.out.println(tmp1);
			System.out.println(tmp2);
			System.out.println("--------------------------");
		}
	}
	
}
