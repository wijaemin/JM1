package api.file.object;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class Test02 {
	public static void main(String[] args) throws IOException {
		
		//데이터
//		Date d = new Date();
		List<Integer> lotto = List.of(5, 12, 13, 17, 33, 41);
		
		//출력
		File target = new File("sample/lotto.kh");
		
		FileOutputStream stream = new FileOutputStream(target);
		BufferedOutputStream buffer = new BufferedOutputStream(stream);
		ObjectOutputStream obj = new ObjectOutputStream(buffer);
		
		obj.writeObject(lotto);
		
		obj.close();
	}
}








