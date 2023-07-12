package array3;

public class Test04 {
	public static void main(String[] args) {
		//String[][] s=new String[2][3];
		String[][] s=new String[][] {
			{"자바","스프링","안드로이드"},
			{"파이썬","판다스","장고"}
		};
		
		System.out.println(s.length);
		System.out.println(s[0].length);
		
		for(int j=0;j<s.length;j++) {
			for(int i=0;i<s[j].length;i++) {
			System.out.print(s[j][i]);
			System.out.print("\t");
			}
			
			System.out.println();
		}
		
		
	}
}
