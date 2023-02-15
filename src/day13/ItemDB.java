package day13;

import java.util.List;
import java.util.Map;

public interface ItemDB {

	//물품 전체 목록
	public List<Map<String, Object>> selectItemListMap(int n);
	public List<Item> selectItemList(int n);
	
	//가격대별 수량
	public List<Item> selectItemListPrice(int n);
	
	//시간대별 재고수량 합계
	public List<Item> selectItemListDate();
		
	//재고수량이 1000이상인 것 3자리 콤마추가
	public List<Item> selectItemListQuantity(int n);
	
	//물품 등록
	public int insertItemMap(Map<String, Object> map );
	
	//물품 1개 삭제  ex)1004
	public int deleteItemOne(long no);
	
	//물품 n개 삭제  ex) {1004, 1007, 1010}
	public int deleteItemMany(long[] no);
	
	//물품 수정하기
	public int updateItemOne(Item item);
}
