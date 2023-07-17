package api.file.object;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Test08 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		File target= new File("sample/player.kh");
		
		FileInputStream stream =new FileInputStream(target);
		BufferedInputStream buffer =new BufferedInputStream(stream);
		ObjectInputStream obj=new ObjectInputStream(buffer);
		
		Player p=(Player) obj.readObject();
		
		obj.close();
		p.show();
	}
}
