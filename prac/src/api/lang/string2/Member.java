package api.lang.string2;

public class Member {
	//필드-데이터5개
	private String memberId;//회원아이디
	private String memberPw;//회원비밀번호
	private String memberName;//회원이름
	private String memberLevel;//회원등급(기본값 일반회원)
	private int memberPoint;//회원포인트(기본값 100점)
	
	//setter & getter
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		if(memberId.matches("^[A-Za-z0-9]{8,20}$"))
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		if(memberPw.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$])[A-Za-z0-9!@#$]{8,20}$")) {
			this.memberPw = memberPw;
		}
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		if(memberName.matches("^[가-힣]{1,2}[가-힣]{1,5}$")) {
			
			this.memberName = memberName;
		}
	}
	public String getMemberLevel() {
		return memberLevel;
	}
	public void setMemberLevel(String memberLevel) {
		if(memberLevel.matches("^(관리자|우수회원|일반회원)$")) {
			this.memberLevel = memberLevel;
		}
	}
	public int getMemberPoint() {
		return memberPoint;
	}
	public void setMemberPoint(int memberPoint) {
		if(memberPoint<0) return;
		this.memberPoint = memberPoint;
	}
	public String getMemberPwMasking() {
		return this.memberPw.substring(0,1)
				+"*".repeat(this.memberPw.length()-1);
	}
	
	public Member(String memberId, String memberPw, String memberName) {
		this.setMemberId(memberId);
		this.setMemberPw(memberPw);
		this.setMemberName(memberName);
		this.setMemberLevel("일반회원");
		this.setMemberPoint(100);
		
	}
	
	public void show() {
		System.out.println("<회원정보>");
		System.out.println("아이디 : " + this.memberId);
		System.out.println("비밀번호 :" + this.getMemberPwMasking());
		System.out.println("이름 : " + this.memberName);
		System.out.println("레벨 : " +this.memberLevel);
		System.out.println("포인트 : " +this.memberPoint);
	}
	

	
	
}
