package condition3;

public class Test02 {

	public static void main(String[] args) {
		/*switch~case 구문
		 *  if 구문은 "순차적"으로 실행되는 특징이 있다
		 *  이게 문제가 되는 상황이 있다
		 *  
		 */
		int month =1;
		
		switch(month) {
		
		case 3,4,5:
			System.out.println("봄");
			break;
		case 6,7,8:

			System.out.println("여름");
			break;
		case 9,10,11:
			System.out.println("가을");
			break;
		default:
			System.out.println("겨울");
			break;
		}
	}

}
