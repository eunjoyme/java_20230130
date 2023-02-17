package day15;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.model.Filters;

import lombok.Data;

//타입
@Data
public class BookStore {
	private String phone;
	private String address;
	private List<Book>list = new ArrayList<>();
	
	//책 추가
	public int addBook(Book book) {
		try {
			list.add(book);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	//책 삭제
	public int removeBook(Book book) {
		try {
			list.remove(book);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	//첵제목이 포함된 것 검색
	public List<Book>searchBook(String title){
		try {
			//전체 데이터를 반복
			List<Book>list1 = new ArrayList<>();
			for(Book one : list) {
				if(one.getTitle().equals(title)) {//전체 데이터에서 필요한 필터
					//필요한 것만 출력, 반환해야 될 수도 있음
					list1.add(one);
				}
			}
			return list1; // 반환
		} 
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	//가격보다 큰것만 검색
	public List<Book>searchBookPrice(long price){
		try {
			List<Book>list1 = new ArrayList<>();
			for(int i=0; i<list.size(); i++) {
				Book b = list.get(i);
				if(b.getPrice()>price) {
				list1.add(b);
				}
			}
			return list1;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
}
	
	
}