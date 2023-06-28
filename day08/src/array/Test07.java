package array;

import java.util.Scanner;

public class Test07 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String[] s=new String[5];
		// s ====>[ null ] [ null ] [ null ] [ null ] [ null ] (length=5)
		
		for(int i =0; i<s.length;i++) {
			System.out.print("나라이름 : ");
			s[i] = sc.next();
		}
		
		
		for(int i =0; i<s.length;i++) {
			System.out.println(s[i]);
		}
		sc.close();
	}

}
