package data;

public class Test13 {

	public static void main(String[] args) {
		//5잔당 1잔씩 무료로 제공하는
		//KH커피숍에서는 커피 5잔당 1잔씩 무료로 제공하는이벤트를 하고 있습니다
		//우리반 학생 27명과 강사까지 마실 커피를 주문했을 때 다음 항목을 계산하여 출력하세요
		//무료로 계산되는 커피 잔 수
		//최종 결제 금액

		
		//커피는 한 잔에 2500원입니다
		/*int coffeePrice= 2500;
		int student = 27;
		int teacher = 1;
		int totalPeople =student+teacher;
		
		int freeCoffee = totalPeople/5;
		int totalPrice = coffeePrice*(totalPeople -freeCoffee);
		System.out.println(freeCoffee);
		System.out.println(totalPrice);
		*/
			int count =28;
			int price = 2500;
			
			int free =count /6;
			int pay = count -free;
			
			System.out.println(free);
			System.out.println(price*pay);
			
		
		
		
	

		
		
		
	}

}
