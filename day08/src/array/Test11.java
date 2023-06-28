package array;

public class Test11 {

	public static void main(String[] args) {
		/*	5명의 키 데이터가 다음과 같을 때 가장 키가 작은 사람의 위치와 값을 출력
		 * 
		 * 데이터:'150.8','180.2','175.9','162.7','170.3'
		배열은 int로 밖에 못만듬 / long은 안됨
		 */
		double[] height=new double[]{190.8,180.2,175.9,162.7,170.3};//0,1,2,3,4 /length=5
		
		int minIndex=0;
			
		for(int i =1;i<height.length;i++) {
			if(height[minIndex]>height[i]) {
				minIndex=i;
			}
		}
		System.out.println("작은 값의 위치= " + minIndex);
		System.out.println("작은 값 = " +height[minIndex]);
	}
}
