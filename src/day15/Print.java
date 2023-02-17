package day15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//메인에서 실행시키며 결과 출력하는 클래스
public class Print {
	
	//3권 정도 임의의 값으로 추가한후 실행하기
	public void printBook(List<Book>book) {
		for(Book one : book) {
			System.out.println(one.getCode());
			System.out.println(one.getTitle());
			System.out.println(one.getAuthor());
			System.out.println(one.getPrice());
			System.out.println(one.getRegdate());
		}
	}
	
	//전체 책과 필터하는 가격 조건 전달 받으면 가격보다 큰 책만 반환
	public List<Book> queryPrice(List<Book>book, long price){
		List<Book>list = new ArrayList<>();
		for(Book one : book) {
			if(price < one.getPrice()) {
				list.add(one);
			}
		}
		return list;
	}
	
	
	//가격에서 일의 자리가 0인것만 조회
	//ex) 12233 => X
	//ex) 12300 => O
	public List<Map<String , Object>> queryPrice(List<Book> book){
		List<Map<String , Object>>list = new ArrayList<>();
		for(Book one : book) {
			if(one.getPrice()%10 == 0) {
				Map<String, Object> map = new HashMap();
				map.put("code", one.getCode());
				map.put("title", one.getTitle());
				list.add(map);
			}
		}
		return list;
	}
	
	
	//n이 오면 n단을 출력하는 메소드 구현
	// ex) 3
	//3*1=3
	//~
	//3*9=27
	//문제1) 구구단
	public void gugudan(int n) {
		System.out.println("구구단 중 출력할 단은? " + n);
		for(int i = 1; i<10; i++) {
			System.out.println(n+"단 : "+n+" X "+i+" = "+(n*i));
			}
		}
		
	//문제2) n개의 정수형이 오면 합을 구해서 반환하는 메소드 구현
	public long sum(List<Long>list) {
		long sum=0;
		for(Long n : list ) {
			sum+=n;
		}
		return sum;
	}

	//문제3) n개의 실수형이 전달되면 합과 평균을 구해서 반환하는 메소드 구현
	public Map<String, Object>sumAvg(List<Double>list){
		double sum = 0.0d;
		double avg = 0.0d;
		Map<String, Object> map = new HashMap<>();
		for(Double n : list) {
			sum += n;
		}
		avg = sum/(double)list.size();
		map.put("sum111", sum);
		map.put("avg222", avg);
		return map;
	}

}
