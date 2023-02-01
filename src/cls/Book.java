package cls;

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

//책번호 no
//책제목 title
//저자 author
//가격 price 12000
//분류 cate 'A', 'B', 'C'
//등록일자 date
public class Book {

	private int no= 0; // private Integer no1 = 0;
	private String title= "";// null, ""
	private String author="";
	private long price =0;
	private char cate= 'A';
	private Date date=null;
	
}
