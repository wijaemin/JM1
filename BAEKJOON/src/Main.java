import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int count=sc.nextInt();
        int count1=0;
        int count2=0;
        for(int i=0;i<count;i++) {
        	int num=sc.nextInt();
        	for(int j=1;j<=num;j++) {
        		if(num%j==0) count2+=1;
        	}
        	if(count2==2) count1+=1;
        }
        System.out.println(count1);
	}
}
