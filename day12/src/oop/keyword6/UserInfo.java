package oop.keyword6;

public class UserInfo {
	private final String id;
	private String password;
	private String nickname;
	
	
	public UserInfo(String id, String password,String nickname) {
		this.id=id;
		this.setPassword(password);
		this.setNickname(nickname);
	}

	
	public void setPassword(String password) {
		this.password = password;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	
	public String getId() {
		return this.id;
	}


	public String getPassword() {
		return this.password;
	}


	public String getNickname() {
		return this.nickname;
	}
	
	//public String getPasswordMasking() {
	//	return "" + this.password.charAt(0) + this.password.charAt(1) + "**********";
	//}
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
