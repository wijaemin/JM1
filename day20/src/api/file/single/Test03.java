package api.file.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test03 {
	public static void main(String[] args) throws IOException {
		File target =new File("A:/","origin.txt");//절대경로(absolute path)
		FileInputStream stream =new FileInputStream(target);
		

		
		File target1 =new File("sample","copy.txt");//상대경로(relative path)
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
