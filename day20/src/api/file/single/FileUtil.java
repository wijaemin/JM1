package api.file.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {
	//파일 복사 메소드
	public static void copy(File target,File target1) throws IOException {
		FileInputStream stream =new FileInputStream(target);
		FileOutputStream stream1=new FileOutputStream(target1);
		
		while(true) {
			
			int a=stream.read();
			if(a==-1) {
				break;
			}
			stream1.write(a);
		}
		stream.close();
		stream1.close();
		
	}
}
