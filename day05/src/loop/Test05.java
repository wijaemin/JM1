package loop;

public class Test05 {

	public static void main(String[] args) {
		
		int num=1;
		
		for(int i=0;i<99;i++) {
			if(num%10==3 || num%10==6 || num%10==9) {
				System.out.println(num);
			}
			if(num/10==3 || num/10==6 || num/10==9) {
				if(num%10!=3 && num%10!=6 && num%10!=9) {
				System.out.println(num);
				}
			}
			num++;
		}
		
		
	}
}
