package day8;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Book {

	private int no= 0;        //책번호 no //시퀀스 이용
	private String title= ""; //책제목 title
	private String author=""; //저자 author
	private long price =0;    //가격 price
	private char cate= 'A';   //분류 cate 'A', 'B', 'C'
	private Date date=null;   //등록일자 date
	
}
