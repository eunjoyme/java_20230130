package day14;

import java.util.Date;
import java.util.List;

import lombok.Data;
@Data
public class Board {

	long brdNo;       //글번호
	String brdTitle;  //글제목
	String brdContent;//글내용
	String brdWriter; //작성자
	long brdHit;      //조회수
	Date brdDate;     //등록일자
	
	long replyCount;       //답글개수를 보관할 변수
	List<Long>replyNoList; //n개의 답글 번호 보관할 변수
}
