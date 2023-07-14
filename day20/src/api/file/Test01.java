package api.file;

import java.io.File;

public class Test01 {
	public static void main(String[] args) {
		//파일(File)제어
		//-파일은 무엇인가 글자를 저장하는 저장소
		///						파일이 크다는 것은 보관하는 글자가 많다는 소리
		//-폴더는 무엇인가? 파일을 구부하기 위한 장치
								//디렉터리(directory)라고 부름
								//크기가 없음(내부 파일의 합계
		
		//-자바에서 파일과 폴더는 어떻게 처리하는가?
		// java.io 패키지 (블로킹 방식())
		// java.nio 패키지 (논블로킹 방식)
		
		//FIle 클래스객체 생성
		File a= new File("D:/test.txt");
		File b= new File("D:/","test.txt");
		
	
		
		//파일 정보 분석
		System.out.println(a.exists()); //진짜 있냐?
		System.out.println(b.exists());
		
		System.out.println(a.isDirectory()); //디렉터리야?
		
		System.out.println(a.isFile()); //파일이야?
		if(a.isFile()) {
			System.out.println(a.getName()); //이름이 뭐야?
			System.out.println(a.getPath()); //위치가 어디야
			System.out.println(a.length()); //파일의 크기(=들어있는 글자의 수)
			System.out.println(a.lastModified()); //최종 수정시간
		}
		
		//디렉터리도 File 클래스로 제어한다
		File c= new File("D:/");
		File d =new File("D:\\");
		
		if(c.isDirectory()) {
			System.out.println(c.getName());
			System.out.println(c.getPath());
			System.out.println(c.length());//(주의) 디렉터리의 크기는 의미가 없다
			//디렉터리는 내부에 존재하는 요소들을 추출할 수있다
			System.out.println(c.listFiles());
			System.out.println("============");
			String[] names= c.list(); //이름만 추출
			File[] files= c.listFiles();// 파일 객체를 추출(이름+나머지 정보)
			for(File file :files) {
				System.out.println(file);
			}
			
			
		}
		
		
		
		
		
		
	}
}