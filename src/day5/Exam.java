package day5;

//Student ,Book

//제너릭 클래스
//타입을 설정한 다음에 클래스로 사용하겠다.
//T는 정해져 있지 않음 => T는 누가 정하나?? Main2.java에서 정할 예정
public class Exam<T> {

	//변수 1개
	private int a=14;
	private int b=14;
	
	private T element;
	
	//public 반환타입
	public T getElement() {
		return element;
	}
	
	public void setElement(T element) {
		this.element = element;
	}
	
	
}
