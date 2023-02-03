package day5;

import java.util.ArrayList;

public class Main3 {

	public static void main(String[] args) {
		
		// 배열은 원시타입, 
		//Object타입 초기값은 null로
		int[] a     = new int[5];    // 5개 만들어짐,초기값 0
		//float[] a = new float[5];  // 5개 만들어짐, 초기값 0
		int[] b     = {1,2,3,4,5};   // 5개 만들어짐,초기값 { }설정
		String c[]  = new String[5]; // 5개 만들어짐, 초기값 null
		Integer d[] = new Integer[5];// 5개 만들어짐, 초기값 null
		
		//컬렉션 쓰는 이유? 배열의 개수를 모름, 가변 배열...
		ArrayList<Integer> e= new ArrayList<Integer>();
		e.add(100);
		e.add(200);
		e.add(300);
		e.add(400);
		System.out.println(e.size());
		e.remove(2);   // 0 1 2(300)에 위치한 300삭제
		System.out.println(e.size());
		for(int i=0; i<e.size(); i++ ) { // 0 1 2
			System.out.println(e.get(i));
		}
		
		//뒤집기
		for(int i= e.size()-1; i>=0; i--) {
			System.out.println(e.get(i) );
		}
	}

}
