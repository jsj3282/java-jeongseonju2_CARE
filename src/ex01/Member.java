package ex01;

public class Member {
	private String name;
	private String id;
	private String pw;
	private boolean gender;
	private String age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public int getHobby() {
		return hobby;
	}
	public void setHobby(int hobby) {
		this.hobby = hobby;
	}
	private int hobby;
}
