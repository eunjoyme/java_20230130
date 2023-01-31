package main1;

import java.util.Date;

import cls.Item;

public class Main6 {

	public static void main(String[] args) {

		//1.물품등록 
		Item obj = new Item();
		obj.setNo(100L);
		obj.setName("사과");
		obj.setContent("상큼함");
		obj.setPrice(10000);
		obj.setQuantity(10);
		obj.setDate(new Date() ); //ctrl+shift+o
		
		//2. 20% 할인한 금액으로 자동계산 될 수 있는 기능
		
		obj.disCountPrice(0.2f);
		
		//3. 재고수량이 100개 미만이면 1000개로 변경시키는 기능
		obj.checkQuantity(100);
		
		
		//4.물품내용 확인
		System.out.println(obj.toString() ); //현재 저장된 내용확인
	}

}
