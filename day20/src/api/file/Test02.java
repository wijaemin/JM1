package api.file;

import java.io.File;
import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		String name=sc.next();
		File file =new File(name);
		
		
		if(file.exists()) {
			if(file.isFile()) {
				String fileName=file.getName();
				String ext =fileName.substring(fileName.lastIndexOf(".")+1);
				System.out.println("파일명 : " +fileName);
				System.out.println("확장자 : " +ext);
				System.out.println("크기 : " +file.length() +"byte");
			}
			if(file.isDirectory()) {
				String fileName=file.getName();
				String ext =fileName.substring(fileName.lastIndexOf(".")+1);
				String[] names=file.list();
				for(String list:names) {
					System.out.println(list + "[폴더]");
				}
			}
		}
		else {
			System.out.println("존재하지 않는 파일 또는 폴더");
		}
	}
}
