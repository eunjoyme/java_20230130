package main1;

import cls.KorScore;

public class Main7 {

	public static void main(String[] args) {

		//1. 사용자가 입력한 값
		String[] s1 = {"가나다", "나다라", "마바사", "아자차", "타파하"};
		int []   s2 = {20, 99, 70, 98, 100};
		
		//2. KorScore클래스로 계산해야하는 데이터를 전송(setter)
		KorScore obj=new KorScore();
		obj.setStudent(s1);
		obj.setScore(s2);
		
		//3. 전체 합계를 구하기
		int sum = obj.sumScore();
		System.out.println("점수합은 = " + sum);
		
		//4. 평균
		float avg = obj.avgScore();
		System.out.println("평균은= "+ avg);

		//5. 최대점수
		int max = obj.scoreMax();
		System.out.println("최대점수는 = " + max);
		
		//6. 최소점수
		int min = obj.scoreMin();
		System.out.println("최소점수는 = " + min);
		
		//7. 90점 이상인 사람이 몇명인지?
		int cnt = obj.score90();
		System.out.println("90점 이상인 사람 수는= "+cnt );
		
		//8. 확인
		System.out.println(obj.toString() );
	}

}
