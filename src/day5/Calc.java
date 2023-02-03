package day5;

public class Calc {

	//변수x
	
	//getter, setter, toString X
	//생성자를 만들지 않으면 public Calc(){}
	
	//static 정적
	public static int sumMul(int n, int m) {
		int tmp=n*m;
		return tmp;
	}
	
	public int sumMinus (int n, int m) throws Exception {
		int tmp = n-m;
		return tmp;
	}
	
	
	//2개의 정수가 전달되면 더하기를 해서 반환 메소드
	public int sumPlus(int n, int m) {
		int sum = n+m;
		return sum;
	}
	
	
	public float sumDiv(int n, int m) {
		try {
			float div = (float)n/m; // 정수/정수 => 정수
			return div;
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace(); //오류를 추가할 수 있게 상세히 출력해줌. 개발자를 위해서
			return 0.0f;
		}
	}
	
	//public float
	
}
