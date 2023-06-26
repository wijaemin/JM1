package loop;

public class Test04_1 {

	public static void main(String[] args) {

		
	for(int i=1;i<=99;i++) {
		boolean ten= i/10 ==5;
		boolean one= i%10 ==5;
		boolean five=  ten||one;
		
		if(five) {
			System.out.println(i);
			}
		}
	}
}
