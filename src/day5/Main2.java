package day5;

public class Main2 {

	public static void main(String[] args) {
		//클래스명 객체명 = new 생성자명();
		//제너릭 클래스의 타입은 원시타입은 불가능!!
		Exam<Integer> obj1=new Exam<Integer>();
		obj1.setElement(13); //13을 추가함
		int ret = obj1.getElement(); //13 가져오기
		System.out.println(ret);
		
		
		Exam<String> obj = new Exam<String>();
		obj.setElement("aaa");
		String str=obj.getElement();
		System.out.println(str);
		
	}

}
