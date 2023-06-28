package array;

public class Test10 {

	public static void main(String[] args) {
		/* 배열의 주요 계산 방법 -최대/최소 찾기
		 * =data의 가장 큰값이 얼마인가?어디있는가? 
		 * =data의 가장 작은값이 얼마인가?어디있는가? 
		 * 		
		 */
		int[] data =new int[] {30,50,20,10,90};
		//data ========>[30],[50],[20],[10],[40] (length=5)
		//최대값은 [0]위치가 가장 크다고 가정하고[1]부터 끝까지 비교하여 더 큰 데이터가 나오면 덮어쓰기하여 구한다
		int max=data[0];
		for(int i=1;i<data.length;i++) {
			System.out.println("현재 max 값= "+max);
			if(max<data[i]) {
				max=data[i];
			}
			System.out.println("바뀐 max 값= "+max);
			System.out.println("================");
			
		}
		
		
		
		
	}

}
