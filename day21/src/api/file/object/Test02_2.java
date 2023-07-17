package api.file.object;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Random;
import java.util.Scanner;

public class Test02_2 {
	public static void main(String[] args) throws IOException {
		//진짜 아무거나 저장이 되나?
		
		//데이터
		Random r = new Random();//ok
//		Scanner sc = new Scanner(System.in);//nok
		
		//출력
		File target = new File("sample/object2.kh");
		
		FileOutputStream stream = new FileOutputStream(target);
		BufferedOutputStream buffer = new BufferedOutputStream(stream);
		ObjectOutputStream obj = new ObjectOutputStream(buffer);
		
		obj.writeObject(r);
		
		obj.close();
	}
}








