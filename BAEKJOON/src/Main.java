import java.util.Scanner;
import java.util.InputMismatchException;
public class Main {


	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int A=sc.nextInt();
		int B=sc.nextInt();
		int C=sc.nextInt();
		
		int result=A+B+C;
		System.out.println(result);
		sc.close();
	}
}