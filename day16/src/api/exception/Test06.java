package api.exception;
import java.time.LocalDate;
import java.util.Scanner;
//사용자에게 생년월일을 'YYYY-MM'형식으로 입력받습니다.
//이 사용자의 한국나이와 만나이를 구하여 출력

//만나이는 태어난 달이거나 해당 달이 지나면 1살을 추가하는 방식으로 구현
// '''
//예를들어 2000년 1월 5일생이면 2000년1월이 되면 한살이 됩니다
//'''
//처리를 하면서 문제가 되는 상황이 발생하면 상황에 맞는 에러메세지를 출력
//예상 가능한 문제상황들은 다음과 같습니다.
//1.입력이 너무 짧은 경우
//2.숫자 변환이 올바르게 되지 않은 경우
//3.생년월일을 미래의 값으로 입력하는 경우
//4, 월을 '1'~'12'로 입력하지 않은 경우
//5.연도가 '1900'미만인 경우


public class Test06 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		String input =sc.next();
		
		String part1=input.substring(0,4);
		//if(입력이 너무 짧을 경우) {
			
		//}
		String part2 =input.substring(5,7);
		
		int year=Integer.parseInt(part1); //출생년도
		int month=Integer.parseInt(part2);//출생월
		int nowY=LocalDate.now().getYear();//현재년도
	//	System.out.println(nowY);
		int nowM=LocalDate.now().getMonthValue();//현재월
	//	System.out.println(nowM);
		
		int totalMonth=year*12+month;
		int nowTotalMonth=nowY*12+nowM;
		
		int age=(nowTotalMonth-totalMonth)/12;
		int koreanAge=nowY-year+1;
	//	System.out.println(nowTotalMonth-totalMonth);
		System.out.println(age); //만나이
		System.out.println(koreanAge);//한국나이
		

		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
