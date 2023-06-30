import java.util.Scanner;

public class Main {


	public static void main(String[] args) {

	Scanner sc= new Scanner(System.in);
	
	int x=sc.nextInt();
	int y=sc.nextInt();
	
	if(x>0&&y>0) {
		System.out.println(1);
	}
	else if(x<0&&y>0) {
		System.out.println(2);
	}
	else if(x<0&&y<0) {
		System.out.println(3);
	}
	else {
		System.out.println(4);
	}
/*	
	탭키 또는 띄어쓰기 4번을 하여 다음과 같이 작성합니다
	1. 첫번째 항목
		-세부항목1
		-세부 항목2
	2. 두번째 항목
	
	#체크박스
	
	리스트를 활용하여 체크박스를 구현할 수 있습니다.
	-[ ] 운동하기
	-[ ] 수업 복습하기
	-[x] 술마시기
	-[x] 게임하기
	
	# 표 만들기
	
	| 항목1 | 항목2 | 항목 |
	| --- | --- | --- |
	| 내용1 | 내용2 | 내용3 |
	
*/
	}
}