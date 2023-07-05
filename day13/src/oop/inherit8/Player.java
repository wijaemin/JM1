package oop.inherit8;

//추상 클래스가 되면(1) 객체 생성 금지(2) 추상 메소드 작성 가능
public abstract class Player {
	private String id;
	private int level;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		if(level<1) return;
		this.level = level;
	}
	public Player(String id) {
		this.setId(id);
		this.setLevel(1);
	}
	
	public abstract void attack();
	
	public abstract void move();
	
	public abstract void shop();
	
	public final void showInfo() {
		
		System.out.println("<정보 출력>");
		System.out.println("아이디 : " + this.getId() + ", 레벨 : " + this.getLevel());
	}
	
	
}
