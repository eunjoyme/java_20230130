package day13;

import java.util.Scanner;

import org.json.JSONObject;

public class Main {

	public static void main(String[] args) {
		try {
			ChatClient chat = new ChatClient();  //서버접속
			chat.setSubscribe();  //구독설정
			
			Scanner scanner = new Scanner(System.in);
			while(true) {  //무한 반복
				System.out.println("보낼 메세지 입력 =>");
				String msg = scanner.nextLine();
				if(msg.equals("exit")) {
					break; //반복문 탈출
				}
				
				JSONObject jobj =new JSONObject();
				jobj.put("name", msg);
				jobj.put("content", "내용들...");
				jobj.put("price", 123);
				jobj.put("quantity", 2456);
				//{"name" : "입력내용", "type" : 1}
				
				//JSONObject => String => byte[] ~~~~~ byte[] => String =>
				chat.senedMessage("/pknu/class303/id224", jobj.toString());
				Thread.sleep(200); // 0.2초 기다림
			}
			scanner.close();
			System.exit(0);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
