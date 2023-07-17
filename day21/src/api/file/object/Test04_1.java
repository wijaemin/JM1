package api.file.object;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Set;

public class Test04_1 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		File target= new File("sample/lotto.kh");
		
		FileInputStream stream =new FileInputStream(target);
		BufferedInputStream buffer =new BufferedInputStream(stream);
		ObjectInputStream obj=new ObjectInputStream(buffer);
		
		
		Set<Integer>lotto =(Set<Integer>) obj.readObject();
		for(int number : lotto) {
			System.out.println(number);
		}
		obj.close();
	}
}
