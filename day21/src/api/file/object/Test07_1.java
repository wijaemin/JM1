package api.file.object;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Test07_1 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Scanner sc= new Scanner(System.in);
		System.out.println("게임시작!");
		File target = new File("sample/player.kh");
		
		Player p;
		if(target.exists()) {
			
			FileInputStream stream =new FileInputStream(target);
			BufferedInputStream buffer =new BufferedInputStream(stream);
			ObjectInputStream obj=new ObjectInputStream(buffer);
			
			 p=(Player) obj.readObject();
			while(true) {
				
				System.out.print("입력(1-정보출력/2-레벨업/3-종료) : ");
				int num=sc.nextInt();
				if(num==1) {
					p.show();
				}
				else if(num==2) {
					System.out.println("레벨이 1 증가했습니다!");
					p.getPlusLevel();
					
				}
				else if(num==3) {
					System.out.println("정보를 저장하였습니다");
					System.out.println("프로그램을 종료합니다");
					
					break;
				}
			}
			
			
		}
		else {
			System.out.print("아이디를 설정하세요 : ");
			String id=sc.next();
			
			 p = new Player(id);
			
			while(true) {
				
				System.out.print("입력(1-정보출력/2-레벨업/3-종료) : ");
				int num=sc.nextInt();
				if(num==1) {
					p.show();
				}
				else if(num==2) {
					System.out.println("레벨이 1 증가했습니다!");
					p.getPlusLevel();
					
				}
				else if(num==3) {
					System.out.println("정보를 저장하였습니다");
					System.out.println("프로그램을 종료합니다");
					
					break;
				}
			}
		
		}
		FileOutputStream stream = new FileOutputStream(target);
		BufferedOutputStream buffer = new BufferedOutputStream(stream);
		ObjectOutputStream obj = new ObjectOutputStream(buffer);
		
		obj.writeObject(p);
		
		
		obj.close();
		sc.close();
			
		
	
	}
}
