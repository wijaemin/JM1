package date3;

public class Test06 {
	public static void main(String[] args) {
		int num =32;
		
		int ten = num/10;
		int one =num%10;
		boolean tenClap =ten==3 ||ten==6 || ten==9;
		boolean oneClap =one==3 || one ==6 || one== 9;
		
		boolean clap =( tenClap || oneClap);
		System.out.println(clap);
		
	}
}
