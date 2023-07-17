package api.file.object;

public class Account {
	private String name;
	private int money;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public Account(String name) {
		this.setName(name);
		this.setMoney(0);
	}
	void show() {
		System.out.println("이름 : " + this.getName());
		System.out.println("잔액 : " + this.getMoney());
	}
	
}
