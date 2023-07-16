package api.file;

import java.io.File;

public class Test02 {
	public static void main(String[] args) {
	
		//경로 준비
		String input = "A:/test.txt";	//파일
		//String input = "D:/study";		//디렉터리
		//String input = "D:/study2";	//존재하지 않는 대상
		
		//분석을 하려면 파일 객체를 생성해야함
		File target = new File(input);
		
		if(target.isFile()) {//파일이면
			System.out.println("파일");
		}
		else if(target.isDirectory()) {//디렉터리면
			System.out.println("디렉터리");
		}
		else {//없으면
			System.out.println("존재하지 않는 파일 또는 폴더");
		}
	}
}





