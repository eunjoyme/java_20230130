package day7;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Board {

		private long brdNo = 0L;        //글번호
		private String brdTitle = "";   //글제목
		private String brdContent = ""; //글내용
		private String brdWriter = "";  //작성자
		private long brdHit = 0L;       //조회수
		private Date brdDate = null;    //등록일자
		
}
