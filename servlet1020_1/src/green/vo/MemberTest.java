package green.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberTest {

	public static void main(String[] args) {
		int cnt = 0;
		
		Member[] members = new Member[3];
		List<Member> almembers = new ArrayList<Member>();
		Map<String, Member> mapMembers = new HashMap<String, Member>();
		for(int i = 0;i<members.length;i++) {
			members[i] = new Member();
		}
		members[0].setName("일배열").setEmail("rlaqh@naver.com").setPassword("1234").setNo(1);
		members[1].setName("이배열").setEmail("rlaqh@naver.com").setPassword("1234").setNo(2);
		members[2].setName("삼배열").setEmail("rlaqh@naver.com").setPassword("1234").setNo(3);
		almembers.add(new Member("보군", "1234", "sdfsd@sdsds.com", 1));
		almembers.add(new Member("보이군", "1234", "sdfsd@sdsds.com", 2));
		almembers.add(new Member("보사군", "1234", "sdfsd@sdsds.com", 3));
		Member mem1 = new Member("일보군", "1234", "1dfsd@sdsds.com", 1);
		Member mem2 = new Member("이보군", "1234", "2dfsd@sdsds.com", 2);
		Member mem3 =  new Member("삼보군", "1234", "3dfsd@sdsds.com", 3);
		
		mapMembers.put("1", mem1);
		mapMembers.put("2", mem2);
		mapMembers.put("3", mem3);
		
		
		for(Member i : members) {
			System.out.println("배열 :" + i.getNo()+"번 : " + i.getName()+ " "+i.getPassword()+" "+ i.getEmail());
		}
		for(Member i : almembers) {
			System.out.println("LIST :" + i.getNo()+"번 : " + i.getName()+ " "+i.getPassword()+" "+ i.getEmail());
		}
		for(String strKey : mapMembers.keySet()) {
			System.out.println("HashMap : " + mapMembers.get(strKey).toString());
			
		}
		
	}

}
