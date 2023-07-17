package api.file.single2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class Test03 {
	public static void main(String[] args) throws IOException{
		
		byte[] buffer=new byte[8192];
		
		File readTarget= new File("D:/origin.txt");
		FileInputStream readStream = new FileInputStream(readTarget);
		
		File writeTarget= new File("./sample/copy.txt");
		FileOutputStream writeStream =new FileOutputStream(writeTarget);
		
		long start = System.currentTimeMillis();
		long count = 0L;
		long total = readTarget.length();
		DecimalFormat fmt = new DecimalFormat("#,##0.00");
		while (true) {
			int size= readStream.read();
			if(size==-1)break;
			writeStream.write(buffer,0,size);
			count++;
			double percent = count*100d/ total;
			System.out.println(count + "/" + total + "("+fmt.format(percent)+"%)");
		}
		
		
		long end = System.currentTimeMillis();
		
		
		System.out.println("실행시간 :" +(end -start));
		readStream.close();
		writeStream.close();
	}
}