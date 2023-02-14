package day12;

import java.util.List;
import java.util.Map;

import day11.Titanic;

public class Main {

	public static void main(String[] args) {
		//객체 생성
		TitanicDB tDB = new TitanicDBImpl();
		Print print = new Print();
		print.printAgeSurvived(tDB.selectTitanicList() );
		
		
		
		
		//1)전체 출력하기
//		RestTitanic obj = new RestTitanic();
//		obj.saveMongoDB();
//		
//		try {
//			TitanicDB titanicDB = new TitanicDBImpl();
//			List<Titanic>list = titanicDB.selectTitanicList();
//			for(Titanic titanic : list) {
//				System.out.println("이름=> "+ titanic.getName());
//				System.out.println("티켓요금=> "+ titanic.getFare());
//				System.out.println("탑승한 곳=> "+ titanic.getEmbarked());
//				System.out.println("나이=> "+ titanic.getAge());
//				System.out.println("탑승한 부모/자녀수 => "+ titanic.getParch());
//				System.out.println("탑승한 형제/자매 수=> "+ titanic.getSibsp());
//				System.out.println("객실 번호=> "+ titanic.getCabin());
//				System.out.println("티켓 등급=> "+ titanic.getPclass());
//				System.out.println("성별=> "+ titanic.getSex());
//				System.out.println("생존여부=> "+ titanic.getSurvived());
//				System.out.println("티켓번호=> "+ titanic.getTicket());
//				System.out.println("승객번호=> "+ titanic.getPassengerid());
//				System.out.println("-------------------------------------");
//			} 
//				}catch (Exception e) {
//				e.printStackTrace();
//	}
		
		//2)Map을 이용하여 출력하기
//		TitanicDBImpl tDB = new TitanicDBImpl();
//		List<Titanic>list = tDB.selectTitanicList();
//		for(Titanic t : list) {
//			System.out.println(t.getName());
//			System.out.println(t.getCabin());
//			System.out.println(t.getEmbarked());
//			System.out.println(t.getParch());
//			System.out.println(t.getPassengerid());
//			System.out.println(t.getPclass());
//			System.out.println(t.getSex());
//			System.out.println(t.getSibsp());
//			System.out.println(t.getSurvived());
//			System.out.println(t.getTicket());
//			System.out.println(t.getAge());
//			System.out.println(t.getFare());
//		}
//		List<Map<String, Object>> list1 = tDB.selecTitanicListMap();
//		for(Map<String, Object> map: list1 ) {
//			System.out.println(map.get("name"));
//			System.out.println(map.get("cabin"));
//			System.out.println(map.get("embarked"));
//			System.out.println(map.get("parch"));
//			System.out.println(map.get("passengerid"));
//			System.out.println(map.get("pclass"));
//			System.out.println(map.get("sex"));
//			System.out.println(map.get("sibsp"));
//			System.out.println(map.get("survived"));
//			System.out.println(map.get("ticket"));
//			System.out.println(map.get("age"));
//			System.out.println(map.get("fare"));
//			System.out.println("----------------------------------------------");
//		}
		
		
		//3)나이순으로 정렬한 후 n명 조회
		    //객체 생성
//			TitanicDBImpl obj = new TitanicDBImpl();
//			
//			//메소드 호출 및 결과 받기
//			List<Titanic>list = obj.selectTitanicAge(7);
//			
//			//리스트 타입은 반복문 출력
//			for(Titanic one : list) {
//				System.out.println(one.getAge()+", "+
//			one.getName()+", "+one.getEmbarked()+", "+ 
//			one.getParch()+", "+ one.getPassengerid()+", "+
//			one.getPclass()+", "+one.getSex()+", "+ 
//			one.getSibsp()+", "+one.getSurvived()+", "+ 
//			one.getTicket()+", "+one.getTicket()+", "+
//			one.getCabin()+", "+one.getFare());
//			}
		
		
		
	}
}
