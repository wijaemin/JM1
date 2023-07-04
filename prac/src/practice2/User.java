package practice2;

public class User {
	private final String id;
	private String password;
	private String nickname;
	
	public User(String id,String password,String nickname) {
		this.id=id;
		this.setPassword(password);
		this.setNickname(nickname);
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getId() {
		return id;
	}
	public String getPasswordMasking() {
		String total="";
		for(int i=0;i<password.length();i++) {
			if(i<=1) {
				total+=this.password.charAt(i);
			}
			else {
				total +="*";
			}
		}
		return total;
	}
	
	public void show() {
		System.out.println("아이디 : " + this.id);
		System.out.println("비밀번호 : " + this.getPasswordMasking());
		System.out.println("닉네임 : " + this.nickname);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
