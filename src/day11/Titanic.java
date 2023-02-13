package day11;

import lombok.Data;

@Data
public class Titanic {
	private	String embarked	= null;  //탑승한 곳(항구)	C = Cherbourg, Q = Queenstown, S = Southampton
	private Float age	= 0.0F;     //나이	 
	private int	parch	= 0;        //타이타닉에 탑승한 부모/자녀 수	 
	private String cabin	= null; //객실 번호	 
	private	int pclass = 0;	        //티켓 등급	1 = 1st, 2 = 2nd, 3 = 3rd
	private	String sex	= null;     //성별	 
	private String survived	= null;    //생존여부	0 = No, 1 = Yes
	private String	ticket	= null; //티켓번호	 
	private int passengerId = 0;
	private int	sibsp	= 0;        //타이타닉에 탑승한 형제/자매 수	 
	private	Float fare	= 0.0F;     //운임(티켓요금)	 
	private String name = null;
}
