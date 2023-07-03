package oop.constructor3;

public class Character {
	//멤버 필드
	String id;
	String job;
	int level;
	//멤버 메소드
	
	
	void setId(String id) {
		this.id = id;
	}
	void setJob(String job) {
		switch(job) {
		case "전사" , "마법사", "궁수" :
		this.job=job;
		}
	}
	void setLevel(int level) {
		if(level<1) return;
		this.level=level;
	
	}
	String getId() {
		return this.id;
	}
	String getJob() {
		return this.job;
	}
	int getLevel() {
		return this.level;
	}

	
	//생성자= 생성 시 필요한 데이터를 강제하는 도구
	Character(String id, String job){
		this(id,job,1);
	}
	Character(String id, String job, int level){
		this.setId(id);
		this.setJob(job);
		this.setLevel(level);
	}
	
	
	void show() {
		System.out.println("<캐릭터 정보>");
		System.out.println("아이디 : " + this.getId());
		System.out.println("직업 : " + this.getJob());
		System.out.println("레벨 : " + this.getLevel());
		
	}
	
	
	
	
	
	
	
	
}
