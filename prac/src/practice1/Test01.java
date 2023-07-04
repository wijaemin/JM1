package practice1;

public class Test01 {
	public static void main(String[] args) {
		int square=Robot.square(11);
		System.out.println(square);
		
		float triangle=Robot.triangle(3, 7);
		System.out.println(triangle);
		
		float circle=Robot.circle(5);
		System.out.println(circle);
		
		int data[]= {50,10,30,40,20};
		Robot.sort(data);
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
