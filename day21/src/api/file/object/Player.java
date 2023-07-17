package api.file.object;

import java.io.Serializable;

public class Player implements Serializable{
	
	private String id;
	private int level;
	private int money;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getLevel() {
		return level;
	}
	public int getPlusLevel() {
		return this.level++;
	}
	public void setLevel(int level) {
		if(level<0) return;
		this.level = level;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		if(money<0) return;
		this.money = money;
	}
	public Player(String id) {
		this.setId(id);
		this.setLevel(1);
		this.setMoney(0);
	}

	void show() {
		System.out.println("<캐릭터 정보>");
		System.out.println("아이디 : " + this.getId());
		System.out.println("레벨 : " + this.getLevel());
		System.out.println("소지금 : " + this.getMoney());
		
	}
	
	
	

	
	}
