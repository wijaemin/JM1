import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

	Scanner sc= new Scanner(System.in);
	
	int A=sc.nextInt();
	int B=sc.nextInt();
	int C=sc.nextInt();
	sc.close();
	if(A==B&&A==C) { //A,B,C모두 같을 때
		int prize=10000+A*1000;
		System.out.println(prize);
	}
	else if(A==B) {
		int prize=1000+A*100;
		System.out.println(prize);
	}
	else if(A==C) {
		int prize=1000+A*100;
		System.out.println(prize);
	}
	else if(B==C) {
		int prize=1000+B*100;
		System.out.println(prize);
	}
	else {
		if(A>B&&A>C) {
			int prize=A*100;
			System.out.println(prize);
		}
		else if(B>A&&B>C) {
			int prize =B*100;
			System.out.println(prize);
		}
		else {
			int prize=C*100;
			System.out.println(prize);
		}
	}
	}
}