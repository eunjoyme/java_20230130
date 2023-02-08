package day8;

//환경설정과 관련된 속성 정보를 보관하는 클래스 Properties
public class Config {

	//서버접속정보
	public static final String URL
	    = "mongodb://id224:pw224@1.234.5.158:37017/db224";
	
	//사용할 수 있는 인원정보
	public static final int MAX = 10000;
	
	//게시글의 숫자를 10개
	public static final int BOARDMAX = 10;
	
	
	//데이터베이스 명칭
	public static final String DBNAME = "db224";
	
}
