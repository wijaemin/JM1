package array;

import java.util.Scanner;

public class Test08 {

	public static void main(String[] args) {
		/*학생 5명의 시험점수를 입력받아서 저장하고 다음 문제를 푸세요.
		 * 
		 * 1.통과하지 못한 학생의 점수만 출력
		 * 2.우수한 성적(90점 이상)으로 통과한 학생의 점수만 출력
		 * 3.만약 75점인 학생이 전학을 왔다면 몇 등인지 구해서 출력
		 * 
		 */
		Scanner sc= new Scanner(System.in);
		
		int[] exam= new int[5];
		
		for(int i=0;i<exam.length;i++) {
			System.out.print("점수 : ");
			exam[i]=sc.nextInt();
		}	
		
		System.out.println("재평가자 점수는 다음과 같습니다");
		for(int i = 0;i<exam.length;i++) {
			if(exam[i]<60) {
				System.out.println("통과하지못한 학생의 점수 = " +exam[i]);
			}
		}
		for(int i = 0;i<exam.length;i++) {
			if(exam[i]>=90) {
				System.out.println("우수한 성적으로 통과하 학생의 점수 = " +exam[i]);
			}
		}
		
		int count=0;
		for(int i=0; i<exam.length;i++) {
			if(exam[i]>75) {
				count++;
			}
		}
		System.out.println("count = " + count);
		
		int rank=count+1;
		System.out.println("예상 등수 = " + rank);
		
	}

}
