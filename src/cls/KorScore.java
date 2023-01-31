package cls;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//5명의 학생의 국어 점수를 보관하고 처리할 클래스
@Setter
@Getter
@ToString
public class KorScore {

	private String[] student = new String[5];
	private int[] score = new int[5];

	// getter, setter, toString 메소드가 존재함.

	// 학생들의 점수 합계를 구해주는 메소드
	public int sumScore() {
		int sum = 0;
		int i; // 반복문 임시변수
		for (i = 0; i < score.length; i++) { // 0 1 2 3 4 (x 5)
			sum = sum + this.score[i];
		}
		return sum;
	}

	// 학생들의 점수의 평균 구하기
	public float avgScore() {
		float avg = 0.0f;
		int sum = this.sumScore();
		avg = (float) sum / (float) this.score.length; // 실수 1개 이상 필요
		return avg;
	}

	// 90점 이상인 사람의 인원수
	public int score90() {
		int cnt = 0;
		int i;
		// 20, 99, 70, 98, 100
		for (i = 0; i < this.score.length; i++) {
			if (this.score[i] >= 90) {
				cnt = cnt + 1;
			}
		}
		return cnt;
	}

	// 최대점수
	public int scoreMax() {
		int i;
		int max = this.score[0];
		for (i = 0; i < this.score.length; i++) {
			if (max < this.score[i]) {
				max = this.score[i];
			}
		}
		return max;
	}

	// 최소점수
	public int scoreMin() {
		int i;
		int min = this.score[0];
		for (i = 0; i < this.score.length; i++) {
			if (min > this.score[i]) {
				min = this.score[i];
			}
		}
		return min;
	}
}
