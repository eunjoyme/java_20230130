package day6;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Item {

	private long code = 0L;             //물품코드
	private String name = null;         //물품명
	private String content = null;      //물품설명
	private int price = 0;              //물품가격
	private int quantity = 0;           //수량
	private Date regdate = new Date();  //등록일
}
