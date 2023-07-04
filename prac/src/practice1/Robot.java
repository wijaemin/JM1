package practice1;

import java.util.Random;

public class Robot {
	public static int square(int side) {
		return side*side;
	}
	public static float triangle(int side,int high) {
		return (float)side * high * 1/2;
	}
	public static float circle(int radius) {
		return radius *3.14f;
	}
	public static void sort(int[]data) {
		for(int j=0;j<data.length-1;j++) {
			int min=j;
			for(int i =j+1;i<data.length;i++) {
				if(data[min]>data[i]) {
					min=i;
				}
			}
		int backup=data[j];
		data[j]=data[min];
		data[min]=backup;
		}
		
	}
	public static void reverse(int[]data) {
		int left = 0;
		int right = data.length-1;
		
		for(int i=0; i < data.length/2; i++) {
			int backup = data[left];
			data[left] = data[right];
			data[right] = backup;
			
			left++;
			right--;
		}
	}
	
	public static void shuffle(int[]data) {
Random r= new Random();
		
		for(int i=0;i<data.length;i++) {
			int random=r.nextInt(data.length);//0,1,2,3,4,5,6	
			
			if(i==random) { //같은 자리면 다시
				i--;
				continue;
			}
		
			int backup=data[i];
			data[i]=data[random];
			data[random]=backup;
		
		}
	}
	
	
	
	
	
	
}
