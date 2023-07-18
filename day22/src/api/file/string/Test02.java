package api.file.string;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Test02 {
	public static void main(String[] args) throws IOException {
		//문자열 출력
		// = 문자열 출력은 필연적으로 인코딩이 필요
		File directory=new File("sample");
		directory.mkdirs();
		File target =new File(directory,"string.kh");
//		FileOutputStream stream= new FileOutputStream(target);
		FileWriter fw=new FileWriter(target);
//		BufferedOutputStream buffer =new BufferedOutputStream(stream);
		BufferedWriter bw =new BufferedWriter(fw);
		
		//출력
		bw.write("Hello");
		bw.write("\n");
		bw.write("안녕하세요");
		bw.write("\n");
		bw.write("반가워요");
		//정리
		//bw.flush();
		bw.close();
		
	}
}





