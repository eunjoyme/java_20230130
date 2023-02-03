package day5;

public class Main1 {

	public static void main(String[] args) {
		//객체 생성(생성자가 호출됨)
	
		//프로그램이 실행될 때 static메소드가 있는 클래스는 자동적으로 1개의 객체를 생성.
		int ret6= Calc.sumMul(3, 4);
		System.out.println(ret6);
		
		
		Calc calc = new Calc(); //메모리, 자원 사용
		//int ret5 = calc.sumMul(3, 4);
		//System.out.println(ret5);
		
		int ret4 = calc.sumPlus(1, 2);
		System.out.println(ret4);
		
		//필요한 메소드(기능) 호출
		int ret=calc.sumPlus(3, 4);
		System.out.println(ret);
		
		float ret1=calc.sumDiv(10, 4);
		System.out.println(ret1);
		
		int ret3;
		try {
			ret3 = calc.sumMinus(10, 5);
			System.out.println(ret3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
