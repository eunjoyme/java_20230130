package day13;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONObject;

import day8.Config;

public class ChatClient implements MqttCallback{
	
	private MqttClient client = null;
	private ItemDB iDB = new ItemDBImpl(); // items 컬렉션 연동 객체 생성
	
	public ChatClient() {
		try {
			String clientid = "id224_" + System.currentTimeMillis();
			this.client = new MqttClient(Config.BROKER, clientid );
		
			MqttConnectOptions options = new MqttConnectOptions();
			options.setUserName(Config.CONNECTID);
			options.setPassword(Config.CONNECTPW.toCharArray());
			options.setCleanSession(true);
			options.setKeepAliveInterval(30);
			
			this.client.connect(options);
			this.client.setCallback(this);
			System.out.println("접속성공 => " + client);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("접속실패");
		}
		
	}

	//구독설정 ex) /pknu/class303으로 오는 모든 메세지는 다 받음
	public boolean setSubscribe() {
		try {
			client.subscribe("/pknu/class303/id224");
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	//메세지 보내기(보낼 토픽, 메세지)
	public boolean senedMessage(String topic, String msg) {
		try {
			MqttMessage message = new MqttMessage(msg.getBytes());
			//message.setPayload(msg.getBytes());
			client.publish(topic, message);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void connectionLost(Throwable cause) {
		System.out.println("connectionLost");
	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		try {
			
		//MqttMessage타입을 String 타입으로 변환
		//byte[] => String => JSONObject
		byte[] tmp = message.getPayload();
		String str = new String( tmp );
		
		//{"name" : "물품명", "content" : "물품내용", "price" : 1234, "quantity" : 1234};
		JSONObject jobj = new JSONObject(str);
		String name = jobj.getString("name");
		String content = jobj.getString("content");
		int price = jobj.getInt("price");
		int quantity = jobj.getInt("quantity");
		
		//map 에 데이터 담기
		Map<String, Object>map = new HashMap<>();
		map.put("name", name);
		map.put("content", content);
		map.put("price", price);
		map.put("quantity", quantity);
		
		//데이터 베이스에 추가하기
		int ret = iDB.insertItemMap(map);
		System.out.println("DB추가 유무 => "+ ret);
		
		//데이터 베이스에서 조회(5)
		List<Map<String, Object>> list = iDB.selectItemListMap(5);
		for(Map<String, Object>map1 : list) {
			System.out.println(map1.get("_id"));
			System.out.println(map1.get("name"));
			System.out.println("-----------------------------------");
		}
		
		//System.out.println("토픽 => " + topic + "메세지 => "+ str );
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
		System.out.println("deliveryComplete");
	}
	
}
