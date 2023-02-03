package day4;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class Item {

	private long code = 0L;             //물품코드
	private String name = null;         //물품명
	private String content = null;      //물품설명
	private int price = 0;              //물품가격
	private int quantity = 0;           //수량
	private Date regdate = new Date();  //등록일
	private Member memberid = null;     //판매자
	
	//수량이 n개 미만이면 n개로 변경하는 메소드
	public int nQuantity( int i ) {
		if(this.quantity < i) {
			this.quantity = i;
		}
		return this.quantity;
	}

	//가격에 할인율 만큼 빼서 리턴하는 메소드
	public int salePrice(float per) {
		int result1 = (int)(this.price-(this.price*per));
		this.setPrice(result1);
		return this.price;
	}
	
	//총 판매금액을 리턴하는 메소드(가격*수량)
	public int totalPrice() {
		return this.price*(this.quantity);
	}
	
	//내용이 20자 이상이면
	//ex)12345678901234567890...으로 변환하는 메소드
  	  public String over20() {
		if(this.content.length()>=20) {
			return (this.content.substring(0, 20)+"...");
		}
		return this.content;
	}
	
	//이름을 뒤집어서 반환하는 메소드  123=>321
	//ex)가나다 => 다나가(0 1 2) 3 
	public String revName(){
		int i=0;
		String ret = ""; //문자를 누적할 변수
		for(i=this.name.length()-1; i>=0; i-- ) {
			char tmp = this.name.charAt(i);
			ret =ret+tmp;
		}
		return ret;
	}

	
	
	
	public Item() {
		super();
	}

	public Item(long code, String name, String content, int price, int quantity, Date regdate, Member memberid) {
		super();
		this.code = code;
		this.name = name;
		this.content = content;
		this.price = price;
		this.quantity = quantity;
		this.regdate = regdate;
		this.memberid = memberid;
	}
	
	

	
	

}
