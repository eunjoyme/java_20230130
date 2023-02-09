package day9;

import java.util.Date;
import java.util.List;

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
		
		private long replyCount = 0;     //답글개수를 보관할 변수
		private List<Long>replyNoList = null; //n개의 답글 번호 보관할 변수
}
