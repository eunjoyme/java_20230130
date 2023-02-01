package cls;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
//전화번호, 위치, 보유책(100)
public class BookStore {

	private String phone = "";//서점연락처
	private String address = ""; // 서점위치
	private Book[] books = null; //책
	
	private int idx = 0; //현재 배열에 추가되어 있는 책의 위치
	
	//생성장 1번만 사용가능함. 반환값없음. 클래스명과 정확하게 일치.
	//준비물이 없는 빈 생성자
	public BookStore() {
		this.books= new Book[100];
	}
	
	
	//책등록하는 메소드(함수) 필요
	public void insertBook(Book book) {
		if(idx>=100) {
			System.out.println("책 추가 불가");
		}
		else {
			books[idx]= book;
			idx++;
		}
	}
	
	//현재까지 등록된 책 목록 출력
	public void selectBook( ) {
		int i = 0;
		for(i=0;i<idx; i++) {
			System.out.println(books[i].toString() );
		}
	}
	
	//마지막 등록한 책을 삭제하는 메소드
	public void deleteBook() {
		if(idx>0) {
			idx--;
		}
	}
	
	//문제1) 등록한 책의 가격을 전달받은 할인율 변경 메소드
	public int discountPrice(float per) {
		//전체 보유하고 있는 책
		for (int i=0; i<idx; i++) {
			//현재 가격
			long price =books[i].getPrice();
			//실수형 => 정수 => 결과 값에 손실이 일어남.
			//long => int
			//int => long
			long result = (long)(price - (price*per));
			this.books[i].setPrice(result);
		}
		return 1;
	}
	
	//문제2) 가격이 n 1000원 이상인 책 수량을 반환하는 메소드
	public int priceQuery (int pr) {
		int cnt =0;
		for(int i=0;i<idx; i++) {
			if(this.books[i].getPrice() >= pr ) {
				cnt++;
			}
		}
		return cnt;
		
	}
	
	//문제3) 분류 코드가 전달받은 값이 항목만 출력하는 메소드
	public void printCate (char cate) {
		for(int i=0; i<idx; i++) {
			if(this.books[i].getCate()==cate) {
				System.out.println(this.books[i].toString());
			}
		}
	}
	
}
