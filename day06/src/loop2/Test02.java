package loop2;

public class Test02 {

	public static void main(String[] args) {
		/*1부터 99 사이의 숫자 중 7이 포함된 숫자의 개수를 구하여 출력
		 * 
		 * 
		 */
		int count =0;
		for(int i =1;i<=99;i++) {
			boolean ten = i/10==7;
			boolean one = i%10==7;
			
			if(ten || one) {
				count++;
				}
		}
		System.out.println(count);
		
	}
}