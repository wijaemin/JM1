package jdbc.dto;

public class CustomerDto {
	private int customerNo;
	private String customerId;
	private String customerContact;
	private String customerJoin;
	private String customerPurchase;
	private int customerMileage;
	private String customerLevel;
	public CustomerDto() {
		super();
	}
	public int getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerContact() {
		return customerContact;
	}
	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}
	public String getCustomerJoin() {
		return customerJoin;
	}
	public void setCustomerJoin(String customerJoin) {
		this.customerJoin = customerJoin;
	}
	public String getCustomerPurchase() {
		return customerPurchase;
	}
	public void setCustomerPurchase(String customerPurchase) {
		this.customerPurchase = customerPurchase;
	}
	public int getCustomerMileage() {
		return customerMileage;
	}
	public void setCustomerMileage(int customerMileage) {
		this.customerMileage = customerMileage;
	}
	public String getCustomerLevel() {
		return customerLevel;
	}
	public void setCustomerLevel(String customerLevel) {
		this.customerLevel = customerLevel;
	}
	@Override
	public String toString() {
		return "CustomerDto [customerNo=" + customerNo + ", customerId=" + customerId + ", customerContact="
				+ customerContact + ", customerJoin=" + customerJoin + ", customerPurchase=" + customerPurchase
				+ ", customerMileage=" + customerMileage + ", customerLevel=" + customerLevel + "]";
	}
	
	
	
}
