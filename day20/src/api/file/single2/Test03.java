package api.file.single2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Test03 {
	public static void main (String[] args) throws IOException {
		
		byte[]buffer=new byte[1024];		
		
		File target =new File("D:/origin.txt");//절대경로(absolute path)
		FileInputStream stream =new FileInputStream(target);
		
		File target1 =new File("sample","copy.txt");//상대경로(relative path)
		FileOutputStream stream1=new FileOutputStream(target1);

		
		
		while(true) {
			int size=stream.read(buffer);
			if(size==-1) break;
			stream1.write(size);
		}
		stream.close();
	}
}
