package day4;

import java.util.Date;

public class ItemMain {

	public static void main(String[] args) {

		Member member = new Member();
		Item item = new Item(100, "바나나", "부드러움", 1000, 50, 
				new Date(), member);
		
		System.out.println(item.nQuantity(60));
		System.out.println(item.salePrice(0.2f));
		System.out.println(item.totalPrice());
		System.out.println(item.over20());
		System.out.println(item.revName());
		
	
	}

}
