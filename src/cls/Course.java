package cls;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Course {

	private long code = 10000L; //과목코드
	private String name = null; //과목명
	private int credit =0;      //학점
	private Date date = null;   // 데이터베이스에 자료가 저장되는 시점 기록
	private Professor professor= null; //교수

	
}
