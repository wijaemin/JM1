package api.lang.string3;

public class Test01_1 {
	public static void main(String[] args) {
		//문자열 합성
		//=원하는 문자열을 만들기 위해 지속적인 연결을 하는 직업
		
		
		String regex="";
		regex +="(";
		regex +="신발끈";
		regex += "|";
		regex +="개나리";
		regex +=")";
		
		String line="이런 신발끈 개나리 진달래같은!!!!";
		
		//line=line.replaceAll("(신발끈|개나리)", "***");
		line=line.replaceAll(regex, "***");
		System.out.println(line);
	}
}
