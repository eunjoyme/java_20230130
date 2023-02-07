package day7;


import java.util.List;

public class Main {

	public static void main(String[] args) {
	
		//설계도면 객체 = new 구현한클래스의 생성자();
		BoardDAO obj = new BoardDAOImpl();
		
		//조회수가 hit보다 이하 출력하기.
//		obj.selectBoardHitList(90);
		
		// 목록으로 전송됨. 목록은 반드시 반복문을 사용해서 1개씩 출력
//		List<Board> list = obj.selectBoardList();
		
		//list의 값을 1개씩 꺼내서 one변수 보관하는 방식
//		for(Board one : list ) {
//			System.out.println(one.getBrdNo() + "," + one.getBrdTitle()
//			+ "," + one.getBrdHit() + "," + one.getBrdWriter()
//			+ "," + one.getBrdDate() );
//		}
		//배열의 위치를 이용하여 출력하는 방식
//		for(int i=0; i<list.size(); i++) {
//			Board one = list.get(i);
//			System.out.println(one.getBrdNo() + "," + one.getBrdTitle()
//			+ "," + one.getBrdHit() + "," + one.getBrdWriter()
//			+ "," + one.getBrdDate() );
//		}
		
		//조회
//		Board brd = obj.selectBoardOne(4);
//		System.out.println(brd.toString() );
		
		//수정
//		Board board = new Board();
//		board.setBrdNo(4);
//		board.setBrdTitle("코딩교육");
//		board.setBrdContent("이빨 나감");
//		board.setBrdWriter("성주아가");
//		board.setBrdHit(80L);
//		System.out.println(obj.updateBoard(board));
		
		//삭제
//		int ret = obj.deleteBoard(7);
//		System.out.println(ret);
		
		//고객이 입력한 내용에 해당(출력)
//		Board board = new Board();
//		board.setBrdTitle("제목");
//		board.setBrdContent("내용");
//		board.setBrdWriter("작성자");
//
//		int ret = obj.insertBoard(board);
//		System.out.println(ret);
		
		
		//배열은 생성시에 반드시 개수가 정해져야 함. ex)5개
//		int[] a = {2,5,1,23,4}; //5개의 int형 공간이 생성, 위치는 0부터 4까지
//		int b [] = new int[5];  //5개의 int형 생성됨. 초기화 0으로
//		String[] c = new String[5]; //5개의 문자 타입 생성, 초기화 null
//		
//		b[0] = 12;
//		b[1] = 15;
//		b[2] = 233;
//		
//		//실제적으로 추가된 개수와 상관없음. 생성할 때의 개수일 뿐임.
//		System.out.println(b.length); //5가 출력됨.
//		
//		// 제너릭형태의 => 객체를 생성하면 타입도 설정할 수 있는 클래스
//		List<Integer> arr = new ArrayList<Integer>();
//		List<String> arr1 = new ArrayList<String>();
//		
//		for(int i=0; i<3; i++) {
//			arr.add(10+i); // 10 11 12
//		}
//		arr.size(); // 3이다.
//		
//		
//		MyListener m1 = new MyInter1();
//		MyListener m2 = new MyInter2();
//		
//		Print p = new Print();
//		p.action(m1);
		
		
//		new Frame1();
		
//		Child2 c2 = new Child2();  => Parent c2 = new Child2();
//		c2.work();
//		c2.study();
		
//		Child1 c1 = new Child1();  => Parent c1 = new Child1();
//		c1.work();
//		c1.study();
		
		/*Parent p = new Parent();
		//메소드는 객체변수.메소드호출()
		p.work();
		p.study();*/
		
	}

}
