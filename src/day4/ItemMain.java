package day4;

import java.util.Date;

public class ItemMain {

	public static void main(String[] args) {

		Member member = new Member();
		Item item = new Item(100, "바나나", "부드러움", 1000, 50, 
				new Date(), member);
		
		
		
		
		
		System.out.println(item.toString());
		System.out.println(item.totalPrice(0.2f));
		
	
	}

}
