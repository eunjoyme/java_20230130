package day14;

import java.util.Map;

public interface MemberDB {

	//회원가입
	public int memberJoin(Member member);
	
	//로그인
	public Member memberLogin(Map<String, Object>map);
	
	//회원정보조회
	public Member memberselectOne(String id);
	
	//회원정보변경(비밀번호 변경X)
	public int memberUpdateOne(Member member);
	
	//비밀번호 변경
	public int memberUpdatePWOne(Map< String, Object> map);
	
	//회원탈퇴
	public int memberDeletOne(String id);
	
}
