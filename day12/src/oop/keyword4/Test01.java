package oop.keyword4;

public class Test01 {
	public static void main(String[] args) {
		int square= Robot.square(11);
		System.out.println(square);
		double triangle =Robot.triangle(3, 7);
		System.out.println(triangle);
		float circle =Robot.circle(5);
		System.out.println(circle);
		
		//(주의) 참조형 데이터는 리모컨만 전달하면 외부에서 직접 제어 가능
		int[]data= new int[] {30,50,20,10,40};
		Robot.sort(data);//리모컨 전달(call-by-reference)
		for(int i=0;i<data.length;i++) {
			System.out.print(data[i]);
			System.out.print("\t");
		}
		System.out.println();
		
		Robot.reverse(data);
		
		
		for(int i=0;i<data.length;i++) {
			System.out.print(data[i]);
			System.out.print("\t");
		}
		
		System.out.println();
		
		

		
		Robot.shuffle(data);
		
		for(int i=0;i<data.length;i++) {
			System.out.print(data[i]);
			System.out.print("\t");
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
