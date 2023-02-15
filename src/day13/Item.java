package day13;

import java.util.Date;

import lombok.Data;

@Data
public class Item {
	
	private long no = 0L;              //물품번호 => _id가 됨 int64
 	
	private String name = null;         //물품명
	private String content = null;      //물품설명
	private int price = 0;              //물품가격   int32
	private int quantity = 0;           //수량      int32
	private Date regdate = new Date();  //등록일 

}
