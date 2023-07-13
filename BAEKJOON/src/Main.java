import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

	Scanner sc= new Scanner(System.in);
	
	int H=sc.nextInt();
	int M=sc.nextInt();
	sc.close();
	int totalTime=H*60+M;
	if(totalTime<45) {
		totalTime+=1440;
	}
	int totalTime2=totalTime-45;
	int totalH=totalTime2/60;
	int totalM=totalTime2%60;
	System.out.println(totalH);
	System.out.println(totalM);
	}
}