package api.file;

import java.io.File;
import java.util.Scanner;

public class Test02_1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		String name=sc.next();
		File target =new File(name);
		
		
		if(target.isFile()) { //파일이면 이름+확장자+크기
			System.out.println("<파일정보>");
			System.out.println("이름: " + target.getName());
			System.out.println("확장자 : ?");
			System.out.println("크기 : " +target.length() + "bytes");
		}
		else if(target.isDirectory()) {//디렉터라면 목록[파일/폴더]
			File[] list=target.listFiles();
			for(File file: list) {
				if(file.isFile()) {//파일이면
					System.out.print("[파일]");
				}
				else if(file.isDirectory()) { //디렉터라면
					System.out.print("[폴더]");
				}
				System.out.println(file.getName());
			}
		}
		else {
			System.out.println("존재하지 않는 파일 또는 폴더");
		}
	}
}
