import java.util.Scanner;

public class Main {


	public static void main(String[] args) {

	Scanner sc= new Scanner(System.in);
	
	int s=sc.nextInt();
		if(s%400==0||(s%4==0&&s%100!=0)){
			System.out.println(1);
		}
		else
			System.out.println(0);
	}
}