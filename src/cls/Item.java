package cls;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Item {

	private long no= 0L; //물품번호
	private String name = null; //물품명
	private String content = null; //물품내용
	private int price = 0; //가격
	private long quantity = 0L; //수량
	private Date date = null; // 날짜
	
	// getter / setter/ toString()
	
	//메소드 == 함수 (특정한 기능 구현)
	public void disCountPrice(float per ) {
		//현재가격에서 per만큼 빼야 됨.
		//변수, 조건문, 반복문, 배열...
		this.price = (int) (this.price - (this.price * per ));
	}
	
	public void checkQuantity(int num) {
		if(this.quantity<num ) {
			this.quantity = this.quantity + num;
		}
	
	}
}
