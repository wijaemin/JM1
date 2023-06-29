package array3;

public class Test03 {
	public static void main(String[] args) {
		//다음 데이터를 2차월 배열에 저장하고 출력
		float[][]num=new float[][] {
			{1.5f, 2.5f, 3.6f},
			{10.2f, 5.3f, 6.5f}
		};
		for(int j=0;j<num.length;j++) {
			for(int i =0;i<num[j].length;i++) {
			System.out.println(num[j][i]);
			}
		}
	}
}
