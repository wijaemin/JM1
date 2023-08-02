package jdbc.dto;

import java.sql.Date;

public class GoodsDto {

	private int no;
	private String name;
	private String type;
	private int price;
	private Date made;
	private Date expire;
	public GoodsDto() {
		super();
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getMade() {
		return made;
	}
	public void setMade(Date made) {
		this.made = made;
	}
	public Date getExpire() {
		return expire;
	}
	public void setExpire(Date expire) {
		this.expire = expire;
	}
	@Override
	public String toString() {
		return "GoodsDto [no=" + no + ", name=" + name + ", type=" + type + ", price=" + price + ", made=" + made
				+ ", expire=" + expire + "]";
	}
	
	
	
	
}
