package api.lang.string2;

public class Member {
	public String memberId;
	String memberPw;
	String memberName;
	String memberLevel;
	int memberPoint;
	
	
	public String getMemberId() {
		
		return memberId;
		
	}
	public void setMemberId(String memberId) {
		String regex ="^[a-zA-Z0-9]{8,20}$";
		memberId.matches(regex);
		
		this.memberId = memberId;
	}
	public String getMeberPw() {
		return memberPw;
	}
	public void setMeberPw(String memberPw) {
		String regex ="^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$])[A-Za-z0-9!@#$]$";
		memberPw.matches(regex);
		this.memberPw = memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		String regex ="^[가-힣]{2,7}";
		memberPw.matches(regex);
		this.memberName = memberName;
	}
	public String getMeberLevel() {
		return memberLevel;
	}
	public void setMeberLevel(String meberLevel) {
		//switch(memberLevel) {
		//case "관리자" , "우수회원", "일반회원" :
		//this.memberLevel=memberLevel;
		//}
		this.memberLevel = meberLevel;
	}
	public int getMemberPoint() {
		return memberPoint;
	}
	public void setMemberPoint(int memberPoint) {
		this.memberPoint = memberPoint;
	}
	void show() {
		System.out.println(this.getMemberId());
		System.out.println(this.getMeberPw());
		System.out.println(this.getMemberName());
		
	}
	//Member(String memberId,String memberPw,String memberName,String memberLevel,int memberPoint) {
		
	//}
	
	
}
