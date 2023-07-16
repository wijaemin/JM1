 package loop;

public class Test04 {

	public static void main(String[] args) {
	int num=1;
		
	for(int i=0;i<99;i++) {
		if(num/10==5) {
			System.out.println(num);
		}
		if(num%10==5) {
			if(num/10!=5) {
				System.out.println(num);	
				}
		}
		num++;
		}
	}
}
