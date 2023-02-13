package day11;

import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		
//		RestClient1 client = new RestClient1();
//		RestClient2 client = new RestClinet2();
//		RestClient7 client = new RestClient7();
		RestClient10 client = new RestClient10();
		
		client.parseData();
		
//		List<Member1>list = client.parseData1();
//		for(Member1 m : list) { //for (한개 꺼냈을때 타입 m : 리스트변수) {
//			System.out.println("id : "+ m.getId());
//			System.out.println("name : "+ m.getName());
//			System.out.println("age : "+ m.getAge());
//			System.out.println("height : "+ m.getHeight());
//			System.out.println("weight : "+ m.getWeight());
//			System.out.println("--------------------------------");
	
//		List<Score1>list = client.parseData1();
//		for(Score1 s1 : list) {
//			System.out.println("id : "+ s1.getId());
//			System.out.println("name : "+ s1.getName());
//			System.out.println("age : "+ s1.getAge());
//			System.out.println("math : "+ s1.getMath());
//			System.out.println("eng : "+ s1.getEng());
//			System.out.println("kor : "+ s1.getKor());
//			System.out.println("----------------------------------");
//	}
		//국어점수 합계 구하기
//		int n = client.sumKor();
//		System.out.println("국어점수 합계는? "+n);
		
		//영어점수 최대값 구하기
//		int a = client.maxEng();
//		System.out.println("영어점수 최대값은? "+a);
//		//영어점수 최소값 구하기
//		int a1 = client.minEng();
//		System.out.println("영어점수 최소값은? "+a1);
//		
//		//국어, 영어, 수학 합계 구하기
//		int[]b  = client.sumKorMathEng();
//		System.out.println("국어점수 합계는? "+b[0]);
//		System.out.println("영어점수 합계는? "+b[1]);
//		System.out.println("수학점수 합계는? "+b[2]);
//		
		//학생별 총점 구하기
		List<Map<String,Object>>list = client.sumStudent();
		
		//콘솔 디버그용, 실제화면불가능!!
		System.out.println(list.toString());
		
		for(Map<String, Object> map : list ) {
			System.out.println("아이디=> "+ map.get("id"));
			System.out.println("이름=> "+ map.get("name"));
			System.out.println("총점=> "+ map.get("total"));
			System.out.println("평균=> "+ map.get("avg"));
			System.out.println("--------------------------------");
		}
	}
}
		