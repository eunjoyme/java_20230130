package day13;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main1 {

	public static void main(String[] args) {
		
		ItemDB iDB = new ItemDBImpl();
		List<Item> list = iDB.selectItemList(100);
		
		//문제1) 가격대별 수량 구하기
		//1      ~999   =>1개
		//100    ~9999  =>1개
		//10000  ~99999 =>1개
		//100000원 이상   => 1개
//		int cnt[] = new int[4];
//		for(Item i : list) {
//			if(i.getPrice()>0 && i.getPrice()<=999) {
//				cnt[0]++;
//			}
//			else if(i.getPrice()<=9999) {
//				cnt[1]++;
//			}
//			else if(i.getPrice()<=99999) {
//				cnt[2]++;
//			}
//			else if(i.getPrice()>=100000) {
//				cnt[3]++;
//			}
//		}
//		System.out.println("백원대 수량=> " + cnt[0]);
//		System.out.println("천원대 수량=> " + cnt[1]);
//		System.out.println("만원대 수량=> " + cnt[2]);
//		System.out.println("십만원대 수량=> " + cnt[3]);

		
		//문제2) 시간대별 재고수량 합계(Date to String 으로 변환)
		//0시 => 1개
		//1시 => 2개
		//2시 => 2개
		//~~~
		//23시 => 1개
//		Calendar c = Calendar.getInstance();
//		c.setTime(new Date());
//		int n = c.get(Calendar.HOUR);
//		System.out.println(n);
		
		
//		int cnt[] = new int[25];
//		for(Item i : list) {
//		DateFormat dateFormat = new SimpleDateFormat("hh");  
//        String strDate = dateFormat.format(i.getRegdate());
//        int d = Integer.parseInt(strDate);
//        cnt[d]++;
//			}
//		for(int i=0; i<cnt.length; i++) {
//			System.out.println(i+"시:" + cnt[i]);
//		}
		
		
		//문제3) 재고수량이 1000이상인것만 3자리 콤마 추가 후 출력(int to String 으로 변환)
		// ex) 물품번호, 이름, 가격, 재고수량
		//      1001, 가나다,300, 12,343,343		
		DecimalFormat deformat = new DecimalFormat("###,###");
		for(Item i : list) {
			if(i.getQuantity()>=1000) {
				String a = deformat.format(i.getQuantity());
				System.out.println("물품번호 =>" + i.getNo());
				System.out.println("물품이름 =>" + i.getName());
				System.out.println("물품가격 =>" + i.getPrice());
				System.out.println("재고수량 =>" + a);
				System.out.println("-------------------------------");
			}
		}
		
		
		//물품 수정
//		Item item = new Item();
//		item.setNo(1006);
//		item.setName("포토");
//		item.setContent("알이 굵음");
//		item.setPrice(12000);
//		item.setQuantity(1708);
//		System.out.println(iDB.updateItemOne(item));
		
		//물품 1개 삭제
//		int ret = iDB.deleteItemOne(1018);
//		System.out.println(ret);
		
		//물품 n개 삭제
//		long no[] = {1037,1038,1039, 1040};
//		int ret = iDB.deleteItemMany(no);
//		System.out.println(ret);
		
//		Print print = new Print();
//		print.printPrice(iDB.selectItemList(0));
	}
}
