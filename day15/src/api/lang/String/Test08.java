package api.lang.String;

import java.util.Scanner;

public class Test08 {
	public static void main(String[] args)	{
		Scanner sc= new Scanner(System.in);
		String line= sc.nextLine();
	//수박씨,신발끝,개나리,십장생,시베리아,주옥,조카,게불,10원
		String []word=new String[] {"수박씨","신발끈","개나리","십장생","시베리아",
				"주옥","조카","게불","10원"};
		
		
		for(int i=0;i<word.length;i++) {
				line=line.replace(word[i],"***");
		}
		System.out.println(line);
	}
}
