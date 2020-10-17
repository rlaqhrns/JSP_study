package green;

public interface Operator {
	/*
	 * 메서드 생성 getName 파라미터 없음, 반환타입 문자열, 함수정의만, 추상메서드
	 * 메서드 생성 execute, 파라미터는 double형 2개, 반환타입 double형
	 * 	이 메서드는 throws Exception을 함수 정의 옆에 추가
	 * */
	public String getName();
	public double execute(double a, double b) throws Exception;
	
}
