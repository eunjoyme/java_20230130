package day5;

import cls.Book;

public class Main5 {

	public static void main(String[] args) {

		//Input 클래스의 static inputBookData()를 호출해서 키보드로 입력받은 후 Book타입으로 받기
		Book book = Input.inputBookData();
		
		//위에서 받은 Book타입을 	Output클래스의 printBook()메소드로 전달하여 출력
		Output.printBook(book);
	}

}
