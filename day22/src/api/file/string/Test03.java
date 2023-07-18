package api.file.string;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) throws IOException {
		Scanner sc= new Scanner(System.in);
		
		File target= new File("sample/note.kh");
		FileWriter fw= new FileWriter(target);
		BufferedWriter bw= new BufferedWriter(fw);
		
		while(true) {
			System.out.print("입력 : ");
//			bw.write(sc.next());
			String a=sc.nextLine();
			bw.write(a);
			if(a.equals("종료")) {
				break;
			}
			bw.write("\n");
			bw.flush();
		}
		bw.close();
		sc.close();
	}
}
