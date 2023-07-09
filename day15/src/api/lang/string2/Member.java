package api.lang.string2;

public class Member {
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberLevel;
	private int memberPoint;
	
	
	public String getMemberId() {
		
		return memberId;
		
	}
	public void setMemberId(String memberId) {
		String regex ="^[a-zA-Z0-9]{8,20}$";
		memberId.matches(regex);
		if(memberId.matches(regex)) {
			this.memberId = memberId;
		}
		else return;
	}
	
	
	public String getMemberPw() {
		return memberPw;
	}
	
	public void setMemberPw(String memberPw) {
		String regex ="^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$])[A-Za-z0-9!@#$]{8,15}$";
		if(memberPw.matches(regex)) {
			this.memberPw = memberPw;
		}
		else return;
			
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		String regex ="^[가-힣]{2,7}";
		if(memberName.matches(regex)) {
			this.memberName = memberName;
		}
		else return;
	}
	public String getMemberLevel() {
		return memberLevel;
	}
	public void setMemberLevel(String memberLevel) {
		if(memberLevel.equals("관리자")|memberLevel.equals("우수회원")|memberLevel.equals("일반회원")) {
			this.memberLevel = memberLevel;
		}
		else return;
	}
	public int getMemberPoint() {
		return memberPoint;
	}
	public void setMemberPoint(int memberPoint) {
		if(memberPoint<0) return;
		this.memberPoint = memberPoint;
	}
	public String getMemberPwMasking() {
		String total="";
		for(int i=0;i<this.memberPw.length();i++) {
			if(i<1) {
				total+=memberPw.charAt(i);
			}
			else {
				total +="*";
			}
		}
		return total;
	}
	public Member(String memberId,String memberPw,String memberName) {
		this.setMemberId(memberId);
		this.setMemberPw(memberPw);
		this.setMemberName(memberName);
		this.setMemberLevel("일반회원");
		this.setMemberPoint(100);

	}
	
	void show() {
		System.out.println(this.getMemberId());
		System.out.println(this.getMemberPwMasking());
		System.out.println(this.getMemberName());
		System.out.println(this.getMemberLevel());
		System.out.println(this.getMemberPoint());
		
	}

	
	
}
