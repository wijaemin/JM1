package data;

public class Test10_1 {

	public static void main(String[] args) {
		int yesterdayHour = 2, yesterdayMin = 45;
		int todayHour = 1, todayMin = 50;
		
		int totalMin =(yesterdayMin + todayMin) % 60;
		int totalHour = yesterdayHour + todayHour + (yesterdayMin + todayMin)/60;
		
		System.out.println(totalHour);
		System.out.println(totalMin);
		
		System.out.println(totalHour + "시간 " + totalMin + "분");
		
		
	}

}
