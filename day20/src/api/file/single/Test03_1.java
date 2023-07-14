package api.file.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test03_1 {
	public static void main(String[] args) throws IOException {
		File target =new File("D:/","origin.txt");//절대경로(absolute path)
		File target1 =new File("sample","copy.txt");//상대경로(relative path)
		
		FileUtil.copy(target, target1);
	}
}
