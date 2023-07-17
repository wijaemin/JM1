package api.file.object;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class Test04 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		File target= new File("sample/lotto.kh");
		
		FileInputStream stream =new FileInputStream(target);
		BufferedInputStream buffer =new BufferedInputStream(stream);
		ObjectInputStream obj=new ObjectInputStream(buffer);
		
		
		List<Integer>lotto =(List<Integer>) obj.readObject();
		System.out.println(lotto);
		
		//정리
		obj.close();
	}
}
