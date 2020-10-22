package green;

public class VOScore {
	
	private int num;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private float avg;
	private String grade;

	public int getKor() {
		return kor;
	}

	public VOScore setKor(int kor) {
		this.kor = kor;
		return this;
	}

	public int getEng() {
		return eng;
	}

	public VOScore setEng(int eng) {
		this.eng = eng;
		return this;
	}

	public int getMath() {
		return math;
		
	}

	public VOScore setMath(int math) {
		this.math = math;
		return this;
	}

	public int getTotal() {
		this.total = this.kor + this.math + this.eng;
		return this.total;
	}

	public float getAvg() {
		this.avg = (float) (Math.round(getTotal() / 3.0f*100)/100.0);
		return this.avg;
	}

	public String getGrade() {
		setGrade();
		return grade;
	}

	public void setGrade() {
		float avg = getAvg() / 9;
		String grade = null;
		if (avg >= 9) {
			grade = "A";
		} else if (avg >= 8) {
			grade = "B";
		} else if (avg >= 7) {
			grade = "C";
		} else if (avg >= 6) {
			grade = "D";
		} else {
			grade = "F";
		}
		this.grade = grade;
	}

	public int getNum() {
		return num;
	}

	public VOScore setNum(int num) {
		this.num = num;
		return this;
	}

	public String getName() {
		return name;
	}

	public VOScore setName(String name) {
		this.name = name;
		return this;
	}

}
