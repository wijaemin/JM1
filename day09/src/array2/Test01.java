package array2;

public class Test01 {
	public static void main(String[] args) {
		//정렬(sort)
		// 여러 개의 데이터를 원하는 목적에 맞게 나열하는 것
		// 번호순, 이름순, 가격순, 랭킹순, 성적순 ...
		// 번호순이라고 하면 번호가 낮은 것부터 나와야한다(오름차순)
		// 성적순이라고 하면 성적이 높은 것부터 나와야 한다(내림차순)
		// 정렬 방법은 여러가지가 있으며 상황에 따라 성능이 다르다
		// 사용자에게 데이터를 효과적으로 보여주기 위한 수단
		int[] data = new int[] {30,50,20,10,40};

		int min=0;
		for(int i =1; i<data.length;i++) {	
			if(data[min]>data[i]) {
				min=i;
			}
		}
		int backup=data[0];
		data[0]=data[min];
		data[min]=backup;
		System.out.println(data[0]);
		System.out.println(data[1]);
		System.out.println(data[2]);
		System.out.println(data[3]);
		System.out.println(data[4]);
	}
}
