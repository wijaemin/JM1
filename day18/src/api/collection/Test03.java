package api.collection;

import java.util.ArrayList;
import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
	//입력도구 생성
	Scanner sc =new Scanner(System.in);
	//저장소 생성
	ArrayList<String>list=new ArrayList<>();
	
	while(true) {
		System.out.print("리스트에 나라추가 : ");
		String input=sc.next(); //나라 입력
			if(list.contains(input)) {
				System.out.println("게임오버!");
				break;
			}
			else {
				list.add(input); //나라를 리스트에 추가
			}
		}
		System.out.println(list);
		}
	}

