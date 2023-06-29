package array2;

public class Test02 {

	public static void main(String[] args) {

		int []data = new int [] {30,50,20,10,40};

		for(int j=data.length-1;j>0;j--) {
			for(int i=0 ;i<j;i++) {
				if(data[i]>data[i+1]) {
					int backup = data[i];
					data[i]=data[i+1];
					data[i+1]=backup;
					}
				}
			}
		for(int i=0;i<data.length;i++) {
			System.out.print(data[i]);
			System.out.print("\t");
			}
	}
}
