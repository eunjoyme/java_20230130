package cls;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 등록된 교과목 목록을 저장하는 클래스

@Getter
@Setter
@ToString
public class CourseList {

	// 10개를 보관할 수 있는 배열
	// 배열은 반드시 개수가 필요함. 
	private Course[] courseArray = new Course[10];
	private int idx = 0; // 배열 내부의 개수를 저장하는 변수
	
	// 과목을 1개씩 등록할 수 있는 메소드
	public void insertCourse( Course course ) {
		// idx는 현재 추가된 개수 < 배열의 전체 개수
		if(this.idx < this.courseArray.length ) {
			this.courseArray[idx] = course;
			this.idx++;
		}
		else {
			System.out.println("등록 불가");
		}
	}
	
	// 추가된 과목의 전체 내용 출력
	public void printCourse() {
		for(int i=0; i<idx; i++) {
			System.out.println( this.courseArray[i].toString() );
		}
	}
	
	// 마지막에 추가한 과목 삭제하는 메소드
	
	
	// 과목중에서 전달받는 학점에 해당하는 과목 조회 
	// ex) 3을 전달하면 3학점에 해당하는 과목만
}