package day6;

import java.util.Date;

public class Main3 {

	public static void main(String[] args) {

		ItemDB mDB = new ItemDB();
		
		Item item = new Item(2, "레드향","달고 시그러움", 12000, 2, new Date() );
		int ret = mDB.insertItem(item);
		System.out.println(ret);
		
		//Item item = new Item();
		/*item.setCode(1);
		item.setName("딸기");
		item.setContent("달아유");
		item.setPrice(9000);
		item.setQuantity(6);
		mDB.updateItem(item);*/
		
		/*int ret = mDB.deleteItem(1);
		System.out.println(ret); */
		
		mDB.printItems();
		
	}

}
