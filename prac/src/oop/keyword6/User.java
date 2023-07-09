package oop.keyword6;

public class User {
	final String id;
	String pw;
	String nickname;
	
	public User(String id,String pw,String nickname) {
		this.id=id;
		this.setPw(pw);
		this.setNickname(nickname);
		
		
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
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
	
	public String getMaskingPw() {
		String total= "";
		for(int i=0;i<pw.length();i++) {
			if(i<=1) {
				total+=this.pw.charAt(i);
			}
			else {
				total+="*";
			}
		}
		return total;
	}
	public void show() {
		System.out.println("아이디 : " + getId());
		System.out.println("비밀번호 : " + getMaskingPw());
		System.out.println("닉네임 : " + getNickname());
	}
	
}
