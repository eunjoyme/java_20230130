package day10;

import java.util.List;
import java.util.Map;

public interface MemberDB {

	//추가하기
	public int insertMember(Member member);
	public int insertMember(Map<String, Object>map);
	
	//1개 조회
	public Member selectMemberOne(String id);
	public Map<String, Object>selectMemberMapOne(String id);
	
	//전체 조회
	public List<Member> selectMemberList();
	public List<Map<String, Object>>selectMemberMapList();
	int insertMemberMap(Map<String, Object> map);
}
