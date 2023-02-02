package day4;

import java.util.Date;

public class AddressName {

	public static void main(String[] args) {

		Member member = new Member("id", "pw", "name", "010-0000-0000" ,
				"C", new Date() );
		Address address= new Address( 1000, "부산", "12345",
				new Date(), member);
		System.out.println(address.toString() );
		
		boolean result = address.invaildCode();
		System.out.println(result);
		
		boolean result1 = address.invalidAddress();
		System.out.println(result1);
		
		boolean result2 = address.invalidPostcode();
		System.out.println(result2);
		
		String str = address.getYear();
		System.out.println(str);
		
		String str1 = address.getMonth();
		System.out.println(str1);
		
		String str2 = address.getDay();
		System.out.println(str2);
	}

}
