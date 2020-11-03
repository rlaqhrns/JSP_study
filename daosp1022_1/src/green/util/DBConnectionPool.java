package green.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class DBConnectionPool {
	// 문자열 멤버변수 URL;
	String url;
	// 문자열 멤버변수 UserName;
	String username;
	// 문자열 멤버변수 password;
	String password;
	// 객체 배열 connection 객체를 저장 할 ArrayList 객체 생성
	ArrayList<Connection> connList = new ArrayList<>();
	// 생성자
	// 파라미터 문자열 driver, 문자열 url, 문자열 username, 문자열 password 기능
	// 멤버 변수 url의 값을 파라미터 url값으로 설정
	// 멤버변수 username의 값을 파라미터 username으로 설정
	// Class.forName(driver);
	public DBConnectionPool(String driver, String url, String username, String password) throws Exception {
		this.url = url;
		this.username = username;
		Class.forName(driver);
	}
	// getConnection 메서드, 파라미터는 없고 반환타입은 Connection 타입
	// 함수 정의 문 옆에 throws Excetion 추가
	// if문으로 멤버변수 connList의 크기를 알아내는 size 메서드 호출하고 그 크기가 0보다 크면
	// connList를 이용하여 Connectiuon 객체 0번째 Connection 객체 제거(remove(0) 호출)
	// remove(0) 메서드 호출후 반환된 값을 위에서 선언한 connection 객체참조변수 conn에 저장
	// 이 if문 내(중첩)에서 conn의 메서드 isValid(10)을 호출하고 호출결과가 참이면 conn반환
	// 외부 if문에서 return DriverManager.getConnection(url, username, password)
	public Connection getConnection() throws Exception {
		if (connList.size() > 0) {
			Connection conn = connList.remove(0);
			if (conn.isValid(10)) {
				return conn;
			}
		}
		return DriverManager.getConnection(url, username, password);

	}
	// returnConnection 메서드 선언, 파라미터는 Connection 타입의 conn
	// 함수의 오른쪽에 throws Exception 추가
	// 기능은 멤버변수 connList의 메서드 add호출, 호출시 파라미터 conn추가
	// closeAll 메서드, 파라미터 없고 반환값 없음
	// advanced for 문 이용하여 conList에 저장되어 있는 Connection 객체의 close()호출
	public void returnConnection(Connection conn) throws Exception {
		connList.add(conn);
	}
	
	public void closeAll() {
		for(Connection conn : connList) {
			try {conn.close();}catch(Exception e) {}
		}
	}
	
	

	
}
