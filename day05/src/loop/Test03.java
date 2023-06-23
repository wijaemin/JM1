package loop;

public class Test03 {

	public static void main(String[] args) {
		
		int num =1;
		for(int i =0;i<100;i++) {
			if (num%2==1) {
				System.out.println(num);
			}
			num++;
		}
	}
}
