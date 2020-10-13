
package green;

public class User {
	String name;
	int num;

	public User() {
		this.name = null;
		this.num = 0;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	public int getNum() {
		return this.num;
	}
}
